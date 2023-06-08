package model;

public class Cliente {
	private String nombre;
	private String rut;
	private String correo;
	public Tienda unnamed_Tienda_;

	public Cliente(String nombre, String rut, String correo) {
		throw new UnsupportedOperationException();
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

	public String toString() {
		throw new UnsupportedOperationException();
	}
}