package ar.edu.unlp.objetos.uno.ParcialPrimeraFecha;

import java.time.LocalDate;
import java.util.ArrayList;

public class Contribuyente {
	private ArrayList<Bien> bienes;
	private String nombre, direccion, dni, email, localidad;
	
	public Contribuyente(String nombre, String direccion, String dni, String email, String localidad) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.dni = dni;
		this.email = email;
		this.localidad = localidad;
		bienes = new ArrayList<>();
	}
	
	public ArrayList<Bien> getBienes() {
		return bienes;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getDni() {
		return dni;
	}

	public String getEmail() {
		return email;
	}

	public String getLocalidad() {
		return localidad;
	}
										
	public Inmueble registrarInmueble(String numero, double valorLote, double valorEdificacion) {
		Inmueble inmueble = new Inmueble(numero,valorLote,valorEdificacion);
		bienes.add(inmueble);
		return inmueble;
	}
	
	public Automotor registrarAutomotor(String patente, LocalDate fecha, double valor, String marca, String modelo) {
		Automotor automotor = new Automotor(patente,fecha,valor,marca,modelo);
		bienes.add(automotor);
		return automotor;
	}
	
	public Embarcacion registrarEmbarcacion(String patente, LocalDate fecha, double valor, String nombre) {
		Embarcacion embarcacion = new Embarcacion(patente,fecha,valor,nombre);
		bienes.add(embarcacion);
		return embarcacion;
	}
	
	public double calcularImpuestos() {
		return bienes.stream().mapToDouble(b -> b.calcularImpuesto()).sum();
	}	
}