package br.com.fiap.recipes.controller;

import br.com.fiap.recipes.model.Recipe;
import br.com.fiap.recipes.service.RecipeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping
    public ResponseEntity<List<Recipe>> getRecipes() {
        List<Recipe> recipes = recipeService.findAll();
        return ResponseEntity.ok(recipes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipe(@PathVariable Long id) {
        Recipe recipe = recipeService.findById(id);
        if  (recipe == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipe);
    }

    @PostMapping
    public ResponseEntity<Recipe> createRecipe(@Valid @RequestBody Recipe recipe) {
        Recipe newRecipe = recipeService.save(recipe);
        return ResponseEntity.status(HttpStatus.CREATED).body(newRecipe);
    }

    @PostMapping("/{id}/upload-image")
    public ResponseEntity<Recipe> uploadImage(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
        Recipe recipe = recipeService.findById(id);

        if (recipe == null) {
            return ResponseEntity.notFound().build();
        }

        try {
            recipeService.uploadImage(id, file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return ResponseEntity.ok(recipe);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteRecipe(@PathVariable Long id) {
        Recipe recipe = recipeService.findById(id);
        recipeService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Recipe> updateRecipe(@RequestBody Recipe recipe) {
        Recipe newRecipe = recipeService.save(recipe);
        return ResponseEntity.ok(newRecipe);
    }

    @GetMapping("/categories/{categoryId}")
    public ResponseEntity<List<Recipe>> getRecipesByCategory(@PathVariable Long categoryId) {
        List<Recipe> recipes = recipeService.findRecipesByCategory(categoryId);
        if (recipes.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipes);
    }

    @GetMapping("/recents")
    public ResponseEntity<List<Recipe>> getRecipesRecents() {
        List<Recipe> recentRecipes = recipeService.findRecents();
        if (recentRecipes.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recentRecipes);
    }
}
