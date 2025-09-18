package br.com.fiap.recipes.controller;

import br.com.fiap.recipes.model.Recipe;
import br.com.fiap.recipes.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping("/recipes")
    public List<Recipe> getRecipes() {
        return recipeService.findAll();
    }

    @GetMapping("/recipes/{id}")
    public Recipe getRecipe(@PathVariable Long id) {
        return recipeService.findById(id);
    }

    @PostMapping("/recipes")
    public Recipe createRecipe(@RequestBody Recipe recipe) {
        return recipeService.save(recipe);
    }

    @DeleteMapping("/recipes/{id}")
    public void deleteRecipe(@PathVariable Long id) {
        recipeService.delete(id);
    }

    @PutMapping("/recipes")
    public Recipe updateRecipe(@RequestBody Recipe recipe) {
        return recipeService.save(recipe);
    }

    @GetMapping("/recipes/category/{categoryId}")
    public List<Recipe> getRecipesByCategory(@PathVariable Long categoryId) {
        return recipeService.findRecipesByCategory(categoryId);
    }

}
