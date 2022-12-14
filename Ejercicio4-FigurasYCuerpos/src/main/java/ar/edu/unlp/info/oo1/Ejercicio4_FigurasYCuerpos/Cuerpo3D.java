
package ar.edu.unlp.info.oo1.Ejercicio4_FigurasYCuerpos;

public class Cuerpo3D  {
	
	private double altura;
	private Figura caraBasal;
	private double volumen;
	private double superficieExterior;


	public void setAltura(double unaAltura) {
		altura = unaAltura;
	}
	
	public double getAltura() {
		return altura;
	}
		
	public void setCaraBasal(Figura unaFigura) {
		this.caraBasal = unaFigura;
	}
	
	public double getVolumen() {
		this.volumen = getAltura() * caraBasal.getArea();
		return this.volumen;
	}
	public double getSuperficieExterior() {
		this.superficieExterior = 2 * caraBasal.getArea() + caraBasal.getPerimetro() * getAltura();
		return this.superficieExterior;
	}	
	
	
}
