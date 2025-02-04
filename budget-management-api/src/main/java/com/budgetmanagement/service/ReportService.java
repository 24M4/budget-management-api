package com.budgetmanagement.service;

import com.budgetmanagement.entity.Transaction;
import com.budgetmanagement.repository.TransactionRepository;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Service class for generating financial reports.
 */
@Service
public class ReportService {

    private final TransactionRepository transactionRepository;

    public ReportService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    /**
     * Generates a financial summary report.
     */
    public Map<String, Object> generateSummary(String category, String startDate, String endDate) {
        List<Transaction> transactions = transactionRepository.findAll();

        double totalIncome = transactions.stream()
                .filter(t -> "INCOME".equals(t.getType()))
                .mapToDouble(Transaction::getAmount).sum();

        double totalExpenses = transactions.stream()
                .filter(t -> "EXPENSE".equals(t.getType()))
                .mapToDouble(Transaction::getAmount).sum();

        Map<String, Object> summary = new HashMap<>();
        summary.put("Total Income", totalIncome);
        summary.put("Total Expenses", totalExpenses);
        summary.put("Balance", totalIncome - totalExpenses);

        return summary;
    }
}
