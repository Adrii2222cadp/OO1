package ar.edu.unlp.objetos.uno.ParcialPrimeraFecha;

import java.time.LocalDate;
import java.util.ArrayList;

public class Sistema {
	
	private ArrayList<Contribuyente> contribuyentes;
	
	public Sistema() {
		
		contribuyentes = new ArrayList<>();		
	}
	
	public Contribuyente darAltaContribuyente(String nombre, String direccion, String eMail, String localidad) {
		
		contribuyente Contribuyente = new Contribuyente(nombre, direccion, eMail, localidad);
		contribuyentes.add(contribuyente);
		return contribuyente;
	}
	
	public Inmueble darAltaInmueble(String numeroDePartida, double valorLote, double valorEdificacion, Contribuyente contribuyente) {
		
		return contribuyente.registrarInmueble(numeroDePartida, valorLote, valorEdificacion, contribuyente);
	}
	
	public Automotor darDeAltaAutomotor(String patente, LocalDate fechas, double valor,  String marca, string modelo, Contribuyente contribuyente) {
		
		return contribuyente.registrarAutomotor(patente, fecha, valor, modelo);
	}

	public Embarcacion darDeAltaEmbarcacion(String patente, LocalDate fecha, double valor nombre, Contribuyente contribuyenye){
		
		return contribuyenye.registrar.Embarcacion(patente, fecha, valor);
	}
	
	public double calcularImpuesto(contribuyente contribuyente) {
		
		return contribuyente.calcularImpuesto();
	}
	
	public List<Contribuyenye> masPagaPorLocalidad(String localidad, int N){
		
		return contribuyente.stream().filter(c-> c.getLocalidad().equals(localidad)).sorted(c1,c2)->c2.calcularImpuesto()
				.compareTo(c1.calcularImpuesto()).limit(N).toList()	
	}
}