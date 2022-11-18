package ar.edu.unlp.info.oo1.Ejercicio12_VolumenYSuperficies;

public class Esfera extends Pieza {
	private int radio;
	/*constructor*/
	public Esfera(String unMaterial, String unColor, int radio) {
		super(unMaterial, unColor);
		this.radio = radio;
	}

	public int getRadio() {
		return radio;
	}

	@Override
	public double getSuperficieDeColor() {
		
	/* Math.pi entrega el valorde PI,	
	 En el " pow " primero el numero que queremos elevar y despues la potencia*/
		return (4*Math.PI*(Math.pow(this.getRadio(),2)));
	}
	/*1.33 equivale a 4/3 */
	@Override
	public double getVolumenDeMaterial() {
		return 1.333*Math.PI*Math.pow(this.getRadio(),3);
	}
}
