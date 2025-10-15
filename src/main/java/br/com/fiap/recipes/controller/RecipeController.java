package br.com.fiap.recipes.controller;

import br.com.fiap.recipes.model.Ingredient;
import br.com.fiap.recipes.model.PreparationMethod;
import br.com.fiap.recipes.model.Recipe;
import br.com.fiap.recipes.service.IngredientService;
import br.com.fiap.recipes.service.PreparationMethodService;
import br.com.fiap.recipes.service.RecipeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private IngredientService ingredientService;
    @Autowired
    private PreparationMethodService preparationMethodService;

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

    @PostMapping("/{id}/ingredients")
    public ResponseEntity<List<Ingredient>> addIngredients(
            @RequestBody List<Ingredient> ingredients,
            @PathVariable Long id
    ) {
        Recipe recipe = recipeService.findById(id);

        if (recipe == null) {
            return ResponseEntity.notFound().build();
        }

        List<Ingredient> newIngredients = ingredients.stream()
                        .peek(i -> i.setRecipe(recipe)).toList();

        List<Ingredient> ingredientsSaved = ingredientService.saveAll(newIngredients);
        return ResponseEntity.status(HttpStatus.CREATED).body(ingredientsSaved);
    }

    @PostMapping("/{id}/preparation-methods")
    public ResponseEntity<List<PreparationMethod>> addPreparationMethods(
            @RequestBody List<PreparationMethod> methods,
            @PathVariable Long id
    ){
        Recipe recipe = recipeService.findById(id);
        if (recipe == null) {
            return ResponseEntity.notFound().build();
        }

        methods.stream()
                .peek(i -> i.setRecipe(recipe)).toList();

        List<PreparationMethod> methodsSaved = preparationMethodService.saveAll(methods);
        return ResponseEntity.status(HttpStatus.CREATED).body(methodsSaved);

    }

    @GetMapping("/{id}/ingredients")
    public ResponseEntity<List<Ingredient>> getIngredients(@PathVariable Long id) {

        Recipe recipe = recipeService.findById(id);

        if (recipe == null) {
            return ResponseEntity.notFound().build();
        }

        List<Ingredient> ingredients = recipe.getIngredients();
        return ResponseEntity.ok(ingredients);
    }

    @GetMapping("/{id}/preparation-methods")
    public ResponseEntity<List<PreparationMethod>> getPreparationMethods(@PathVariable Long id) {
        Recipe recipe = recipeService.findById(id);
        if (recipe == null) {
            return ResponseEntity.notFound().build();
        }
        List<PreparationMethod> methods = recipe.getPreparationMethods();
        return ResponseEntity.ok(methods);
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
