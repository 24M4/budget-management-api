package com.budgetmanagement.controller;

import com.budgetmanagement.entity.Category;
import com.budgetmanagement.service.BudgetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for managing budget categories.
 * Provides endpoints for creating, retrieving, updating, and deleting categories.
 */
@RestController
@RequestMapping("/api/budgets")  // Base URL for budget-related operations
public class BudgetController {

    private final BudgetService budgetService;

    /**
     * Constructor to initialize the BudgetService dependency.
     *
     * @param budgetService Service layer for budget operations.
     */
    public BudgetController(BudgetService budgetService) {
        this.budgetService = budgetService;
    }

    /**
     * Adds a new category to the budget.
     *
     * @param category The category object received in the request body.
     * @return The created category.
     */
    @PostMapping("/category")
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        return ResponseEntity.ok(budgetService.addCategory(category));
    }

    /**
     * Retrieves all budget categories.
     *
     * @return A list of all categories.
     */
    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getAllCategories() {
        return ResponseEntity.ok(budgetService.getAllCategories());
    }

    /**
     * Updates an existing category by its ID.
     *
     * @param id       The ID of the category to update.
     * @param category The updated category details received in the request body.
     * @return The updated category.
     */
    @PutMapping("/category/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category category) {
        return ResponseEntity.ok(budgetService.updateCategory(id, category));
    }

    /**
     * Deletes a category by its ID.
     *
     * @param id The ID of the category to delete.
     * @return A success message upon deletion.
     */
    @DeleteMapping("/category/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id) {
        budgetService.deleteCategory(id);
        return ResponseEntity.ok("Category deleted successfully");
    }
}
