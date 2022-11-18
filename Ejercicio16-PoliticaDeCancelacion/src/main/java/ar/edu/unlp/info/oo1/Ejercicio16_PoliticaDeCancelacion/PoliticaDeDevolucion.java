package ar.edu.unlp.info.oo1.Ejercicio16_PoliticaDeCancelacion;

import java.time.LocalDate;

public interface PoliticaDeDevolucion {
	public double calcularDevolucion(Reserva unaReserva, LocalDate unaFecha);
}