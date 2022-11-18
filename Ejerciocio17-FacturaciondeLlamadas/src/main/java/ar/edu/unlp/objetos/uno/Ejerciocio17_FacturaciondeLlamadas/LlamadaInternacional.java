package ar.edu.unlp.objetos.uno.Ejerciocio17_FacturaciondeLlamadas;

import java.time.LocalDateTime;

public class LlamadaInternacional extends Llamada {
	private String paisOrigen;
	private String paisDestino;


	public LlamadaInternacional(LocalDateTime comienzo, int duracion, int emisor, int receptor,String paisOrigen, String paisDestino) {
		super(comienzo,duracion,emisor,receptor);
		this.paisOrigen = paisOrigen;
		this.paisDestino = paisDestino;
	}
	public String getPaisOrigen() {
		return paisOrigen;
	}
	public String getPaisDestino() {
		return paisDestino;
	}

	/*si la llamada es diurna (entre las 8am y las 20pm) retorna 4, sino, retorna 3*/
	public double calcularCosto() {
		if((this.getComienzo().getHour() > 8 && this.getComienzo().getMinute() > 0)&&
				(this.getComienzo().getHour() < 20 && this.getComienzo().getMinute() > 0)) {
			return this.calcularCosto(4);
		}
		else {
			return this.calcularCosto(3);
		}
		}


}