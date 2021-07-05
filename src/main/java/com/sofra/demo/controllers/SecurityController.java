package com.sofra.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sofra.demo.entities.User;
import com.sofra.demo.services.UserService;

@Controller
public class SecurityController {
	
	
	@Autowired
	UserService userService;
	
	@Autowired
	BCryptPasswordEncoder encoder;
	

	
	@GetMapping("/sign-up")
	public String signUp(Model model) {
		
		model.addAttribute("user", new User());
		return "security/sign-up";
	}
	
	@PostMapping("/sign-up/save")
	public String saveUser(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		userService.save(user);
		return "redirect:/login";
	}
	
}
