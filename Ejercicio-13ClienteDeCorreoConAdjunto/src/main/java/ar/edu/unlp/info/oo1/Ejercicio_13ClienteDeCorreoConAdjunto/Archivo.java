package ar.edu.unlp.info.oo1.Ejercicio_13ClienteDeCorreoConAdjunto;

public class Archivo {
	private String nombre;
	
	public Archivo(String unNombre) {
		this.nombre = unNombre;
	}
	
	public int tamañoArchivo(){
	    return this.nombre.length();
	  }
		

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
