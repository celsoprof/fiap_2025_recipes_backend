package br.com.fiap.recipes.controller;

import br.com.fiap.recipes.model.Ingredient;
import br.com.fiap.recipes.model.Recipe;
import br.com.fiap.recipes.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ingredients")
public class IngredientController {

    @Autowired
    private IngredientService ingredientService;

    @GetMapping
    public ResponseEntity<List<Ingredient>> getRecipes() {
        List<Ingredient> ingredients = ingredientService.findAll();
        return ResponseEntity.ok(ingredients);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ingredient> getRecipe(@PathVariable Long id) {
        System.out.println("Buscando ingrediente...");
        Ingredient ingredient = ingredientService.findById(id);
        if (ingredient == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ingredient);
    }

    @GetMapping("/recipe/{id}")
    public ResponseEntity<List<Ingredient>> findByRecipeId(@PathVariable Long id) {
        List<Ingredient> ingredients = ingredientService.findByRecipeId(id);
        if (ingredients == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ingredients);
    }

    @PostMapping
    public ResponseEntity<Ingredient> saveIngredient(@RequestBody Ingredient ingredient) {
        Ingredient savedIngredient = ingredientService.save(ingredient);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedIngredient);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteIngredient(@RequestBody Ingredient ingredient) {
        ingredientService.deleteById(ingredient.getId());
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Ingredient updateIngredient(@RequestBody Ingredient ingredient) {
        return ingredientService.save(ingredient);
    }




}
