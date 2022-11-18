package ar.edu.unlp.info.oo1.AlquilerDePropiedades;

public class Reserva {
	private DateLapse periodo;
	private Propiedad propiedad;
	
	
	
	public Reserva(DateLapse periodo, Propiedad propiedad) {
		this.periodo = periodo;
		this.propiedad = propiedad;		
	}

	public double calcularPrecioReserva() {
		return this.propiedad.getPrecioPorNoche()*this.periodo.sizeInDays();
	}
	
	public boolean overLaps(DateLapse other) {
		return this.periodo.overLap(other);
	}
	
	public boolean inicioPoterior() {
		return this.periodo.laterFrom();
	}

	public DateLapse getPeriodo() {
		return periodo;
	}

	public Propiedad getPropiedad() {
		return propiedad;
	}
	
	
}