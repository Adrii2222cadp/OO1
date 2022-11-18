package ar.edu.unlp.info.oo1.Ejercicio8_DistribuidoraElectrica;

import java.time.LocalDate;

public class Consumo {
	private LocalDate fecha;
	private double consumoDeEnergiaActiva;
	private double consumoDeEnergiaReactiva;


	
	
	public Consumo(LocalDate fecha, double consumoDeEnergiaActiva, double consumoDeEnergiaReactiva) {
		this.fecha = fecha;
		this.consumoDeEnergiaActiva = consumoDeEnergiaActiva;
		this.consumoDeEnergiaReactiva = consumoDeEnergiaReactiva;
	}

	public double factorDePotencia() {
		return this.consumoDeEnergiaActiva /  
		Math.sqrt(Math.pow(this.consumoDeEnergiaActiva, 2) + Math.pow(this.consumoDeEnergiaReactiva, 2));
	}
	
	public LocalDate fecha() {
		return this.fecha;
	}
	
	public double getConsumoDeEnergiaActiva() {
		return consumoDeEnergiaActiva;
	}

	public double getConsumoDeEnergiaReactiva() {
		return consumoDeEnergiaReactiva;
	}
	
	public double costoEnBaseA(double precioKWh) {
		return this.getConsumoDeEnergiaActiva() * precioKWh;
	}
}
