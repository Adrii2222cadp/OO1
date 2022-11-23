package ar.edu.unlp.objetos.uno.Ejerciocio17_FacturaciondeLlamadas;


import java.time.LocalDateTime;

public class LlamadaLocal extends Llamada {

	LlamadaLocal(LocalDateTime comienzo, int duracion, String emisor, String receptor){
		super(comienzo, duracion, emisor, receptor);
	}
	
	public double calcularCosto(){		
		return this.calcularCosto(1);
	}
}
