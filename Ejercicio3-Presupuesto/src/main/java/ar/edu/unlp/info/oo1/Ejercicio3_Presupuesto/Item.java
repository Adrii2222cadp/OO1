package ar.edu.unlp.info.oo1.Ejercicio3_Presupuesto;

public class Item extends Object {
	
	private String detalle;
	private int cantidad;
	private double costoUnitario;
	
	
	public Item detalle(String unDetalle) {
		detalle = unDetalle;
		return this;
		
	}
	
	public String getDetalle() {
		return detalle;
	}
	
	public Item costoUnitario(double unCostoUnitario) {
		costoUnitario = unCostoUnitario;
		return this;
	}
	
	public double getCostoUnitario(){
		return costoUnitario;
	}

	public double costo() {
		double total = 0;
		total = (this.getCantidad()*this.getCostoUnitario());
		return total;
	}
	
	public int getCantidad() {
		return cantidad;
		
	}
	
	public Item cantidad(int unaCantidad) {
		cantidad = unaCantidad;
		return this; 
	}
		
}