package ar.edu.unlp.objetos.uno.Ejercicio18_LiquidacionDeHaberes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

public class Empleado {
	private String nombre, apellido, cuil;
	private boolean conyuge, hijo;
	private LocalDate fechaNacimiento, fechaIngreso;
	private ArrayList<Contrato> contratos;
	
	public Empleado(String nombre, String apellido, String cuil, boolean conyuge, boolean hijo,
			LocalDate fechaNacimiento) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.cuil = cuil;
		this.conyuge = conyuge;
		this.hijo = hijo;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaIngreso = LocalDate.now();
		this.contratos = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getCuil() {
		return cuil;
	}

	public boolean getConyuge() {
		return conyuge;
	}

	public boolean getHijo() {
		return hijo;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}
	
	public void altaContratoPlanta(LocalDate fechaInicio, double sueldo, double montoConyuge, double montoHijo) {
		ContratoPlanta contrato = new ContratoPlanta(fechaInicio, sueldo, montoConyuge, montoHijo);
		this.contratos.add(contrato);
	}
	
	public void altaContratoHora(LocalDate fechaInicio, LocalDate fechaFin, int horas, double valorHora) {
		ContratoHora contrato = new ContratoHora(fechaInicio, fechaFin, valorHora, horas);
		this.contratos.add(contrato);
	}
	
	/*calcular el aumento que se le debe aplicar al sueldo dependiendo de los años de antiguedad*/
	public double calcularAumento() {
		if((this.getAntiguedad() >= 5)&&(this.getAntiguedad() < 10)) {
			return 0.3;
		}
		else if((this.getAntiguedad() >= 10)&&(this.getAntiguedad() < 15)) {
			return 0.5;
		}
		else if((this.getAntiguedad() >= 15)&&(this.getAntiguedad() < 20)) {
			return 0.7;
		}
		else if(this.getAntiguedad() >= 20) {
			return 1;
		}
		return 0;
	}
	
	public int getAntiguedad() {
		return (int) contratos.stream().mapToInt(c -> c.calcularAños()).sum();
	}
	
	public double calcularMontoTotal() {
		if(!this.tieneContratoVencido()) {
			return this.buscarContratoVigente().map(c -> c.calcularMonto() + c.calcularMonto() * this.calcularAumento()).orElse(0d);
		}
		return 0;
	}
	
	public Optional<Contrato> buscarContratoVigente() {
		return contratos.stream().max((c1, c2) -> c1.getFechaInicio().compareTo(c2.getFechaInicio()));
	}
	
	public boolean tieneContratoVencido() {
		return this.buscarContratoVigente().map(c -> c.estaVencido()).orElse(true);
	}
	
	public Recibo generarRecibo() {
		Recibo recibo = new Recibo(this.getAntiguedad(), this.calcularMontoTotal());
		return recibo;
	}
}