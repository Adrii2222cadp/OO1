package ar.edu.unlp.objetos.uno.ParcialPrimeraFecha;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
	
	private ArrayList<Contribuyente> contribuyentes;
	
	public Sistema() {
		
		contribuyentes = new ArrayList<>();		
	}
	
	public Contribuyente darAltaContribuyente(String nombre, String dni ,String direccion, String email, String localidad) {
		
		Contribuyente contribuyente = new Contribuyente(nombre,dni,direccion,email,localidad);
		contribuyentes.add(contribuyente);
		return contribuyente;
	}
	
	public Inmueble darAltaInmueble(String numeroDePartida, double valorLote, double valorEdificacion, Contribuyente contribuyente) {
		
		return contribuyente.registrarInmueble(numeroDePartida, valorLote, valorEdificacion);
	}
	
	public Automotor darDeAltaAutomotor(String patente, LocalDate fecha, double valor,  String marca, String modelo, Contribuyente contribuyente) {
		
		return contribuyente.registrarAutomotor(patente, fecha, valor,marca, modelo);
	}

	public Embarcacion darDeAltaEmbarcacion(String patente, LocalDate fecha, double valor, String nombre, Contribuyente contribuyenye){
		
		return contribuyenye.registrarEmbarcacion(patente, fecha, valor, nombre);
	}
	
	public double calcularImpuesto(Contribuyente contribuyente) {
		
		return contribuyente.calcularImpuestos();
	}
	
	/*public List<Contribuyente> masPagaPorLocalidad(String localidad, int N){
		
		return contribuyentes.stream().sorted((c1, c2)->c2.calcularImpuesto()).
				                      /* sorted(p1, p2)->p1.x.                compareTo(p2.x)	
						
				   /* contribuyentes.stream().filter(c-> c.getLocalidad().equals("localidad").
			    *  sorted((c1,c2)()->c2.calcularImpuesto()).
				 compareTo(c1.calcularImpuesto()).limit(N).toList()));*/	
	
}