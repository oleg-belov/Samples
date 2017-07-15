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
		List<String> options = new LinkedList<>(Arrays.asList(new String[] {
				"Material", "Other", "Staff", "Technical Equipment" }));
		model.addAttribute("typeOptions", options);
		model.addAttribute("resource", new Resource());
		return "resource_add";
	}

	@RequestMapping("/save")
	public String save(@ModelAttribute Resource resource) {
		System.out.println(resource);
		return "resource_add";
	}
}
