package ar.edu.unlp.info.oo1.Ejercicio12_VolumenYSuperficies;

public abstract class Pieza {
	private String material;
	private String color;
	
	public Pieza(String unMaterial, String unColor) {
		this.material = unMaterial;
		this.color = unColor;
	}
	
	public String getMaterial() {
		return material;
	}



	public String getColor() {
		return color;
	}


	public abstract double getSuperficieDeColor();
	public abstract double getVolumenDeMaterial();	
	
}
