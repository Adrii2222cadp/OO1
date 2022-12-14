package ar.edu.unlp.info.oo1.balanzaElectronica;

public class Producto extends Object{
	
	private double peso;
	private double precioPorKilo;
	private String descripcion;
	
	public Producto () {
		
	}
	
	public Producto(String unaDescripcion, double unPeso, double unPrecioPorKilo) {
		descripcion = unaDescripcion;
		peso = unPeso;
		precioPorKilo = unPrecioPorKilo;
		
	}
	
	public String getDescripcion() {
		return descripcion;
	}	
	
	public void setDescripcion(String unaDescripcion) {
		this.descripcion = unaDescripcion;
	}
	
	public double getPeso() {
		return peso;
	}
	
	public void setPeso(double unPeso) {
		peso = unPeso;
	}
	
	public double getPrecio() {
		return peso*precioPorKilo;
	}
	
	public void setPrecioPorKilo(double unPrecioPorKlilo) {
		precioPorKilo = unPrecioPorKlilo;
	}
	
	public double getPrecioPorKilo() {
		return precioPorKilo;
	}

}
