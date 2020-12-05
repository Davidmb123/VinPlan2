package com.narval.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.narval.Models.Roles;
import com.narval.Models.TipoUsuario;
import com.narval.repository.RolesRepository;
import com.narval.repository.TipoUsuarioRepository;
@Service
public class TipoUsuarioService {
	@Autowired
	 TipoUsuarioRepository tipoUsuarioRepository;
	
	public List<String> getTiposUsuario(){
		List<TipoUsuario> tipoUsuario=(List<TipoUsuario>)tipoUsuarioRepository.findAll();
		List<String> nombres=new ArrayList<String>();
		for(int i=0; i<tipoUsuario.size();i++) {
			nombres.add(tipoUsuario.get(i).getName());
		}
		
		return nombres;
	}
}
