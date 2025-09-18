package br.com.fiap.recipes.repository;

import br.com.fiap.recipes.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
