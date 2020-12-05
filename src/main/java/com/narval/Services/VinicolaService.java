package com.narval.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.narval.Dto.form.VinRegistrationForm;
import com.narval.Dto.form.VinicolaEditForm;
import com.narval.Models.Vinicola;
import com.narval.repository.VinicolaRepository;

@Service
public class VinicolaService {
	@Autowired
	VinicolaRepository vinicolaRepository;
	@Autowired
	UserService userService;

	public List<Vinicola> findAll() {

		List<Vinicola> dbVinicolas = vinicolaRepository.findAll();

		return dbVinicolas;
	}

	public List<Vinicola> getVinicolaByName(String location) {
		List<Vinicola> dbVinicola = vinicolaRepository.getWineryByLocation(location);
		return dbVinicola;
	}

	public boolean addVinicola(VinRegistrationForm vinRegistrationForm) {
		Vinicola vin = new Vinicola();
		String nombre=(vinRegistrationForm.getNombre());
		String direccion=(vinRegistrationForm.getDireccion());
		int codigopostal=(vinRegistrationForm.getCodigo_post());

		UserDetails userDetails=userService.currentUserDetails();
        int id=userService.getIdByEmail(userDetails.getUsername());

		vinicolaRepository.Addvinicola(id, nombre, direccion, codigopostal);

		return true;
	}

	public void EditVinicola(VinicolaEditForm vinicolaEditForm) {
		Vinicola vinicola = new Vinicola();

		vinicola.setId(vinicolaEditForm.getID());
		vinicola.setDireccion(vinicolaEditForm.getDireccion());
		vinicola.setCodigoPost(vinicolaEditForm.getCodigoPostal());
		vinicola.setDescripcion(vinicolaEditForm.getDescripcion());
		vinicola.setLogo(vinicolaEditForm.getLogo());
		vinicola.setNombre(vinicolaEditForm.getNombre());
		vinicolaRepository.save(vinicola);
	}

}
