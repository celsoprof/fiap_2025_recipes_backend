package br.com.fiap.recipes.controller;

import br.com.fiap.recipes.model.PreparationMethod;
import br.com.fiap.recipes.model.Recipe;
import br.com.fiap.recipes.repository.PreparationMethodRepository;
import br.com.fiap.recipes.service.PreparationMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/preparation-methods")
public class PreparationMethodController {

    @Autowired
    private PreparationMethodService preparationMethodService;

    @GetMapping
    public ResponseEntity<List<PreparationMethod>> getPreparationMethods() {
        List<PreparationMethod> preparationMethods = preparationMethodService.findAll();
        return ResponseEntity.ok(preparationMethods);
    }

    @GetMapping("/recipe/{id}")
    public ResponseEntity<List<PreparationMethod>> getPreparationMethodsByRecipe(@PathVariable Long id) {
        List<PreparationMethod> preparationMethods = preparationMethodService.findByRecipeId(id.byteValue());
        if (preparationMethods.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(preparationMethods);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PreparationMethod> getPreparationMethod(@PathVariable int id) {
        PreparationMethod preparationMethod = preparationMethodService.findById(id);
        if (preparationMethod == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(preparationMethod);
    }

    @PostMapping
    public ResponseEntity<PreparationMethod> save(@RequestBody PreparationMethod preparationMethod) {
        PreparationMethod savedPreparationMethod = preparationMethodService.save(preparationMethod);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPreparationMethod);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePreparationMethod(@PathVariable int id) {

        PreparationMethod preparationMethod = preparationMethodService.findById(id);

        if (preparationMethod == null) {
            return ResponseEntity.notFound().build();
        } else {
            preparationMethodService.deleteById(id);
            return ResponseEntity.noContent().build();
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<PreparationMethod> updatePreparationMethod(@PathVariable Long id, @RequestBody PreparationMethod preparationMethod) {
        PreparationMethod actualPreparationMethod = preparationMethodService.findById(id.intValue());

        if (actualPreparationMethod == null) {
            return ResponseEntity.notFound().build();
        } else {
            PreparationMethod newPreparationMethod = preparationMethodService.save(preparationMethod);
            return ResponseEntity.ok(newPreparationMethod);
        }

    }

}
