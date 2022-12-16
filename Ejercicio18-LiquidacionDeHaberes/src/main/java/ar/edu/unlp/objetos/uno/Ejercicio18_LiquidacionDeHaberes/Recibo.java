package ar.edu.unlp.objetos.uno.Ejercicio18_LiquidacionDeHaberes;

import java.time.LocalDate;


public class Recibo {

	private int antiguedad;
	private double montoTotal;
	private LocalDate fecha;
	
	
	public Recibo(int antiguedad, double montoTotal ) {
		super();
		this.antiguedad = antiguedad;
		this.fecha = LocalDate.now();
		this.montoTotal = montoTotal;
	}


	public int getAntiguedad() {
		return antiguedad;
	}

	public double getMontoTotal() {
		return montoTotal;
	}

	public LocalDate getFecha() {
		return fecha;
	}	
	
}
