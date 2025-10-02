package br.com.fiap.recipes.controller;

import br.com.fiap.recipes.model.Category;
import br.com.fiap.recipes.repository.CategoryRepository;
import br.com.fiap.recipes.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        return categoryService.findAll();
    }

    @GetMapping("/categories/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Category findById(@PathVariable Long id) {
        return categoryService.findById(id);
    }

}
