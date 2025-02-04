package com.budgetmanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Entity representing a financial transaction.
 */
@Entity
@Getter
@Setter
public class Transaction {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //  Auto-increments ID
    private Long id;

    @Column(nullable = false)
    private String type; //  Should be either "INCOME" or "EXPENSE"

    @Column(nullable = false)
    private double amount; //  Amount of the transaction

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)  //  Foreign key to Category table
    private Category category;
}
