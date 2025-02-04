package com.budgetmanagement;

import com.budgetmanagement.entity.Transaction;
import com.budgetmanagement.repository.TransactionRepository;
import com.budgetmanagement.service.TransactionService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;





/**
 * Unit test for TransactionService.
 */
class TransactionServiceTest {
    private TransactionService transactionService;
    private TransactionRepository transactionRepository;

    /**
     * Sets up mock dependencies before each test.
     */
    @BeforeEach
    void setUp() {
        transactionRepository = mock(TransactionRepository.class);
        transactionService = new TransactionService(transactionRepository);
    }

    /**
     * Tests retrieval of all transactions.
     */
    @Test
    void testGetAllTransactions() {
        // Create test transactions
        Transaction transaction1 = new Transaction();
        transaction1.setType("INCOME");
        transaction1.setAmount(500.00);

        Transaction transaction2 = new Transaction();
        transaction2.setType("EXPENSE");
        transaction2.setAmount(200.00);

        // Mock repository behavior
        when(transactionRepository.findAll()).thenReturn(Arrays.asList(transaction1, transaction2));

        // Call service method
        List<Transaction> transactions = transactionService.getAllTransactions();

        // Assertions
        assertEquals(2, transactions.size());
        verify(transactionRepository, times(1)).findAll();
    }
}
