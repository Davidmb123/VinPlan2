package com.narval.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.narval.Dto.form.UserRegistrationForm;
import com.narval.Services.EmailService;
import com.narval.Services.RolesService;
import com.narval.Services.TipoUsuarioService;
import com.narval.Services.UserService;
import com.narval.repository.RolesRepository;
import com.narval.repository.TokenRepository;
import com.narval.Models.Roles;


@Controller
public class SignUpController {
	private static Logger logger = LoggerFactory.getLogger("SignUpController.class");

	@Autowired
	UserService userService;
	
	@Autowired
	RolesService rolesService;
	@Autowired
	TipoUsuarioService tipoUsuarioService;
	
	
	@GetMapping("/SignUp")
	public String SignUp(Model model) {
	Authentication auth= SecurityContextHolder.getContext().getAuthentication();
		
		Collection<? extends GrantedAuthority> authorities=auth.getAuthorities();
		
		String redirectUrl=null;
		for(GrantedAuthority grantedAuthority : authorities) {
			if(grantedAuthority.getAuthority().equals("Turista")) {
				redirectUrl="/TouristDashboard";
			}else if(grantedAuthority.getAuthority().equals("Vinicola")){
				redirectUrl="/dashboardVinicola";	
			}
			
		}
		if(auth.getPrincipal() instanceof UserDetails) {
			return redirectUrl;
		}
		List <String> roles= rolesService.getNames();
		List<String> tiposUsuario=tipoUsuarioService.getTiposUsuario();
		model.addAttribute("roles",roles);
		model.addAttribute("tiposUsuario",tiposUsuario);
		return "SignUp";
	}
	@RequestMapping(value="/SignUp")
	public String signUp(@ModelAttribute UserRegistrationForm userRegistration, @RequestParam String role, @RequestParam String tipo, Model model) {
		logger.info("New user registration");
		userService.addUser(userRegistration,role,tipo);
		
		return "redirect:/";
	}
}
