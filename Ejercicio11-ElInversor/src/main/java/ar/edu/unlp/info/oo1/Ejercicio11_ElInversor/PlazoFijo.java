package ar.edu.unlp.info.oo1.Ejercicio11_ElInversor;

import java.time.LocalDate;


public class PlazoFijo implements Inversion{
	private LocalDate fecha;
	private double montoDepositado;
	private double porcentajeDeInteresDiario;
	
	public PlazoFijo(LocalDate unaFecha, double unMontoADepositar
			, double porcentajeDeInteresDiario) {
		this.fecha = unaFecha;
		this.montoDepositado = unMontoADepositar;
		this.porcentajeDeInteresDiario = porcentajeDeInteresDiario;
	}

	public LocalDate getFechaDeConstitucion() {
		return this.fecha;
	}


	public double getMontoDepositado() {
		return montoDepositado;
	}

	public double getPorcentajeDeInteresDiario() {
		return porcentajeDeInteresDiario;
	}
//*	public int compareTo(ChronoLocalDate otherDate)
	//*             (date2.compareTo(date1))
	
	public double getValorActual() {
		double dias = this.getFechaDeConstitucion().until(LocalDate.now()).getDays(); /*Cuenta la cantidad de dias*/
		return this.montoDepositado + (this.getPorcentajeDeInteresDiario() * dias);
	}
}