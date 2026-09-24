package br.com.aweb.sistama_produto.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.com.aweb.sistama_produto.model.AppUser;
import br.com.aweb.sistama_produto.model.UserRole;
import br.com.aweb.sistama_produto.service.AppUserService;

@Component
public class DataSeeder implements CommandLineRunner {

    @Autowired
    private AppUserService userService;

    // cria um usuário admin padrão se ainda não existir nenhum (evita ficar sem acesso após ligar a segurança)
    @Override
    public void run(String... args) {
        if (userService.getAllUsers().isEmpty()) {
            AppUser admin = new AppUser();
            admin.setUsername("admin");
            admin.setPassword("admin123");
            admin.setRole(UserRole.ADMIN);
            userService.createUser(admin);
        }
    }
}
