package com.firstProjectRT.projectRT.config;

import com.firstProjectRT.projectRT.entities.User;
import com.firstProjectRT.projectRT.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

//Classe criada exclusivamente para a configuração do perfil de Teste, é necessário passar
//A anotação @Configuration e a @Profile (Nome do perfil)


@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

//  Realizando uma injeção de dependência
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

//        Convertendo conteudos java instanciados manualmente para a base de dados
        User u1 = new User(null,"Marcelo","marcelo@email.com","123456789","54321");
        User u2 = new User(null,"Noronha","noronha@email.com","12345121369","12345");

        userRepository.saveAll(Arrays.asList(u1,u2));

    }
}
