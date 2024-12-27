package com.firstProjectRT.projectRT.config;

import com.firstProjectRT.projectRT.entities.Order;
import com.firstProjectRT.projectRT.entities.User;
import com.firstProjectRT.projectRT.entities.enums.OrderStatus;
import com.firstProjectRT.projectRT.repositories.OrderRepository;
import com.firstProjectRT.projectRT.repositories.UserRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.lang.reflect.Array;
import java.time.Instant;
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

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {

//        Convertendo conteudos java instanciados manualmente para a base de dados
        User u1 = new User(null,"Marcelo","marcelo@email.com","123456789","54321");
        User u2 = new User(null,"Noronha","noronha@email.com","12345121369","12345");

        Order o1 = new Order(null, Instant.parse("2024-12-27T09:35:01Z"),u1, OrderStatus.PAID);
        Order o2 = new Order(null, Instant.parse("2023-10-12T09:35:01Z"),u2, OrderStatus.WAITING_PAYMENT);
        Order o3 = new Order(null, Instant.parse("2024-11-01T09:35:01Z"),u1, OrderStatus.WAITING_PAYMENT);

        userRepository.saveAll(Arrays.asList(u1,u2));
        orderRepository.saveAll(Arrays.asList(o1,o2,o3));

    }
}
