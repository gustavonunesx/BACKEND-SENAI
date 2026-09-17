# Plano de implementação — Sistema de Vendas (sistama-produto)

Documento de continuidade para retomar o desenvolvimento em outra sessão. Reflete o estado em 2026-09-17.

## Como estamos trabalhando

- Ordem de implementação definida: seguir dependência técnica (não a ordem do quadro DOING/TO-DO).
- Depois de cada item finalizado e testado (build + fluxo completo via curl/browser), a IA para e o usuário (Gustavo) commita e dá push manualmente. A IA **não** cria commits nem aparece como colaborador no repositório — nenhuma ação de `git commit`/`git push` deve ser feita pela IA neste projeto.
- Autenticação/permissões: decidido usar **Spring Security** (não sessão manual via HttpSession).
- Convenção adotada: tabelas JPA sempre com `@Table(name = "...")` no plural (`products`, `clients`, ...), já que `data.sql`/scripts assumem nomes no plural e o Hibernate por padrão geraria singular.
- Padrão de CRUD por módulo (usado em Produtos e Clientes, repetir nos próximos):
  - `model/`: entidade com Bean Validation.
  - `repository/`: `JpaRepository`, com métodos `existsByX` / `existsByXAndIdNot` quando há campo único (para permitir edição sem falso positivo de duplicidade contra o próprio registro).
  - `service/`: CRUD + regras de checagem de unicidade.
  - `controller/`: `list` (`GET /modulo`), `new` (`GET /modulo/new`), `edit` (`GET /modulo/edit/{id}`), `save` (`POST /modulo/save`), `update` (`POST /modulo/update/{id}`), `delete` (`GET /modulo/delete/{id}`, com `confirm()` no HTML).
  - `templates/modulo/list.html` (tabela Bootstrap) e `form.html` (cadastro + edição no mesmo template).
  - Link novo na navbar (`templates/fragments/navbar.html`).

## Status atual

### ✅ Concluído (commitado)
- **Estrutura Spring Boot MVC** — entity/repository/service/controller, Thymeleaf, static em resources.
- **[Produtos] Listagem / Cadastro / Alteração / Exclusão (HTML)** — CRUD completo com campo `quantity` (estoque) adicionado. Telas em `templates/product/`.
  - Bug corrigido: tabela gerada pelo Hibernate era `product` mas `data.sql` inseria em `products` → adicionado `@Table(name = "products")`.
  - Bug corrigido: `data.sql` inseria IDs fixos (1,2,3) e travava o próximo `IDENTITY` gerado pelo H2, causando `DataIntegrityViolationException` ao salvar o 1º produto pela tela → removidos os IDs fixos do seed.

### ✅ Concluído (aguardando commit do usuário na sessão anterior — confirmar se já foi commitado)
- **[Cliente] Cadastro / Listagem / Alteração / Exclusão (HTML)** — CRUD completo:
  - `model/Address.java` (`@Embeddable`): logradouro, número/complemento opcionais, bairro, cidade, UF, CEP.
  - `model/Client.java`: nome completo, e-mail (único + `@Email`), CPF (único + validador customizado), telefone, endereço embutido.
  - `validation/CPF.java` + `CPFValidator.java`: validador com o algoritmo real de dígito verificador do CPF (não é só regex — rejeita `111.111.111-11` etc.).
  - `repository/ClientRepository.java`, `service/ClientService.java`, `controller/ClientController.java`.
  - `templates/client/list.html`, `templates/client/form.html`.
  - Link "Clientes" na navbar.
  - Testado: CRUD completo, duplicidade de e-mail/CPF bloqueada, CPF inválido rejeitado, edição sem falso positivo de duplicidade.

**⚠️ Ação ao retomar:** rodar `git status` / `git log` para confirmar se o módulo de Clientes já foi commitado e pushado antes de seguir.

## Próximos itens (nesta ordem)

### 3. [Banco] PostgreSQL em Docker
- Já existe um `docker-compose.yaml` não commitado no projeto (WIP do usuário) com **dois bugs a corrigir**:
  1. Linha 1 tem o texto literal `docker-compose.yaml` dentro do próprio arquivo YAML (inválido).
  2. Volume aponta para `/var/lib/postgresql/postgres_data`, mas o diretório correto de dados do Postgres é `/var/lib/postgresql/data`.
- Tarefas:
  - Corrigir `docker-compose.yaml` (serviço `db`, usuário/senha, banco `sistema_vendas`, volume nomeado persistente).
  - Adicionar dependência `org.postgresql:postgresql` no `pom.xml` (hoje só tem H2).
  - Atualizar `application.properties` para apontar para Postgres (ou criar um profile separado, ex. `application-prod.properties`, mantendo H2 para testes/dev local se fizer sentido — decidir com o usuário se quer trocar H2 totalmente ou manter H2 para desenvolvimento rápido e Postgres via Docker para "produção"/entrega).
  - Subir o container via `docker compose up -d` e validar que a aplicação conecta e roda as migrations/DDL corretamente.
  - **Pendência de decisão:** confirmar com o usuário se o Docker está disponível/rodando no ambiente de teste antes de tentar subir o container.

### 4. [Pedidos] Registro / Cancelamento / Atualização / Listagem
Maior item em complexidade — envolve relacionamento com Produto, Cliente e regras de negócio de estoque.
- `model/Order.java` (Pedido): cliente (`@ManyToOne`), status (`enum`: `ATIVO`, `CANCELADO`), data/hora (calculada automaticamente no momento da criação), valor total (calculado, não editável manualmente).
- `model/OrderItem.java` (item do pedido): pedido (`@ManyToOne`), produto (`@ManyToOne`), quantidade, preço unitário no momento da compra (snapshot, não referenciar preço atual do produto).
- Regras de negócio no `service`:
  - Ao criar pedido: validar estoque disponível por produto, debitar do estoque, calcular valor total = soma(quantidade × preço unitário).
  - Ao cancelar: mudar status para `CANCELADO`, **devolver quantidades ao estoque**, **não excluir o registro**.
  - Ao atualizar pedido não finalizado (status `ATIVO`): permitir adicionar/remover itens e alterar quantidades, recalculando estoque (devolver o que foi removido, debitar o que foi adicionado) e valor total.
  - Bloquear edição de pedidos com status `CANCELADO`.
- Formulário HTML: seleção de cliente, seleção de múltiplos produtos com quantidade (mínimo 1 produto), exibição de data/hora e valor total calculados (não editáveis pelo usuário).
- Listagem: cliente, produtos, quantidades, valor total, data/hora, status — com botão de cancelar (com confirmação) e editar (só se `ATIVO`).
- **Pendência de decisão:** UI de seleção de múltiplos produtos com quantidade — perguntar ao usuário se prefere uma tabela dinâmica com JS (adicionar linha de produto/quantidade) ou uma abordagem mais simples (ex. lista fixa de checkboxes + input de quantidade) dado o nível da disciplina.

### 5. [Usuário] Cadastro de Usuários + Autenticação (Spring Security)
- Adicionar dependência `spring-boot-starter-security` no `pom.xml`.
- `model/User.java`: username (único), senha (armazenada com `BCryptPasswordEncoder`), perfil de acesso (`enum Role { ADMIN, USER }`).
- `repository/UserRepository.java`, implementar `UserDetailsService` customizado.
- `SecurityConfig.java`: configurar `SecurityFilterChain`, login form HTML customizado (`/login`), logout, sessão HTTP padrão do Spring Security.
- Tela de login HTML (usuário, senha) e formulário de cadastro de usuário (username, senha, perfil — provavelmente restrito a ADMIN criar outros usuários).
- Criptografar senha antes de salvar no `service`.

### 6. [Permissões] Controle de acesso por perfil
- Usar `@PreAuthorize` ou regras no `SecurityFilterChain` (`.requestMatchers(...).hasRole(...)`):
  - Administrador: acesso completo (produtos, clientes, pedidos, usuários).
  - Usuário comum: acesso restrito a vendas e consultas (provavelmente: pedidos + listagens de produto/cliente, sem cadastro/exclusão de produto/cliente/usuário — **confirmar com o usuário a granularidade exata** antes de implementar, já que o TO-DO não detalha regra por regra).
- Esconder/mostrar botões na navbar e nos templates conforme o perfil logado (`sec:authorize` do thymeleaf-extras-springsecurity6, dependência a adicionar).

### 7. [Docker] Aplicação Spring Boot em Docker
- `Dockerfile` multi-stage (build com Maven + imagem final `eclipse-temurin` ou similar, só com o jar).
- Atualizar `docker-compose.yaml` para incluir o serviço da aplicação (`app`) + `db` (Postgres), com `depends_on` e variáveis de ambiente para a connection string do banco.

### 8. [Front] Polimento Bootstrap geral
- Revisão final de todas as telas: alerts de sucesso/erro (hoje as ações redirecionam sem mensagem de feedback — considerar flash messages via `RedirectAttributes`), cards, responsividade, consistência visual entre os módulos.

## Coisas para verificar/perguntar ao retomar
1. Módulo de Clientes já foi commitado?
2. Docker está instalado e rodando no ambiente onde os testes serão feitos (necessário para os itens 3 e 7)?
3. Vamos manter H2 para dev local e usar Postgres só via Docker, ou trocar tudo para Postgres desde já?
4. Regra exata de permissão do "Usuário comum" em Pedidos/Produtos/Clientes (o TO-DO só diz "restrito a vendas e consultas").
5. UI de seleção de produtos no formulário de Pedido (tabela dinâmica JS vs. abordagem simples).
