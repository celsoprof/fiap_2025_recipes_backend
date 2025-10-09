package br.com.fiap.recipes.service;

import br.com.fiap.recipes.model.PreparationMethod;
import br.com.fiap.recipes.repository.PreparationMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PreparationMethodService {

    @Autowired
    private PreparationMethodRepository preparationMethodRepository;

    public List<PreparationMethod> findAll() {
        return preparationMethodRepository.findAll();
    }

    public PreparationMethod findById(int id) {
        Optional<PreparationMethod> preparationMethod = preparationMethodRepository.findById(id);
        if(preparationMethod.isPresent()){
            return preparationMethod.get();
        }
        return null;
    }

    public PreparationMethod save(PreparationMethod preparationMethod) {
        return preparationMethodRepository.save(preparationMethod);
    }

    public List<PreparationMethod> saveAll(List<PreparationMethod> preparationMethods) {
        return preparationMethodRepository.saveAll(preparationMethods);
    }

    public void deleteById(int id) {
        preparationMethodRepository.deleteById(id);
    }

    public PreparationMethod update(Long id, PreparationMethod preparationMethod) {
        return preparationMethodRepository.save(preparationMethod);
    }

    public List<PreparationMethod> findByRecipeId(int id) {
        return preparationMethodRepository.findByRecipeId((long) id);
    }

    public List<PreparationMethod> findByPreparationId(Long preparationId) {
        return preparationMethodRepository.listPreparationMethods(preparationId);
    }

}
