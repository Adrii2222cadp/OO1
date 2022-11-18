package ar.edu.unlp.info.oo1.Ejercicio16_PoliticaDeCancelacion;

import java.time.LocalDate;

public class CalcularFlexible implements PoliticaDeDevolucion{
	
	public CalcularFlexible() {		
	}

	public double calcularDevolucion(Reserva unaReserva, LocalDate unaFecha){
		if(unaFecha.isBefore(unaReserva.getPeriodo().getFrom())){
			return unaReserva.calcularPrecioReserva();
		}else {
			return 0;
		}
	}
}
