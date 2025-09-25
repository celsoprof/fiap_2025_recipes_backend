package br.com.fiap.recipes.controller;

import br.com.fiap.recipes.model.Ingredient;
import br.com.fiap.recipes.model.Recipe;
import br.com.fiap.recipes.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ingredients")
public class IngredientController {

    @Autowired
    private IngredientService ingredientService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Ingredient> getRecipes() {
        return ingredientService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Ingredient getRecipe(@PathVariable Long id) {
        return ingredientService.findById(id);
    }

    @GetMapping("/recipe/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Ingredient> findByRecipeId(@PathVariable Long id) {
        return ingredientService.ingredientList(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Ingredient saveIngredient(@RequestBody Ingredient ingredient) {
        return ingredientService.save(ingredient);
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
