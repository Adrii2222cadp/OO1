package ar.edu.unlp.objetos.uno.Ejerciocio17_FacturaciondeLlamadas;

import java.time.LocalDateTime;

public class LlamadaInterUrbana extends Llamada{
	
	private int distancia;
	
	public LlamadaInterUrbana(LocalDateTime comienzo ,int duracion, String  emisor, String  receptor, int distancia) {
		super(comienzo,duracion,emisor,receptor);
		this.distancia = distancia;
	}
     
	public double calcularCosto() {
		if(this.getDistancia()<100) {
			return this.calcularCosto(2)+5;
		}
		else
			if(this.getDistancia()<= 500) {
				return this.calcularCosto(2.5)+5;
			}
			else
				return this.calcularCosto(3)+5 ;
	}
	
	public int getDistancia() {
		return this.distancia;
	}
}
