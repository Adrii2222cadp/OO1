package ar.edu.unlp.info.oo1.ejercicio5_genealogiaSalvaje;

import java.time.LocalDate;
import java.util.ArrayList;

public class Mamifero {
	private String identificador;
	private String especie;
	private LocalDate fechaNacimiento;
	/*familia*/		
	private Mamifero padre;
	private Mamifero madre;
	private ArrayList<Mamifero> familia = new ArrayList<Mamifero>();
	
	
	public Mamifero() {
		
	}

	public Mamifero(String identificador) {
		this.identificador = identificador;
/*		familia = new ArrayList<Mamifero>();*/
	}

	public Mamifero getPadre() {
		return padre;
	}
	
	public void setPadre(Mamifero unPadre) {
		this.padre = unPadre;
		familia.add(unPadre);
	}
	
	public Mamifero getMadre() {
		return madre;
	}
	
	public void setMadre(Mamifero unaMadre) {
		this.madre = unaMadre;
		familia.add(unaMadre);
	}
	
	/*abuelos maternos*/
	public Mamifero getAbueloMaterno() {
		if(madre==null) {
			return null;
		}
		else {
			return madre.getPadre();
		}
	}
	
	public Mamifero getAbuelaMaterna() {
		if(madre == null) {
			return null;
		}
		else {
			return madre.getMadre();
		}
	}
	/*abuelos paternos*/
	
	public Mamifero getAbueloPaterno() {
		if(padre==null) {
			return null;
		}
		else {
			return padre.getPadre();
		}
	}
	
	public Mamifero getAbuelaPaterna() {
		if(padre==null) {
			return null;
		}
		else {
			return padre.getMadre();
		}
	}
	
	public boolean getTieneComoAncestroA(Mamifero unMamifero) {		
		return ((this.padre == unMamifero || this.madre== unMamifero)
	}
	
	/*getters y setters*/
	public String getIdentificador() {
		return identificador;
	}
	
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	
	public String getEspecie() {
		return especie;
	}
	
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	
}
