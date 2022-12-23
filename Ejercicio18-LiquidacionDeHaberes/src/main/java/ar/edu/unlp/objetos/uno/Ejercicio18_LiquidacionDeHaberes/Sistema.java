package ar.edu.unlp.objetos.uno.Ejercicio18_LiquidacionDeHaberes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Sistema {
	private ArrayList<Empleado> empleados;

	public Sistema() {
		this.empleados = new ArrayList<>();
	}
	
	public Empleado darAltaEmpleado(String nombre, String apellido, String cuil, LocalDate fechaNacimiento,
			boolean hijo, boolean conyuge) {
		Empleado empleado = new Empleado(nombre, apellido, cuil, conyuge, hijo, fechaNacimiento);
		this.empleados.add(empleado);
		return empleado;
	}
	
	public Empleado buscarEmpleado(String cuil) {
		return empleados.stream().filter(e -> e.getCuil().equals(cuil)).findFirst().orElse(null);
	}
	
	public void darBajaEmpleado(Empleado e) {
		this.empleados.remove(e);
	}
	
	public void darAltaContratoPlanta(Empleado e, double sueldo, double montoConyuge, double montoHijo, LocalDate fechaInicio) {
		e.altaContratoPlanta(fechaInicio, sueldo, montoConyuge, montoHijo);
	}
	
	public void darAltaContratoHora(Empleado e, LocalDate fechaInicio, LocalDate fechaFin, double valor, int cantHoras) {
		e.altaContratoHora(fechaInicio, fechaFin, cantHoras, valor);
	}
	
	public List<Recibo> generarRecibosDeSueldo(){
		return empleados.stream().map(e -> e.generarRecibo()).collect(Collectors.toList());
	}
	
	public List<Empleado> empleadosConContratosVencidos(){
		return empleados.stream().filter(e -> e.tieneContratoVencido()).collect(Collectors.toList());
	}
}