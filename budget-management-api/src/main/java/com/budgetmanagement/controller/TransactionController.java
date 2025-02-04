package com.budgetmanagement.controller;

import com.budgetmanagement.entity.Transaction;
import com.budgetmanagement.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for managing financial transactions.
 * Provides endpoints for adding and retrieving transactions.
 */
@RestController
@RequestMapping("/api/transactions") // Base URL for transaction-related operations
public class TransactionController {

    private final TransactionService transactionService;

    /**
     * Constructor to inject the TransactionService dependency.
     *
     * @param transactionService Service layer for transaction operations.
     */
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    /**
     * Adds a new financial transaction.
     *
     * @param transaction The transaction object received in the request body.
     * @return The created transaction.
     */
    @PostMapping("/add")
    public ResponseEntity<Transaction> addTransaction(@RequestBody Transaction transaction) {
        return ResponseEntity.ok(transactionService.addTransaction(transaction));
    }

    /**
     * Retrieves a list of all transactions.
     *
     * @return A list of all transactions in the system.
     */
    @GetMapping("/list")
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        return ResponseEntity.ok(transactionService.getAllTransactions());
    }
}
