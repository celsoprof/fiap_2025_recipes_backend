package br.com.fiap.recipes.service;

import br.com.fiap.recipes.exception.RecipeNotFountException;
import br.com.fiap.recipes.model.Category;
import br.com.fiap.recipes.model.Recipe;
import br.com.fiap.recipes.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {

    @Value("${upload.dir}")
    private String uploadDir;

    @Autowired
    private RecipeRepository recipeRepository;

    public Recipe save(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public Recipe uploadImage(Long recipeId, MultipartFile file) throws IOException {

        // Get a recipe
        System.out.printf("***** -> Uploading image file %s\n", file.getOriginalFilename());
        Recipe recipe = recipeRepository.findById(recipeId)
                .orElseThrow(() -> new RecipeNotFountException("Recipe Not Fount"));

        String fileName = file.getOriginalFilename();
        Path path = Paths.get(uploadDir).resolve(fileName);

        Files.createDirectories(path.getParent());
        Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

        String url = "/images/" + fileName;

        recipe.setUrl(url);

        System.out.println(recipe.toString());

        return recipeRepository.save(recipe);
    }

    public List<Recipe> findAll() {
        return recipeRepository.findAll();
    }

    public Recipe findById(Long id) {
        Optional<Recipe> recipe = recipeRepository.findById(id);
        return recipe.orElse(null);

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

    public List<Recipe> findRecents() {
         return recipeRepository.findAllByOrderByCreationDateAsc();
    }

}
