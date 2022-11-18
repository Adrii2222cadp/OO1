package ar.edu.unlp.info.oo1.Ejercicio_13ClienteDeCorreoConAdjunto;

import java.util.ArrayList;
import java.util.List;

public class Carpeta {

	private String nombre;
	private List<Email> emails;
	
	
	public Carpeta(String unNombre) {
		this.nombre = unNombre;
		emails = new ArrayList<>();
	}
	
	/*carpeta*/              
	public Email buscar(String texto) {
			    return this.emails.stream().filter(m -> m.contiene(texto)).findFirst().orElse(null);
		    
	}
	
	 public int tamañoEmails(){
	        return this.emails.stream().mapToInt(e -> e.tamaño()).sum();
	}
			    
	public void agregar(Email unEmail) {
		this.emails.add(unEmail);
	}
	
	public void eliminar(Email unEmail) {
		this.emails.remove(unEmail);
	}
	
	public void setNombre(String unNombre) {
		this.nombre = unNombre;
	}
	
	public String getNombre() {
		return this.nombre ;
	}
	
	public List<Email> getEmails(){
		return this.emails;
	}
	
}
