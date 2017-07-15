package com.oleg.belov.spring.mvc.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.oleg.belov.spring.mvc.data.entities.Project;
import com.oleg.belov.spring.mvc.data.services.ProjectService;

@Controller
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	@RequestMapping(value="/{projectId}")
	public String findProject(Model model, @PathVariable("projectId") Long projectId){
		model.addAttribute("project", this.projectService.find(projectId));
		return "project";
	}
	
	@RequestMapping(value="/find")
	public String find(Model model){
		model.addAttribute("projects", this.projectService.findAll());
		return "projects";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String addProject(HttpSession session){
		session.setAttribute("token", "12345");
		System.out.println("invoking addProject");
		return "project_add";
	}

	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String saveProject(@ModelAttribute Project project){
		System.out.println("invoking saveProject");
		System.out.println(project);
		return "project_add";
	}

}
