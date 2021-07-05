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

public class Step {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "step_seq")
    @SequenceGenerator(name = "step_seq", allocationSize = 1)
	private long stepId;
    
	private String stepDescription;
	
	@JoinColumn(name = "recipe_id")
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, 
				CascadeType.DETACH, CascadeType.DETACH})
	private Recipe recipe;

	
	public Step() {
		
	}


	public long getStepId() {
		return stepId;
	}


	public void setStepId(long stepId) {
		this.stepId = stepId;
	}


	public String getStepDescription() {
		return stepDescription;
	}


	public void setStepDescription(String stepDescription) {
		this.stepDescription = stepDescription;
	}


	public Recipe getRecipe() {
		return recipe;
	}


	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}
	
	
}
