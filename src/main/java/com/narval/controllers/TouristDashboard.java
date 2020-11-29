package com.narval.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.narval.Models.Usuario;
import com.narval.Services.UserService;
import com.narval.repository.UserRepository;
import com.narval.repository.VinicolaRepository;
import com.narval.Services.ServiciosService;

import java.util.List;

import com.narval.Models.Servicio;

@Controller
public class TouristDashboard {

	@Autowired
	UserRepository userRepository;

	@Autowired
	ServiciosService servicios;

	@GetMapping("/TouristDashboard")
	public String TouristDashboard() {
		UserDetails userDetails = currentUserDetails();
		int id = userRepository.getIdByEmail(userDetails.getUsername());
		return "TouristDashboard";
	}

	public static UserDetails currentUserDetails() {
		SecurityContext securityContext = SecurityContextHolder.getContext();
		Authentication authentication = securityContext.getAuthentication();
		if (authentication != null) {
			Object principal = authentication.getPrincipal();
			return principal instanceof UserDetails ? (UserDetails) principal : null;
		}
		return null;
	}

	@PostMapping("/TouristDashboard")
	public String searhService(Model model, @Param("nombre") String nombre) {
		System.out.println(nombre);
		List<Servicio> listServicios = servicios.findByName(nombre);
		for (int i = 0; i < listServicios.size(); i++) {
			System.out.println(listServicios.get(i).getNombre());
		}
		System.out.println(nombre);
		model.addAttribute("listServicios", listServicios);
		System.out.println(nombre);
		model.addAttribute("nombre", nombre);
		return "TouristDashboard";
	}
}
