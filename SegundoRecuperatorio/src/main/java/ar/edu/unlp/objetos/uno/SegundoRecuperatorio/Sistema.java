package ar.edu.unlp.objetos.uno.SegundoRecuperatorio;

import java.time.LocalDate;
import java.util.ArrayList;

public class Sistema {
	
	private ArrayList <Cliente> clientes;
	private ArrayList <Servicio> servicios;

	public Sistema(){
		clientes = new ArrayList<>();
		servicios = new ArrayList<>();
	}
		
	public Cliente registrarCliente(String unNombre, String unaDireccion) {
		Cliente cliente = new Cliente(unNombre, unaDireccion);
		this.clientes.add(cliente);
		return cliente;
	}
	
	public Limpieza registrarUnServicioDeLimpieza(double precioPorHora, int cantHoras, double tarifa) {
		Limpieza servicio = new Limpieza(precioPorHora, cantHoras, tarifa);
		servicios.add(servicio);
		return servicio;
	}
	
	public Parquizacion registrarServicioDeParquizacion(double precioPorHora, int cantidadDeHoras, int cantMaquinas, double castoMantenimiento) {
		Parquizacion parquizacion = new Parquizacion( precioPorHora, cantidadDeHoras, cantMaquinas, castoMantenimiento);
		servicios.add(parquizacion);
		return parquizacion;
	}
	
	public void contratarPorUnicaVez(Cliente cliente, LocalDate fecha, Servicio servicio) {
		cliente.contratarPorUnicaVez(fecha, servicio);	
	}
	
	public void contratarDeFormaProlongada(Cliente cliente, Servicio servicio, LocalDate fechaInicial, int cantDias) {
		cliente.contratarDeFormaProlongada(servicio, fechaInicial, cantDias);
	}
	
	public int cantidadDeServiciosConMontoMayor(double unMonto) {
		return (int) servicios.stream().filter(s-> s.calcularMonto()> unMonto).count();
	}
	
	public double montoAPagarPorUnCliente(Cliente unCliente) {
		return (double) unCliente.montoAPagar();
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public ArrayList<Servicio> getServicios() {
		return servicios;
	}
}
	
