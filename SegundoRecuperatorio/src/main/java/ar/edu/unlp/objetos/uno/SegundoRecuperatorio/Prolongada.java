package ar.edu.unlp.objetos.uno.SegundoRecuperatorio;

import java.time.LocalDate;

public class Prolongada extends Contrato{
	private int cantidadDeDias;
	
	public Prolongada(Servicio unServicio, LocalDate fechaInicial, int cantDias){
		super(unServicio, fechaInicial);
		this.cantidadDeDias = cantDias;
	}
	
	public double calcularMonto() {
		if(this.cantidadDeDias>5) {
			return this.getServicio().calcularMonto()-((this.getServicio().calcularMonto()/100)*10);
		}
		
		return this.getServicio().calcularMonto();
	}

	public int getCantDias() {
		return this.cantidadDeDias;
	}

	public int getCantidadDeDias() {
		return cantidadDeDias;
	}
}