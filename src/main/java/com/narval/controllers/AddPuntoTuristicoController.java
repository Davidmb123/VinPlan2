package com.narval.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.narval.Dto.form.PuntoTuristicoForm;
import com.narval.Dto.form.UserRegistrationForm;
import com.narval.Services.PuntoTuristicoService;
@Controller
public class AddPuntoTuristicoController {

	@Autowired
	PuntoTuristicoService addpuntoturisticoService;
	@GetMapping("/AddPuntoTuristico")
	public String login(Model model) {
		
		return "AddPuntoTuristico";
		
	}
	
	@PostMapping("/AddPuntoTuristico")
	public void puntoturistico(@ModelAttribute PuntoTuristicoForm addpuntoturistico, /*RedirectAttributes redirectAttributes,*/ Model model) {
		
		addpuntoturisticoService.AddPuntoturistico(addpuntoturistico);;
	
	}
}
