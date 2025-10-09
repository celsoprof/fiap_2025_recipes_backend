package br.com.fiap.recipes.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tbl_recipe")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "The recipe's title is required!")
    @Size(min = 4, max = 255)
    private String title;

    @NotBlank
    @Size(min = 4, max = 255)
    private String description;

    @Enumerated(EnumType.STRING)
    private DifficultLevel difficultLevel;

    @Positive(message = "The cooking time must be positive!")
    private int cookingTime;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_category_id")
    private Category category;

    //@OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true)
    @OneToMany(mappedBy = "recipe")
    @JsonManagedReference
    private List<Ingredient> ingredients;

    //@OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true)
    @OneToMany(mappedBy = "recipe")
    @JsonManagedReference
    private List<PreparationMethod> preparationMethods;

    private LocalDate creationDate;
    private String url;

    public Recipe() {
    }

    @ManyToOne(fetch = FetchType.EAGER)
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

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setPreparationMethods(List<PreparationMethod> preparationMethods) {
        this.preparationMethods = preparationMethods;
    }

    public List<PreparationMethod> getPreparationMethods() {
        return preparationMethods;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", difficultLevel=" + difficultLevel +
                ", cookingTime=" + cookingTime +
                ", category=" + category +
                ", ingredients=" + ingredients +
                ", creationDate=" + creationDate +
                ", url='" + url + '\'' +
                '}';
    }
}
