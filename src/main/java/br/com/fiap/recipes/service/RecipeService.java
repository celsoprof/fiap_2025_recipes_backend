package br.com.fiap.recipes.service;

import br.com.fiap.recipes.exception.RecipeNotFountException;
import br.com.fiap.recipes.model.Category;
import br.com.fiap.recipes.model.Recipe;
import br.com.fiap.recipes.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    public Recipe save(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public List<Recipe> findAll() {
        return recipeRepository.findAll();
    }

    public Recipe findById(Long id) {
        Optional<Recipe> recipe = recipeRepository.findById(id);

        if (recipe.isPresent()) {
            return recipe.get();
        }  else {
            System.out.println("****** Recipe NOT FOUND!!");
            throw new RecipeNotFountException("Recipe Not Fount");
        }

    }

    public void delete(Long id) {
        recipeRepository.deleteById(id);
    }

    public Recipe update(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public List<Recipe> findRecipesByCategory(Long categoryId) {
        return recipeRepository.findByCategoryId(categoryId);
    }

}
