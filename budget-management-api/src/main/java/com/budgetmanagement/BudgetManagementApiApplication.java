package com.budgetmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.budgetmanagement.entity")  // 👈 Ensures entities are found
@EnableJpaRepositories(basePackages = "com.budgetmanagement.repository")  // 👈 Ensures repositories are found
public class BudgetManagementApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(BudgetManagementApiApplication.class, args);
    }
}
