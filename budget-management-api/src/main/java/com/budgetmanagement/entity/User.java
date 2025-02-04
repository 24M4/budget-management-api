package com.budgetmanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**
 * Entity representing a system user.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users") //  Ensures table name consistency
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //  Auto-increments ID
    private Long id;

    @Column(nullable = false, unique = true)  //  Username must be unique
    private String username;

    @Column(nullable = false)  //  Password should always be present
    private String password;

    @Column(nullable = false)  //  Role should always be present
    private String role;

    /**
     * Custom constructor for creating a user.
     *
     * @param username User's username.
     * @param password User's password (should be encoded before saving).
     * @param role User's role (USER or ADMIN).
     */
    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
}
