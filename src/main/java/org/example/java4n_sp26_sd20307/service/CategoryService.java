package org.example.java4n_sp26_sd20307.service;

import org.example.java4n_sp26_sd20307.entity.Category;
import org.example.java4n_sp26_sd20307.repository.CategoryRepository;

import java.util.List;

public class CategoryService {

    CategoryRepository categoryRepository = new CategoryRepository();

    public List<Category> getCategories() {

        return categoryRepository.getCategories();
    }

    public Category getCategoryById(Long categoryId) {

        return categoryRepository.getCategoryById(categoryId);
    }
}
