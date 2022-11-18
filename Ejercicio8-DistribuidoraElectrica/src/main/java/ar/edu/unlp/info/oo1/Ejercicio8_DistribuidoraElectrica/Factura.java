package ar.edu.unlp.info.oo1.Ejercicio8_DistribuidoraElectrica;

import java.time.LocalDate;
public class Factura {

	private double montoEnergiaActiva;  /*2000*/
	private double descuento;             /*10*/
	private LocalDate fecha;
	private Usuario usuario;
	
	

	public Factura(double montoDeEnergiaActiva, double descuento, Usuario usuario) {
		super();
		this.montoEnergiaActiva = montoDeEnergiaActiva;
		this.descuento = descuento;
		this.fecha = LocalDate.now();
		this.usuario = usuario;
	}

	public double montoTotal(){
		return this.montoEnergiaActiva * (1 - this.descuento /100);
	}
	
	public double getMontoEnergiaActiva(){
		return montoEnergiaActiva;
	}
	
	public Usuario getUsuario() {
		return this.usuario;
	}
	
	public LocalDate getFecha() {
		return this.fecha;
	}
	
	public double getDescuento() {
		return this.descuento;
	}

}
