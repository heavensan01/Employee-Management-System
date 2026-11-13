package com.example.ems;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmployeeManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeManagementApplication.class, args);
    }

    @Bean
    CommandLineRunner printApplicationUrl() {
        return args -> {
            System.out.println();
            System.out.println("==============================================");
            System.out.println("  Employee Management System is running!");
            System.out.println("  Open: http://localhost:8080");
            System.out.println("==============================================");
            System.out.println();
        };
    }
}