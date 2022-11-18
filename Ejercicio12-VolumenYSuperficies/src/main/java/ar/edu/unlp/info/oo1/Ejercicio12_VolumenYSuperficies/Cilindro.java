package ar.edu.unlp.info.oo1.Ejercicio12_VolumenYSuperficies;

public class Cilindro extends Pieza {
	private int radio;
	private int altura;
	
	public Cilindro(String unMaterial, String unColor, int radio, int altura) {
		super(unMaterial, unColor);
		this.radio = radio;
		this.altura = altura;
	}
	
	public int getRadio() {
		return radio;
	}
	public int getAltura() {
		return altura;
	}
	@Override
	public double getSuperficieDeColor() {
		return (2*Math.PI*this.getRadio()*this.getAltura())+
				(2*Math.PI*(Math.pow(this.getRadio(),2)));
	}
	@Override
	public double getVolumenDeMaterial() {
		return (Math.PI*(Math.pow(this.getRadio(),2))*this.getAltura());
	}

}
