package com.budgetmanagement.service;

import com.budgetmanagement.entity.Category;
import com.budgetmanagement.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Service class for handling business logic related to categories.
 */
@Service
public class BudgetService {
    
    private final CategoryRepository categoryRepository;

    /**
     * Constructor for injecting CategoryRepository dependency.
     */
    public BudgetService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    /**
     * Adds a new category to the database.
     */
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    /**
     * Retrieves all categories from the database.
     */
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    /**
     * Updates an existing category.
     */
    public Category updateCategory(Long id, Category category) {
        Category existingCategory = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        existingCategory.setName(category.getName());
        return categoryRepository.save(existingCategory);
    }

    /**
     * Deletes a category by ID.
     */
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
