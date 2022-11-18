package ar.edu.unlp.info.oo1.Ejercicio14_IntervaloDeTiempo;

import java.time.LocalDate;

public class DateLapse2 implements DateLapse{
		private LocalDate from;
		private int sizeInDays;
	
		
		public DateLapse2(LocalDate oneFrom, int days){
			this.from = oneFrom;
			this.sizeInDays = days;
		}
		
		/*Retorna la fecha de inicio del rango*/
		public LocalDate getFrom() {
			return this.from;
		}
		
		/*Retorna la cantidad de días entre la fecha from y la fecha to*/
		@Override
		public int sizeInDays() {
			return this.sizeInDays;
			
		}
		/*Recibe un objeto LocalDate y retorna si la fecha se encuentra en el rango*/
		@Override
		public boolean includesDate(LocalDate other) {
			LocalDate to =  this.from.plusDays(sizeInDays);
			return (other.isAfter(from) && other.isBefore(to));	
		}
	}