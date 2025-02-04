package com.budgetmanagement.repository;

import com.budgetmanagement.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing Transaction entity persistence.
 */
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
