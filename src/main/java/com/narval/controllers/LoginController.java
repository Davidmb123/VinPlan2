package com.narval.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.Authentication;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;


import com.narval.Services.UserService;

@Controller
public class LoginController {
	@Autowired
	UserService userService;
	
	@GetMapping("/login")
	public String login(Model model) {
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
		return "login";
	}
	
}