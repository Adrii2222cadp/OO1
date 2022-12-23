package ar.edu.unlp.objetos.uno.SegundoRecuperatorio;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class UnicaVez extends Contrato{
	
	public UnicaVez( LocalDate unaFecha, Servicio unServicio) {		
		super(unServicio, unaFecha);
	}
	
	public double calcularMonto() {
		DayOfWeek dia = DayOfWeek.from(this.getFechaInicio());  
		if(dia.equals(DayOfWeek.SATURDAY) || (dia.equals(DayOfWeek.SUNDAY))) {
			return this.getServicio().calcularMonto()+(this.getServicio().calcularMonto()/100)*15;
		}
		else {
			return this.getServicio().calcularMonto();
		}
	}
}
