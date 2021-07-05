package com.sofra.demo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sofra.demo.entities.Recipe;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Long> {
	public Recipe findById(long id);

}
