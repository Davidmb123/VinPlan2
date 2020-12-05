package com.narval.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.narval.Dto.form.PuntoTuristicoForm;
import com.narval.Services.PuntoTuristicoService;
@Controller
public class EditPuntoTuristicoController {
	@Autowired
	PuntoTuristicoService puntoturisticoService;
	@GetMapping("/EditPuntoTuristico")
	public String login(Model model) {
		
		return "EditPuntoTuristico";
		
	}
	
	@PostMapping("/EditPuntoTuristico")
	public void puntoturistico(@ModelAttribute PuntoTuristicoForm editpuntoturistico, /*RedirectAttributes redirectAttributes,*/ Model model) {
		
		puntoturisticoService.EditPuntoturistico(editpuntoturistico);
	
	}
}
