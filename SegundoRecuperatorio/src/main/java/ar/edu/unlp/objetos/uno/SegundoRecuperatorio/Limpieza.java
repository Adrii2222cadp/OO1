package ar.edu.unlp.objetos.uno.SegundoRecuperatorio;

public class Limpieza extends Servicio{

	
	private double tarifaMinima;
	
	public Limpieza (double unPrecio, int cantHoras, double tarifa) {
		super(unPrecio, cantHoras);
		this.tarifaMinima = tarifa;
	}
	
	public double calcularMonto() {
		if(this.montoBasico()<this.getTarifaMinima()){
			return this.getTarifaMinima();
		}
		else {
			return this.montoBasico();
		}
	}
	public double getTarifaMinima() {
		return this.tarifaMinima;
	}
}