package com.narval.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.narval.Models.TipoUsuario;
@Repository
public interface TipoUsuarioRepository  extends JpaRepository<TipoUsuario, Integer> {
	
   	@Query("SELECT r.id FROM TipoUsuario r WHERE r.name = :name")
    public int getIdByName(@Param("name") String name);
}
