package ar.edu.unlp.objetos.uno.Ejerciocio17_FacturaciondeLlamadas;

import java.time.LocalDateTime;
import java.util.ArrayList;

public abstract class Persona {
	private String nombre;
	private String direccion;
	private String nroTelefono;
	private ArrayList<Llamada> llamadas;
	private ArrayList<Factura> facturas;
	
	public Persona(String nombre, String direccion, String nroTelefono) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.nroTelefono = nroTelefono;
		this.llamadas = new ArrayList<>();
		this.facturas = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getNroTelefono() {
		return nroTelefono;
	}

	public ArrayList<Llamada> getLlamadas() {
		return llamadas;
	}

	public ArrayList<Factura> getFacturas() {
		return facturas;
	}
	
	public LlamadaLocal registrarLlamadaLocal(LocalDateTime comienzo, int duracion, String emisor, String  receptor) {
		LlamadaLocal llamadaLocal = new LlamadaLocal(comienzo,duracion,emisor,receptor);
		this.llamadas.add(llamadaLocal);
		return llamadaLocal;
	}
	
	public LlamadaInterUrbana registrarLlamadaInterUrbana(LocalDateTime comienzo, int duracion, String emisor, String receptor, int distancia) {
		LlamadaInterUrbana llamadaInterUrbana = new LlamadaInterUrbana(comienzo,duracion,emisor,receptor,distancia);
		this.llamadas.add(llamadaInterUrbana);
		return llamadaInterUrbana;
	}
	
	public LlamadaInternacional registrarLlamadaInternacional(LocalDateTime comienzo, int duracion, String emisor, String receptor, String paisOrigen, String paisDestino) {
		LlamadaInternacional llamadaInternacional = new LlamadaInternacional(comienzo,duracion,emisor,receptor,paisOrigen,paisDestino);
		this.llamadas.add(llamadaInternacional);
		return llamadaInternacional;
	}
	
	public Factura facturarLLamadas(LocalDateTime comienzo, LocalDateTime fin) {
		Factura factura = new Factura(comienzo,fin,LocalDateTime.now(),this.calcularMontoTotal(comienzo, fin));
		facturas.add(factura);
		return factura;
	}
	
	public double calcularMontoTotal(LocalDateTime comienzo, LocalDateTime fin) {
		return this.llamadas.stream().filter(l -> l.lapso(comienzo, fin)).mapToDouble(l -> l.calcularCosto()).sum();
	}	
}