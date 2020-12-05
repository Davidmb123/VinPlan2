package com.narval.Models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "punto_turistico", schema="vin-plan")
public class PuntoTuristico {
	 @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="direccion")
	private String direccion;
	
	
	@Column(name="vinicola_idvinicola")
	private int Vinicola_idVinicola ;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public int getVinicola_idVinicola() {
		return Vinicola_idVinicola;
	}


	public void setVinicola_idVinicola(int vinicola_idVinicola) {
		Vinicola_idVinicola = vinicola_idVinicola;
	}
	
	
}
