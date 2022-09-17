package ar.edu.unlp.info.oo1.balanzaElectronica;

import java.time.LocalDate;
import java.util.List;


public class Ticket {
	
	private LocalDate fecha;
	private List<Producto> listaProductos;
	private int cantidadDeProductos;
	private double pesoTotal;
	private double precioTotal;
	
	public Ticket(List<Producto> listaDeProductos, int unaCantidadDeProductos, double unPesoTotal, double unPrecioTotal) {
		fecha = LocalDate.now();
		listaProductos = listaDeProductos; 
		cantidadDeProductos = unaCantidadDeProductos;
		pesoTotal = unPesoTotal;
		precioTotal = unPrecioTotal;
	}

	public double impuesto() {
		return precioTotal * 0.21;
	}
	
	public int getCantidadDeProductos() {
		return cantidadDeProductos;
	}
	
	public double getPesoTotal() {
		return pesoTotal;
	}
	
	public double getPrecioTotal() {
		return precioTotal;
	}
	
	public LocalDate getFecha() {
		return fecha;
	}
	
	public List<Producto> getListaDeProductos(){
		return listaProductos;
	}
	
}
