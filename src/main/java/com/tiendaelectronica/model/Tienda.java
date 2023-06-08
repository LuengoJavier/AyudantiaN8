package model;

public class Tienda {
	private String nombre;
	private String direccion;
	public Articulo unnamed_Articulo_;
	public Cliente unnamed_Cliente_;

	public Tienda(String nombre, String direccion) {
		throw new UnsupportedOperationException();
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
}