package com.sofra.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sofra.demo.services.RecipeService;

@Controller
public class HomeController {
	
	@Autowired
	RecipeService recipeService;
	
	@GetMapping("/")
	public String displayHome(Model model) {
		
		model.addAttribute("recipes", recipeService.findAll());
		return "home/main";
	}
	
	

}
