package com.narval.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.narval.Models.Servicio;
import com.narval.Models.Usuario;

public interface ServicioRepository extends JpaRepository<Servicio, Long> {

	@Query(value = "SELECT s.id, s.nombre, s.tipo, s.costo, s.descripcion, s.fechainicio, s.fechafinal, s.Vinicola_idVinicola, s.last_update, s.maximoAforo FROM Servicio s LEFT JOIN vinicola v on s.Vinicola_idVinicola = v.id where v.nombre LIKE %?1%", nativeQuery = true)
	public List<Servicio> findByName(String name);
}
