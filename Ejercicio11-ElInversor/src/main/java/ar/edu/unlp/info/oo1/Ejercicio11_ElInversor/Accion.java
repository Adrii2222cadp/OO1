package ar.edu.unlp.info.oo1.Ejercicio11_ElInversor;

public class Accion implements Inversion{
	private String nombre;
	private int cantidad;
	private double valorUnitario;
	
	
	public Accion(String unNombre, int unaCantidad, double unValorUnitario) {
		this.nombre = unNombre;
		this.cantidad = unaCantidad;
		this.valorUnitario = unValorUnitario;		
	}
	
	public double getValorActual() {
		return this.cantidad * this.valorUnitario;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidad() {
		return cantidad;
	}

	public double getValorUnitario() {
		return valorUnitario;
	}
}
