package ar.edu.unlp.info.oo1.Ejercicio11_ElInversor;

import java.util.ArrayList;

public class Inversor {
	private String nombre;
	private ArrayList<Inversion> inversiones;
	
	public Inversor(String unNombre) {
		this.nombre = unNombre;
		this.inversiones = new ArrayList<>();
			}
	
	public void agregarInversion(Inversion unaInversion) {
		this.inversiones.add(unaInversion);
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setNombre(String unNombre){
		this.nombre = unNombre;

	}
	
	public double getValorActual(){
		return this.inversiones.stream().mapToDouble(i -> i.getValorActual()).sum();
	}
}
