package ar.edu.unlp.info.oo1.Ejercicio9_CuentaDeGanchos;

public class CajaDeAhorro extends Cuenta{

	
	public void depositar(double unMonto) {
		super.depositar(unMonto - (unMonto * 0.02));
	}
	
	protected void extraerSinControlar(double unMonto) {
		super.extraerSinControlar(unMonto + (unMonto * 0.02));
	}
	@Override
	public boolean puedeExtraer(double unMonto) {
		if(this.getSaldo() >= unMonto + (unMonto * 0.02)) {
			return true;
		}		
		return false;
	}
	
}
