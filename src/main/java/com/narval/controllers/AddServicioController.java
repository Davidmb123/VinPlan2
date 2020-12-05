package com.narval.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.narval.Dto.form.AddServicioForm;
import com.narval.Dto.form.PuntoTuristicoForm;
import com.narval.Dto.form.UserRegistrationForm;
import com.narval.Services.PuntoTuristicoService;
import com.narval.Services.ServiciosService;

@Controller
public class AddServicioController {

	@Autowired
	ServiciosService addServicioService;
	@GetMapping("/AddServicio")
	public String login(Model model) {
		
		return "AddServicio";
		
	}
	
	@PostMapping("/AddServicio")
	public void puntoturistico(@ModelAttribute AddServicioForm addServicio, /*RedirectAttributes redirectAttributes,*/ Model model) {
		
		addServicioService.AddServicio(addServicio);
	
	}
}
