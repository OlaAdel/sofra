package com.sofra.demo.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sofra.demo.entities.Recipe;
import com.sofra.demo.entities.User;
import com.sofra.demo.services.RecipeService;
import com.sofra.demo.services.UserService;

@Controller
public class RecipeController {
	
	@Autowired
	RecipeService recipeService;	
	
	@Autowired
	UserService userService;	
	
	@GetMapping("/recipes")
	public String displayRecipes(HttpServletRequest request, Model model) {
		
		User user = userService.findByUsername(request.getUserPrincipal().getName());
		model.addAttribute("recipes", user.getRecipes());
		return "recipes/my-recipes";
	}
	
	@GetMapping("/recipes/new")
	public String addRecipe(Model model) {
		model.addAttribute("recipe", new Recipe());
		return "recipes/new-recipe";
	}
	
	@PostMapping("/recipes/save")
	public String addRecipe(HttpServletRequest request, Recipe recipe) {
		User user = userService.findByUsername(request.getUserPrincipal().getName());
		recipe.setRecipeOwner(user);
		recipeService.save(recipe);
		return "redirect:/recipes";
	}
	
	@GetMapping("/recipes/{id}")
	public String viewRecipe(@PathVariable("id") long id, Model model) {
		Recipe recipe = recipeService.findById(id);
		model.addAttribute("recipe", recipe);
		return "/recipes/view-recipe";
	}
	
	@GetMapping("/recipes/edit")
	public String editRecipe(@RequestParam long id, Model model) {
		Recipe recipe = recipeService.findById(id);
		model.addAttribute("recipe", recipe);
		return "/recipes/edit-recipe";
	}
	
	@GetMapping("/recipes/delete")
	public String deleteRecipe(@RequestParam long id, Model model) {
		recipeService.deleteById(id);
		return "redirect:/recipes";
	}

}
