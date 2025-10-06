package br.com.fiap.recipes.repository;

import br.com.fiap.recipes.model.Category;
import br.com.fiap.recipes.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    @Query("SELECT r FROM Recipe r WHERE r.category.categoryId = :categoryId")
    List<Recipe> findByCategoryId(Long categoryId);

    @Query("SELECT r FROM Recipe r ORDER BY r.creationDate DESC LIMIT 5")
    List<Recipe> findAllByOrderByCreationDateAsc();

}
