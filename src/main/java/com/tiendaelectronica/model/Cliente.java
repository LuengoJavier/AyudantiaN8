package com.tiendaelectronica.model;

public class Cliente {
	private String nombre;
	private String rut;
	private String correo;

	public Cliente( String rut, String nombre,String correo) {
		this.nombre = nombre;
		this.rut = rut;
		this.correo = correo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getRut() {
		return this.rut;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	@Override
	public String toString() {
		return nombre +"," + rut + "," + correo;
	}
}