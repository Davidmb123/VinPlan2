package com.narval.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.narval.Dto.form.VinRegistrationForm;
import com.narval.Dto.form.VinicolaEditForm;
import com.narval.Models.Vinicola;
import com.narval.repository.VinicolaRepository;

@Service
public class VinicolaService {
	@Autowired
	VinicolaRepository vinicolaRepository;

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
		vin.setNombre(vinRegistrationForm.getNombre());
		vin.setDireccion(vinRegistrationForm.getDireccion());
		vin.setCodigoPost(vinRegistrationForm.getCodigo_post());
		vinicolaRepository.save(vin);
		vin.getId();

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
