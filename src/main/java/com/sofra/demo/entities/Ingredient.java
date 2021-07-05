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
public class Ingredient {
	
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ingredient_seq")
    @SequenceGenerator(name = "ingredient_seq", allocationSize = 1)
	private long ingredientId;
    
	private String ingredientDescription;
	
	@JoinColumn(name = "recipe_id")
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, 
				CascadeType.DETACH, CascadeType.DETACH})
	private Recipe recipe;

	
	public Ingredient() {
		
	}


	public long getIngredientId() {
		return ingredientId;
	}


	public void setIngredientId(long ingredientId) {
		this.ingredientId = ingredientId;
	}


	public String getIngredientDescription() {
		return ingredientDescription;
	}


	public void setIngredientDescription(String ingredientDescription) {
		this.ingredientDescription = ingredientDescription;
	}


	public Recipe getRecipe() {
		return recipe;
	}


	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}
	
	
	
}
