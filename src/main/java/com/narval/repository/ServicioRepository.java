package com.narval.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.narval.Models.Servicio;
import com.narval.Models.Usuario;

public interface ServicioRepository extends JpaRepository<Servicio, Long> {

	@Procedure
	void crearservicios(String NombreServicio, String TipoServicio, double CostoServicio, String DescServicio, int IdVinicola);

	@Procedure
	void ModificarServicio(int id, String nombre, String Tipo, double Costo, String desc, Timestamp fecha, int act);

	@Procedure
	void eliminarVinicola(int id);

	@Query(value="{call retrieveServicio(:name)}", nativeQuery = true)
   	List<Servicio> retriveServicio(@Param("name") String name);
   	
	
}
