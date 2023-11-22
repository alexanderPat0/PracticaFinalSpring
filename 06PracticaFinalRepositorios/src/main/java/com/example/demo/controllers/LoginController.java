package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entities.User;
import com.example.demo.services.imp.UserService;

@Controller
public class LoginController {

	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	@GetMapping("/auth/login")
	public String login(Model model, @RequestParam(name = "error", required = false)
	    String error, @RequestParam(name = "logout", required = false) String logout) {
		model.addAttribute("user", new User());
		model.addAttribute("error" , error);
		model.addAttribute(logout);
		return"login";
	}
	@GetMapping("/auth/registerForm")
	public String registerForm(Model model) {
		model.addAttribute("user", new User());
		return "registro";
	}
	@GetMapping("/auth/register")
	public String register(@ModelAttribute User user, RedirectAttributes flash) {
//		userService.registrar(user);
		flash.addFlashAttribute("succes", "User registered succesfully");
		return "redirect:/auth/login";
	}
	
	
}
