package com.narval.Dto.form;

public class PuntoTuristicoForm {
private int ID;
private String Nombre;
private String Direccion;
private int id_vinicola;
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
public String getDireccion() {
	return Direccion;
}
public void setDireccion(String direccion) {
	Direccion = direccion;
}
public int getId_vinicola() {
	return id_vinicola;
}
public void setId_vinicola(int id_vinicola) {
	this.id_vinicola = id_vinicola;
}
}
