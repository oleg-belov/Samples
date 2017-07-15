package com.oleg.belov.spring.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oleg.belov.spring.mvc.data.entities.Project;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String goHome(Model model){
		
		Project project = new Project();
		project.setName("First Project");
		project.setSponsor("Nasa");
		project.setDescription("This is a simple project sponsored by NASA");
		
		model.addAttribute("currentProject", project);
		
		return "home";
	}
	
}
