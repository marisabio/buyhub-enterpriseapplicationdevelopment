package org.buyhub;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) throws Exception {
        var entityManagerFactory = Persistence.createEntityManagerFactory("oracle");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        SpringApplication.run(Main.class, args);
    }
}