package com.narval.Models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Horarios", schema="vin-plan")
public class Horarios {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="horaapertura", nullable=false, unique=false)
	private Timestamp horaapertura;
	
	@Column(name="horacierre", length=100, nullable=false, unique=false)
	private Timestamp horacierre;
	
	@Column(name="maximoaforo", nullable=true, unique=false)
	private int maximoaforo;
	
	@Column(name="servicio_idservicio", nullable=true, unique=false)
	private int servicio_idservicio;
	
	@Column(name="vinicola_idvinicola", nullable=true, unique=false)
	private int vinicola_idvinicola;
	
	@Column(name="dias_id", nullable=true,unique=false)
	private int dias_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getHoraapertura() {
		return horaapertura;
	}

	public void setHoraapertura(Timestamp horaapertura) {
		this.horaapertura = horaapertura;
	}

	public Timestamp getHoracierre() {
		return horacierre;
	}

	public void setHoracierre(Timestamp horacierre) {
		this.horacierre = horacierre;
	}

	public int getMaximoaforo() {
		return maximoaforo;
	}

	public void setMaximoaforo(int maximoaforo) {
		this.maximoaforo = maximoaforo;
	}

	public int getServicio_idservicio() {
		return servicio_idservicio;
	}

	public void setServicio_idservicio(int servicio_idservicio) {
		this.servicio_idservicio = servicio_idservicio;
	}

	public int getVinicola_idvinicola() {
		return vinicola_idvinicola;
	}

	public void setVinicola_idvinicola(int vinicola_idvinicola) {
		this.vinicola_idvinicola = vinicola_idvinicola;
	}

	public int getDias_id() {
		return dias_id;
	}

	public void setDias_id(int dias_id) {
		this.dias_id = dias_id;
	}
	
	
}
