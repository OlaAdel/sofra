package com.sofra.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sofra.demo.dao.RecipeRepository;
import com.sofra.demo.entities.Recipe;

@Service
public class RecipeService {
	
	@Autowired
	RecipeRepository recipeRepo;
	
	public Recipe save(Recipe recipe) {
		return recipeRepo.save(recipe);
	}

	public Recipe findById(long id) {
		return recipeRepo.findById(id);
	}
	
	public void deleteById(long id) {
		 recipeRepo.deleteById(id);
	}
	
	public Iterable<Recipe> findAll() {
		return recipeRepo.findAll();
	}
}
