package com.tiendaelectronica.model;

public class Articulo {
	private int id;
	private String nombre;
	private double peso;
	private int precio;
	private String categoria;

	public Articulo(int id,String nombre, double peso, int precio, String categoria) {
		this.id = id;
		this.nombre = nombre;
		this.peso = peso;
		this.precio = precio;
		this.categoria = categoria;
	}
	public int getId() {
		return id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPeso() {
		return this.peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public int getPrecio() {
		return this.precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return nombre + "," + peso + ","+ precio +","+ categoria;
	}
}