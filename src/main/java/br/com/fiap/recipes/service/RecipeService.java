package br.com.fiap.recipes.service;

import br.com.fiap.recipes.model.Category;
import br.com.fiap.recipes.model.Recipe;
import br.com.fiap.recipes.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return recipeRepository.findById(id).orElse(null);
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
