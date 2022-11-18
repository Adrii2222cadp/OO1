package ar.edu.unlp.info.oo1.Ejercicio16_PoliticaDeCancelacion;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CalcularModerada implements PoliticaDeDevolucion{
    
	public CalcularModerada(){		
	}
	
	public double calcularDevolucion(Reserva unaReserva, LocalDate unaFecha){
		if(unaFecha.isBefore(unaReserva.getPeriodo().getFrom())) {
			if ((unaFecha.until(unaReserva.getPeriodo().getFrom(), ChronoUnit.DAYS))>6) {
				return unaReserva.calcularPrecioReserva(); /*si la reserva se cancela 7 dias antes retorna el 100%    */
			}
			else {
				if(unaFecha.until(unaReserva.getPeriodo().getFrom(), ChronoUnit.DAYS)>=2) {
					return unaReserva.calcularPrecioReserva()/2; /*si la reserva se cancela 2 dias antes retorna el 50%     */
				}
			}
		}
		return 0; /*si la reserva se cancela con menos de 2 dias antes retorna 0 */
	}
}
