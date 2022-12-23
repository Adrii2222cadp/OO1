package ar.edu.unlp.objetos.uno.Ejercicio18_LiquidacionDeHaberes;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ContratoHora extends Contrato {
	private LocalDate fechaFin;
	private double valorHora;
	private int cantHorasMes;
	
	
	
	public ContratoHora(LocalDate fechaInicio, LocalDate fechaFin, double valorHora, int cantHoraMes) {
		super(fechaInicio);
		this.cantHorasMes = cantHoraMes;
		this.fechaFin = fechaFin;
		this.valorHora = valorHora;	
	}
	@Override
	double calcularMonto() {
		
	    return (this.valorHora*this.cantHorasMes);
	}
	@Override
	boolean estaVencido() {
		
		return this.fechaFin.isBefore(LocalDate.now()) ||  this.fechaFin.isEqual(LocalDate.now());
	}
	
	@Override
	int calcularAños() {
		if(this.fechaFin.isBefore(LocalDate.now())){
			return (int) this.getFechaInicio().until(this.fechaFin, ChronoUnit.YEARS);
		}
		else {
			return (int) this.getFechaInicio().until(LocalDate.now(), ChronoUnit.YEARS);
		}
	}
}