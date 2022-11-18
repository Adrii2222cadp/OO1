package ar.edu.unlp.info.oo1.AlquilerDePropiedades;

import java.util.ArrayList;
import java.util.List;

public class Propiedad {

	private String nombre;
	private String descripcion;
	private String direccion;
	private Usuario propietario;
	private double precioPorNoche;
	private List<Reserva> reservas;
	
	
	public Propiedad(String nombre, String descripcion, String direccion, double precioPorNoche,
					 Usuario propietario) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.direccion = direccion;
		this.propietario = propietario;
		this.precioPorNoche = precioPorNoche;
		this.reservas = new ArrayList<>();
	}

	public boolean disponibilidad(DateLapse unPeriodo) {
		return reservas.stream().noneMatch(r -> r.overLaps(unPeriodo));
	}
	
	public void agregarReserva(Reserva unaReserva) {
		this.reservas.add(unaReserva);
	}
	
	public void eliminarReserva(Reserva unaReserva) {
		this.reservas.remove(unaReserva);
	}
	
	public double calcularIngresosPropiedad(DateLapse unPeriodo){
		return this.reservas.stream().filter(r -> r.overLaps(unPeriodo)).mapToDouble(r -> r.calcularPrecioReserva()).sum();
	}
	
	public double calcularPrecio(int dias) {
		return this.getPrecioPorNoche()*dias;
	}
	
	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getDireccion() {
		return direccion;
	}

	public Usuario getPropietario() {
		return propietario;
	}

	public double getPrecioPorNoche() {
		return precioPorNoche;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}
}
