package ar.edu.unlp.objetos.uno.ParcialPrimeraFecha;

public class Inmueble implements Bien {
	private String num;
	private double valorLote, valorEdificacion;
	
	public Inmueble(String num, double valorLote, double valorEdificacion) {
		super();
		this.num = num;
		this.valorLote = valorLote;
		this.valorEdificacion = valorEdificacion;
	}

	public String getNum() {
		return num;
	}

	public double getValorLote() {
		return valorLote;
	}

	public double getValorEdificacion() {
		return valorEdificacion;
	}
	
	public double calcularImpuesto() {
		return (valorLote + valorEdificacion)*0.01;
	}		
}
