package ar.edu.unlp.info.oo1.Ejercicio9_CuentaDeGanchos;

public class CuentaCorriente extends Cuenta {
	private double descubierto;
	
	
	
	public CuentaCorriente() {
		super();
		this.descubierto = 0;
	}

	public void setDescubierto(double unDescubierto) {
		this.descubierto = unDescubierto;
	}
	
	public double getDescubierto(){
		return this.descubierto;
	}

	public boolean puedeExtraer(double unMonto) {		
			return this.getSaldo() +  this.getDescubierto() >= unMonto;
	}
	
}
