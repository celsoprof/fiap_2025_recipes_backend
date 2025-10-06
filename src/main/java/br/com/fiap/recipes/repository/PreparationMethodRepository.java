package br.com.fiap.recipes.repository;

import br.com.fiap.recipes.model.PreparationMethod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PreparationMethodRepository extends JpaRepository<PreparationMethod, Integer> {
}
