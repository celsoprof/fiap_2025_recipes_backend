package br.com.fiap.recipes.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tbl_recipe")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "The recipe's title is required!")
    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private DifficultLevel difficultLevel;

    @Positive(message = "The cooking time must be positive!")
    private int cookingTime;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_category_id")
    private Category category;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ingredient> ingredients;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DifficultLevel getDifficultLevel() {
        return difficultLevel;
    }

    public void setDifficultLevel(DifficultLevel difficultLevel) {
        this.difficultLevel = difficultLevel;
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(int cookingTime) {
        this.cookingTime = cookingTime;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
