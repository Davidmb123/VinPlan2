package com.narval.repository;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.narval.Models.PuntoTuristico;
import com.narval.Models.Token;


	@Repository
	public interface PuntoTuristicoRepository extends CrudRepository<PuntoTuristico, String> {
	
		@Procedure
		void Addpuntoturistico(int id,String nombre,String direccion);
	}
