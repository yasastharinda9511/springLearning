package com.springLearning.springLearning;

import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

@Component
public class DBCheck {

    @PostConstruct
    public void checkDriver() {
        try {
            System.out.println("Loading PostgreSQL Driver...");
            Class.forName("org.postgresql.Driver");
            System.out.println("PostgreSQL Driver Loaded Successfully.");
        } catch (ClassNotFoundException e) {
            System.err.println("PostgreSQL Driver NOT FOUND: " + e.getMessage());
        }
    }
}
