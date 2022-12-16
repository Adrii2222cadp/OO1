package ar.edu.unlp.objetos.uno.ParcialPrimeraFecha;

import java.time.LocalDate;

public class Automotor extends Vehiculo {
	private String marca, modelo;

	public Automotor(String patente, LocalDate fechaFabricacion, double valor, String marca, String modelo) {
		super(patente, fechaFabricacion, valor);
		this.marca = marca;
		this.modelo = modelo;
	}
		
	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public double calcularImpuesto() {
		return porcentaje(5);
	}
	
}