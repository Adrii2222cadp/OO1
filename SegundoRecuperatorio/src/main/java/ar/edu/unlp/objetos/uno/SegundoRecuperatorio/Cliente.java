package ar.edu.unlp.objetos.uno.SegundoRecuperatorio;

import java.time.LocalDate;
import java.util.ArrayList;

public class Cliente {
	private String nombre;
	private String direccion;
	private ArrayList<Contrato> contratos;
	
	public Cliente(String unNombre, String unaDireccion) {
		this.direccion = unaDireccion;
		this.nombre = unNombre;
		this.contratos = new ArrayList<>();
	}

	public void contratarPorUnicaVez(LocalDate fecha, Servicio servicio) {
		UnicaVez contrato =new UnicaVez(fecha, servicio);
		this.contratos.add(contrato);
	}
	
	public void contratarDeFormaProlongada(Servicio servicio, LocalDate fechaInicial, int cantDias) {
		Prolongada prolongado = new Prolongada(servicio, fechaInicial, cantDias);
		this.contratos.add(prolongado);
	}
	
	public double montoAPagar() {
		return this.contratos.stream().mapToDouble(c-> c.calcularMonto()).sum();
	}

	public String getNombre() {
		return nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public ArrayList<Contrato> getContratos() {
		return contratos;
	}
	
	
}
