package com.narval.Dto.form;

public class AddServicioForm {
	private int ID;
	private String Nombre;
	private String Descripcion;
	private double Costo;
	private int id_vinicola;
	private String tipo;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public double getCosto() {
		return Costo;
	}
	public void setCosto(double costo) {
		Costo = costo;
	}
	public int getId_vinicola() {
		return id_vinicola;
	}
	public void setId_vinicola(int id_vinicola) {
		this.id_vinicola = id_vinicola;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
