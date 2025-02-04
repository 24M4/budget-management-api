package com.budgetmanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Entity representing a budget category.
 */
@Entity
@Getter
@Setter
@Table(name = "category")  //  Ensures correct table name
public class Category {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //  Auto-increments ID
    private Long id;

    @Column(nullable = false, unique = true)  //  Category name must be unique
    private String name;
}
