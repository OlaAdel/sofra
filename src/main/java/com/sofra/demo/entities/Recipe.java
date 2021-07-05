package com.sofra.demo.entities;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Recipe {
	
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recipe_seq")
    @SequenceGenerator(name = "recipe_seq", allocationSize = 1)
	private Long recipeId;
	
	private String title;
	private String description;
	private int servings;
	private int cookingTimeInMinutes;
	
	
	/*@OneToMany(mappedBy = "recipe", 
			cascade = {CascadeType.PERSIST, CascadeType.MERGE, 
						CascadeType.DETACH, CascadeType.DETACH})
	private List<Ingredient> ingredients;
	
	@OneToMany(mappedBy = "recipe", 
			cascade = {CascadeType.PERSIST, CascadeType.MERGE, 
						CascadeType.DETACH, CascadeType.DETACH})
	private List<Step> steps;*/
	
	private String ingredients;
	
	private String steps;
	
	
	@JoinColumn(name = "user_id")
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, 
				CascadeType.DETACH, CascadeType.DETACH})
	private User recipeOwner;


	public Long getRecipeId() {
		return recipeId;
	}


	public void setRecipeId(Long recipeId) {
		this.recipeId = recipeId;
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


	public int getServings() {
		return servings;
	}


	public void setServings(int servings) {
		this.servings = servings;
	}


	public int getCookingTimeInMinutes() {
		return cookingTimeInMinutes;
	}


	public void setCookingTimeInMinutes(int cookingTimeInMinutes) {
		this.cookingTimeInMinutes = cookingTimeInMinutes;
	}
	


	public String getIngredients() {
		return ingredients;
	}


	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}


	public String getSteps() {
		return steps;
	}


	public void setSteps(String steps) {
		this.steps = steps;
	}


	public User getRecipeOwner() {
		return recipeOwner;
	}


	public void setRecipeOwner(User recipeOwner) {
		this.recipeOwner = recipeOwner;
	}


	
	
	

}
