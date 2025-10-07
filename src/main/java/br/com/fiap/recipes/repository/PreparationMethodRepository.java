package br.com.fiap.recipes.repository;

import br.com.fiap.recipes.model.PreparationMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface PreparationMethodRepository extends JpaRepository<PreparationMethod, Integer> {

    List<PreparationMethod> findByRecipeId(Long recipeId);

    @Query("SELECT pm.id, pm.description, pm.recipe.id, r.id, r.title, r.description FROM PreparationMethod pm JOIN pm.recipe r where r.id = :id ORDER BY r.id ")
    List<PreparationMethod> listPreparationMethods(@RequestParam Long id);

}
