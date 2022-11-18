package ar.edu.unlp.info.oo1.Ejercicio_13ClienteDeCorreoConAdjunto;

import java.util.ArrayList;
import java.util.List;

public class Email {
	private String titulo, cuerpo;
	private List<Archivo> adjuntos;
	
	public Email(String unTitulo, String unCuerpo) {
		this.titulo = unTitulo;
		this.cuerpo = unCuerpo;
		this.adjuntos = new ArrayList<>();
		
	}
	
	 /*metodo dentro de email*/
	 public boolean contiene(String texto) {
			return (this.titulo.equals(texto)) || (this.cuerpo.equals(texto));
		}
	
	public void agregarArchivo(Archivo unArchivo) {
		this.adjuntos.add(unArchivo);
	}
	
	public void eliminarArchivo(Archivo unArchivo) {
		this.adjuntos.remove(unArchivo);
		
	}
	
	  public int tamaño(){
	    	return this.titulo.length() + this.cuerpo.length() + this.adjuntos.stream().mapToInt(a -> a.tamañoArchivo()).sum();
	  }
	
	public String getTitulo() {
		return titulo;
	}
	public String getCuerpo() {
		return cuerpo;
	}
	
	public List<Archivo> adjuntos() {
		return this.adjuntos;
	}

	public void agregarAdjunto(Archivo archivo) {
		this.adjuntos.add(archivo);	
	}	
}
