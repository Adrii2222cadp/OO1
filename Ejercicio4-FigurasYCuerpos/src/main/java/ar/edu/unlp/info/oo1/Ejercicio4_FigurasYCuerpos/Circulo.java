package ar.edu.unlp.info.oo1.Ejercicio4_FigurasYCuerpos;

public class Circulo implements Figura{
	
	private double radio;
	private double diametro;
	
	
	
	public void setDiametro(double unDiametro) {
		diametro = unDiametro;
	}
	
	public double getDiametro() {
		return this.radio * 2;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}
	
	public double getRadio() {
		return radio;
	}

	public double getPerimetro() {
		return this.getDiametro() * Math.PI;
	}
	
	public double getArea() {
		return Math.PI * (this.radio * this.radio); 
	}
	
}
