package com.narval.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.narval.Dto.form.AddServicioForm;
import com.narval.Dto.form.PuntoTuristicoForm;
import com.narval.Models.Servicio;
import com.narval.Models.Vinicola;
import com.narval.repository.ServicioRepository;
import com.narval.repository.VinicolaRepository;

@Service
public class ServiciosService {
	@Autowired
	ServicioRepository servicioRepository;
	@Autowired
	UserService userService;
	public List<Servicio> findByName(String name) {
		List<Servicio> dbServicios = servicioRepository.findByName(name);
		if (name != null) {
			System.out.println(name);
			List<Servicio> dbServicio = servicioRepository.findByName(name);
			return dbServicio;
		}
		return servicioRepository.findAll();
	}
	
	public void AddServicio(AddServicioForm addServicioForm) {
	
		
		UserDetails userDetails=userService.currentUserDetails();
        
		int id=userService.getIdByEmail(userDetails.getUsername());
		
        String descripcion=addServicioForm.getDescripcion();
		String nombre= addServicioForm.getNombre();
		String tipo = addServicioForm.getTipo();
		double costo = addServicioForm.getCosto();
		
		servicioRepository.crearservicios(nombre,tipo,costo,descripcion,id);
	}
}
