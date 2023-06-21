package com.tiendaelectronica.model;
import java.util.ArrayList;

public class Tienda {
	private String nombre;
	private String direccion;
	public ArrayList<Articulo> articulos;
	public ArrayList<Cliente> clientes;

	public Tienda(String nombre, String direccion) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.articulos = new ArrayList<>();
		this.clientes = new ArrayList<>();
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public ArrayList<Articulo> getArticulos() {
		return articulos;
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}
}