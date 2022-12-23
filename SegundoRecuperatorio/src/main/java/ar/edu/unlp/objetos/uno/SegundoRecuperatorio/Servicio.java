package ar.edu.unlp.objetos.uno.SegundoRecuperatorio;

public abstract class Servicio {

	private double precioPorHora;
	private int cantidadDeHoras;
	
	public Servicio(double precioPorHora, int cantidadDeHoras) {
		this.precioPorHora = precioPorHora;
		this.cantidadDeHoras = cantidadDeHoras;
	}
	
	abstract double calcularMonto() ;
	
	
	protected double montoBasico() {
		return this.getPrecioPorHora()*this.getCantidadDeHoras();
	}

	public double getPrecioPorHora() {
		return precioPorHora;
	}

	public int getCantidadDeHoras() {
		return cantidadDeHoras;
	}
	
	
}
