package ar.edu.unlp.info.oo1.Ejercicio16_PoliticaDeCancelacion;

import java.util.ArrayList;

public class Usuario {
	private String nombre;
	private String direccion;
	private int dni;
    private ArrayList<Reserva> reservas;
    private ArrayList<Propiedad> propiedades;
    
	
    
    public Usuario(String unNombre, String unaDireccion, int unDni) {
		this.nombre = unNombre;
		this.direccion = unaDireccion;
		this.dni = unDni;
		reservas = new ArrayList<>();
		propiedades = new ArrayList<>();
	}



	public String getNombre() {
		return nombre;
	}



	public String getDireccion() {
		return direccion;
	}



	public int getDni() {
		return dni;
	}



	public ArrayList<Reserva> getReservas() {
		return reservas;
	}

	public ArrayList<Propiedad> getPropiedades() {
		return propiedades;
	}
	
	public void agregarReserva(Reserva unaReserva) {
		this.reservas.add(unaReserva);
	}
	
	public void eliminarReserva(Reserva unaReserva) {
		this.reservas.remove(unaReserva);
		
	}
	
	public void agregarPropiedad(Propiedad unaPropiedad) {
		this.propiedades.add(unaPropiedad);
	}
	
	public void eliminarPropiedad(Propiedad unaPropiedad) {
		this.propiedades.remove(unaPropiedad);
	}
	
	public double calcularIngresosDePropietario(DateLapse unPeriodo) {
		return this.propiedades.stream().mapToDouble(p -> p.calcularIngresosPropiedad(unPeriodo)).sum();
	}   
}









