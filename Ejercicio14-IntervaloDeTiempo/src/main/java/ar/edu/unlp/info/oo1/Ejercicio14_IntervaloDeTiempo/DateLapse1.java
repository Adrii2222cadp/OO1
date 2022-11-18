package ar.edu.unlp.info.oo1.Ejercicio14_IntervaloDeTiempo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateLapse1 implements DateLapse{
	private LocalDate from;
	private LocalDate to;
	
	public DateLapse1(LocalDate oneFrom, LocalDate oneTo){
		this.from = oneFrom;
		this.to = oneTo;
	}
	
	/*Retorna la fecha de inicio del rango*/
	public LocalDate getFrom() {
		return this.from;
	}
	
	/*Retorna la fecha de fin del rango*/
	public LocalDate getTo() {
		return this.to;
	}
	/*Retorna la cantidad de días entre la fecha from y la fecha to*/
	public int sizeInDays() {
		return (int) this.from.until(to, ChronoUnit.DAYS);
		
		
	}
	/*Recibe un objeto LocalDate y retorna si la fecha se encuentra en el rango*/
	public boolean includesDate(LocalDate other) {
		return (other.isAfter(from) && other.isBefore(to));	
	}
	
}
