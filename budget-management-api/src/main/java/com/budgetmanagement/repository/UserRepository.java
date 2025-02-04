package com.budgetmanagement.repository;

import com.budgetmanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing User entity persistence.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    /**
     * Finds a user by their username.
     *
     * @param username The username of the user.
     * @return The user entity if found.
     */
    User findByUsername(String username);
}
