package ar.edu.unlp.objetos.uno.Ejerciocio17_FacturaciondeLlamadas;

import java.time.LocalDateTime;

public class PersonaJuridica extends Persona {
	private int cuit;
	private String tipo;
	
	public PersonaJuridica(String nombre, String direccion, String  nroTelefono, int cuit, String tipo) {
		super(nombre, direccion, nroTelefono);
		this.cuit = cuit;
		this.tipo = tipo;
	}
	
	public int getCuit() {
		return cuit;
	}

	public String getTipo() {
		return tipo;
	}

	public double calcularCosto(LocalDateTime comienzo, LocalDateTime fin) {
		return super.calcularMontoTotal(comienzo, fin );
	}
}