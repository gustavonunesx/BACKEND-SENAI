package api;

import static spark.Spark.after;
import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;
import static spark.Spark.put;
import static spark.Spark.delete;

import com.google.gson.Gson;

import dao.TarefaDAO;
import model.Tarefa;
import spark.Filter;
import spark.Request;
import spark.Response;
import spark.Route;

public class ApiTarefa {

    private static final TarefaDAO dao = new TarefaDAO();
    private static final Gson gson = new Gson();

    private static final String APPLICATION_JSON = "application/json";

    public static void main(String[] args) {
        port(4567);

        // Define que todas as respostas serão JSON
        after(new Filter() {
            @Override
            public void handle(Request request, Response response) {
                response.type(APPLICATION_JSON);
            }
        });

        // GET /produtos - Buscar todos
        get("/tarefas", new Route() {
            @Override
            public Object handle(Request request, Response response) {
                return gson.toJson(dao.buscarTodos());
            }
        });

        // GET /produtos/:id - Buscar por ID
        get("/tarefas/:id", new Route() {
            @Override
            public Object handle(Request request, Response response) {
                try {
                    Long id = Long.parseLong(request.params(":id"));
                    Tarefa tarefa = dao.buscarPorId(id);

                    if (tarefa != null) {
                        return gson.toJson(tarefa);
                    } else {
                        response.status(404);
                        return "{\"mensagem\": \"Tarefa com ID " + id + " não encontrada.\"}";
                    }
                } catch (NumberFormatException e) {
                    response.status(400);
                    return "{\"mensagem\": \"ID inválido.\"}";
                }
            }
        });

        // POST /produtos - Criar novo produto
        post("/tarefas", new Route() {
            @Override
            public Object handle(Request request, Response response) {
                try {
                    Tarefa novaTarefa = gson.fromJson(request.body(), Tarefa.class);
                    dao.inserir(novaTarefa);

                    response.status(201); // Created
                    return gson.toJson(novaTarefa);
                } catch (Exception e) {
                    response.status(500);
                    System.err.println("Erro ao processar requisição POST: " + e.getMessage());
                    e.printStackTrace();
                    return "{\"mensagem\": \"Erro ao cadastrar a tarefa.\"}";
                }
            }
        });

        // PUT /produtos/:id - Atualizar produto existente
        put("/tarefas/:id", new Route() {
            @Override
            public Object handle(Request request, Response response) {
                try {
                    Long id = Long.parseLong(request.params(":id"));

                    Tarefa tarefaExistente = dao.buscarPorId(id);
                    if (tarefaExistente == null) {
                        response.status(404);
                        return "{\"mensagem\": \"Tarefa não encontrada para atualização.\"}";
                    }

                    Tarefa tarefaAtualizada = gson.fromJson(request.body(), Tarefa.class);
                    tarefaAtualizada.setId(id);

                    dao.atualizar(tarefaAtualizada);

                    response.status(200);
                    return gson.toJson(tarefaAtualizada);

                } catch (NumberFormatException e) {
                    response.status(400);
                    return "{\"mensagem\": \"ID inválido no formato.\"}";
                } catch (Exception e) {
                    response.status(500);
                    System.err.println("Erro ao processar requisição PUT: " + e.getMessage());
                    e.printStackTrace();
                    return "{\"mensagem\": \"Erro ao atualizar a tarefa.\"}";
                }
            }
        });

        // DELETE /produtos/:id - Deletar produto
        delete("/tarefas/:id", new Route() {
            @Override
            public Object handle(Request request, Response response) {
                try {
                    Long id = Long.parseLong(request.params(":id"));

                    Tarefa tarefaExistente = dao.buscarPorId(id);
                    if (tarefaExistente == null) {
                        response.status(404);
                        return "{\"mensagem\": \"Tarefa não encontrada para exclusão.\"}";
                    }

                    dao.deletar(id);
                    response.status(204); // No Content
                    return ""; // sem corpo na resposta

                } catch (NumberFormatException e) {
                    response.status(400);
                    return "{\"mensagem\": \"ID inválido no formato.\"}";
                } catch (Exception e) {
                    response.status(500);
                    System.err.println("Erro ao processar requisição DELETE: " + e.getMessage());
                    e.printStackTrace();
                    return "{\"mensagem\": \"Erro ao excluir a tarefa.\"}";
                }
            }
        });
    }
}
