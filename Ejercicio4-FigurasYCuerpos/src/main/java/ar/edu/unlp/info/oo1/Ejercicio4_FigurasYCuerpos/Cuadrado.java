package ar.edu.unlp.info.oo1.Ejercicio4_FigurasYCuerpos;

public class Cuadrado implements Figura{
	
	private double lado;
	
	
	public double getLado() {
		return this.lado;
	}
	
	public void setLado(double lado) {
		this.lado = lado;
	}
	
	public double getPerimetro() {		
		return lado * 4;
	}
	
	public double getArea() {
		return this.lado * this.lado;
	}
	
}
