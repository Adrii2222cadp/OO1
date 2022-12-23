package ar.edu.unlp.objetos.uno.SegundoRecuperatorio;

public class Parquizacion extends Servicio{
	
	private int cantMaquinas;
	private double costoMantenimiento;
	
	public Parquizacion(double precioPorHora, int cantidadDeHoras, int cantMaquinas, double castoMantenimiento) {
		super(precioPorHora, cantidadDeHoras);
		this.cantMaquinas = cantMaquinas;
		this.costoMantenimiento = castoMantenimiento;
	}

	public int getCantMaquinas() {
		return cantMaquinas;
	}

	public double getCostoMantenimiento() {
		return costoMantenimiento;
	}

	public double calcularMonto() {
		return this.getCostoMantenimiento()*this.getCantMaquinas() + this.montoBasico();
	}
}
