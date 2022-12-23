package ar.edu.unlp.objetos.uno.SegundoRecuperatorio;

import java.time.LocalDate;

public abstract class Contrato {
	
	private LocalDate fechaInicio;
	private Servicio servicio;
	
	public Contrato(Servicio unServicio, LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
		this.servicio = unServicio;
	}
	
	public LocalDate getFechaInicio() {
		return this.fechaInicio;
	}

	public Servicio getServicio() {
		return servicio;
	}

	abstract double calcularMonto();
}
