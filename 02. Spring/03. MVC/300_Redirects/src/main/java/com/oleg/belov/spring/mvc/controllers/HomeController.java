package com.oleg.belov.spring.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oleg.belov.spring.mvc.data.entities.Project;
import com.oleg.belov.spring.mvc.data.entities.Sponsor;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String goHome(Model model){
		
		Project project = new Project();
		project.setName("First Project");
		project.setSponsor(new Sponsor("NASA", "555-555-5555", "nasa@nasa.com"));
		project.setDescription("This is a simple project sponsored by NASA");
		
		model.addAttribute("currentProject", project);
		
		return "welcome";
	}
	
}
