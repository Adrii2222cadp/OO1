package ar.edu.unlp.objetos.uno.Ejercicio18_LiquidacionDeHaberes;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ContratoPlanta extends Contrato{

	private double  sueldo;
	private double conyuge;
	private double hijo;
	
	public ContratoPlanta(LocalDate fechaInicio, double sueldo, double conyuge, double hijo) {
		super(fechaInicio);
		this.sueldo = sueldo;
		this.conyuge = conyuge;
		this.hijo = hijo;
	}

	@Override
	double calcularMonto() {
		
		return this.conyuge+this.hijo+this.sueldo;
	}

	@Override
	boolean estaVencido() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	int calcularAnio() {
		
		return (int) this.getFechaInicio().until(LocalDate.now()), ChronoUnit.YEARS);
	}
}
