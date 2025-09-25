package br.com.fiap.recipes.repository;

import br.com.fiap.recipes.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    List<Ingredient> findByRecipeId(@RequestParam Long id);

    @Query("SELECT i.id, i.description, i.recipe.id, r.id, r.title, r.description FROM Ingredient i JOIN i.recipe r where r.id = :id ORDER BY r.id ")
    List<Ingredient> listIngredients(@RequestParam Long id);

}
