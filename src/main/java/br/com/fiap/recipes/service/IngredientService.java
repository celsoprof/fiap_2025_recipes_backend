package br.com.fiap.recipes.service;

import br.com.fiap.recipes.model.Ingredient;
import br.com.fiap.recipes.model.Recipe;
import br.com.fiap.recipes.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private RecipeService recipeService;

    public List<Ingredient> findAll(){
        return ingredientRepository.findAll();
    }

    public Ingredient findById(Long id){
        return ingredientRepository.findById(id).get();
    }

    public Ingredient save(Ingredient ingredient){
        return ingredientRepository.save(ingredient);
    }

    public List<Ingredient> saveAll(List<Ingredient> ingredients){
        return ingredientRepository.saveAll(ingredients);
    }

    public void deleteById(Long id){
        ingredientRepository.deleteById(id);
    }

    public  Ingredient update(Ingredient ingredient){
        return ingredientRepository.save(ingredient);
    }

    public List<Ingredient> findByRecipeId(Long id){
        return ingredientRepository.findByRecipeId(id);
    }

    public List<Ingredient> ingredientList(Long id){
        return ingredientRepository.listIngredients(id);
    }

}
