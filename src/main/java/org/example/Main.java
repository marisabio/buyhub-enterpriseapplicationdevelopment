package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) throws Exception {
        var entityManagerFactory = Persistence.createEntityManagerFactory("oracle");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
    }
}