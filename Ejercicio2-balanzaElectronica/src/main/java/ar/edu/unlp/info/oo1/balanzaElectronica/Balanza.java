package ar.edu.unlp.info.oo1.balanzaElectronica;

import java.util.List;
import java.util.ArrayList;

public class Balanza extends Object{
	
	private ArrayList<Producto> productos;

  public Balanza() {		
	  productos = new ArrayList<Producto>();
  }	
	public Ticket emitirTicket() {
	//*	int cantProductos = productos.size();
	//*	double pesoTotal  = productos.stream().mapToDouble(Producto -> Producto.getPeso()).sum();
	//*	double precioTotal= productos.stream().mapToDouble(Producto -> Producto.getPrecio()).sum();
 		Ticket ticket = new Ticket(this.getProductos(),this.getCantidadDeProductos(),this.getPesoTotal(),this.getPrecioTotal());
		return ticket;
	}
	/* Recorre la lista de productos*/
	public List<Producto> getProductos() {
		return this.productos;		
	}
	/*Retorna el tmaño de la lista u arreglo, si está vacio retorna cero "0" */
	public int getCantidadDeProductos() {
		return productos.size();	
	}
	/* Recorre la lista de productos suma todos los campos del  peso.*/
	public double getPesoTotal() {	
		return productos.stream().mapToDouble(Producto -> Producto.getPeso()).sum();
	}
	/* Recorre la lista de productos suma todos los campos del precio*/
	public double getPrecioTotal() {
		return productos.stream().mapToDouble(Producto -> Producto.getPrecio()).sum();
	}
	/*Vacia la lista de productos*/
	public void ponerEnCero()   { 
		productos.clear();
	
	}
	
	public void agregarProducto(Producto unProducto) {
		productos.add(unProducto);
		
	}
}
