package com.budgetmanagement.service;

import com.budgetmanagement.entity.Transaction;
import com.budgetmanagement.repository.TransactionRepository;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Service class for handling financial transactions.
 */
@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;

    /**
     * Constructor for injecting TransactionRepository.
     */
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    /**
     * Adds a new transaction to the database.
     */
    public Transaction addTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    /**
     * Retrieves all transactions from the database.
     */
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }
}
