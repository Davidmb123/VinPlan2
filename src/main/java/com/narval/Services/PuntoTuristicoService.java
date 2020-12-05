package com.narval.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.narval.Dto.form.PuntoTuristicoForm;
import com.narval.Models.PuntoTuristico;
import com.narval.Models.Vinicola;
import com.narval.repository.PuntoTuristicoRepository;
import com.narval.repository.VinicolaRepository;
@Service
public class PuntoTuristicoService {
	@Autowired
	PuntoTuristicoRepository puntorepository;
	@Autowired
	UserService userService;
public List<PuntoTuristico> findAll() {
		
		List<PuntoTuristico> dbpuntos = (List<PuntoTuristico>) puntorepository.findAll();
		
	    return dbpuntos;
	}
	public void AddPuntoturistico(PuntoTuristicoForm addPuntoTuristicoForm) {
	
		
		UserDetails userDetails=userService.currentUserDetails();
        int id=userService.getIdByEmail(userDetails.getUsername());
		String direccion=addPuntoTuristicoForm.getDireccion();
		String nombre= addPuntoTuristicoForm.getNombre();
		
	
		
		System.out.println(addPuntoTuristicoForm.getDireccion());
		System.out.println(addPuntoTuristicoForm.getNombre());
		System.out.println(id);
		puntorepository.Addpuntoturistico(id, nombre, direccion);
		
		

	
	}
	public void EditPuntoturistico(PuntoTuristicoForm addPuntoTuristicoForm) {
		PuntoTuristico puntoturistico= new PuntoTuristico();
		
	
		puntoturistico.setDireccion(addPuntoTuristicoForm.getDireccion());
		puntoturistico.setNombre(addPuntoTuristicoForm.getNombre());
		puntoturistico.setVinicola_idVinicola(addPuntoTuristicoForm.getId_vinicola());
		
		System.out.println(addPuntoTuristicoForm.getDireccion());
		System.out.println(addPuntoTuristicoForm.getNombre());
		System.out.println(addPuntoTuristicoForm.getId_vinicola());
		
		

		puntorepository.save(puntoturistico);
	}
}
