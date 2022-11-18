package ar.edu.unlp.info.oo1.Ejercicio_13ClienteDeCorreoConAdjunto;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

public class ClienteDeCorreo {

	private Carpeta inbox;
	private List<Carpeta> carpetas;
	
		public ClienteDeCorreo(String unNombre){
			inbox = new Carpeta(unNombre);
		    carpetas = new ArrayList<>();
	}
	
	public void recibirEmail(Email unEmail){
		this.inbox.agregar(unEmail);		
	}
	
	/*mueve el e mail recibido de la carpeta de origen a la carpeta destino*/
	public void moverEmail( Carpeta unOrigen, Carpeta unDestino, Email unEmail){
		unDestino.agregar(unEmail);
		unOrigen.eliminar(unEmail);
	}
		
	
	
	public Email buscarTexto (String texto) {	
			return this.carpetas.stream().map(C -> 
			C.buscar(texto)).findFirst().orElse(null);
		}	    
	
	/*y si agrego inbox a la lista de carpetas como primer elemento*/
	public int espacioOcupado() {
		return this.carpetas.stream().mapToInt(c -> 
			   c.tamañoEmails()).sum() + this.inbox.tamañoEmails() ;
	}
	
	public List<Carpeta> getCarpetas(){
		return carpetas;
	}
	

	public void agregarCarpeta(Carpeta unaCarpeta) {
		this.carpetas.add(unaCarpeta);
	}
	

	public Carpeta DevolverInbox() {
		return this.inbox;
	}
	
	public Carpeta getInbox() {
		return this.inbox;
	}
		
}


