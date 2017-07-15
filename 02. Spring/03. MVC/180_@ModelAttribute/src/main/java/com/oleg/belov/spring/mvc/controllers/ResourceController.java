package com.oleg.belov.spring.mvc.controllers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oleg.belov.spring.mvc.data.entities.Resource;

@Controller
@RequestMapping("/resource")
public class ResourceController {

	@RequestMapping("/add")
	public String add(Model model) {
		return "resource_add";
	}

	@ModelAttribute("resource")
	public Resource getResource(){
		System.out.println("Adding a new resource to the model");
		return new Resource();
	}
	
	@ModelAttribute("typeOptions")
	public List<String> getTypes(){
		return new LinkedList<>(Arrays.asList(new String[] {
				"Material", "Other", "Staff", "Technical Equipment" }));
	}
	
	@ModelAttribute("radioOptions")
	public List<String> getRadios(){
		return new LinkedList<>(Arrays.asList(new String[]{
				"Hours", "Piece", "Tons"	
			}));
	}
	
	@ModelAttribute("checkOptions")
	public List<String> getChecks(){
		return new LinkedList<>(Arrays.asList(new String[]{
				"Lead Time", "Special Rate", "Requires Approval"	
			}));
	}
	
	@RequestMapping("/save")
	public String save(@ModelAttribute Resource resource) {
		System.out.println(resource);
		return "redirect:/resource/add";
	}
}
