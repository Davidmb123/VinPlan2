package com.narval.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardVinicola {
	
	@GetMapping("/dashboardVinicola")
	public String login(Model model) {
		
		return "dashboardVinicola";
		
	}
}
