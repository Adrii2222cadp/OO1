package ar.edu.unlp.info.oo1.Ejercicio8_DistribuidoraElectrica;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Distribuidora {
	
	private double precioKw;
	private ArrayList<Usuario> usuarios;
		
	public Distribuidora(double unPrecioDeKw) {
		this.precioKw(unPrecioDeKw); 
		this.usuarios = new ArrayList<Usuario>();
	}
	
	public List<Usuario> getUsuarios(){
		return this.usuarios;
	}
	
	public void agregarUsuario(Usuario unUsuario) {
		usuarios.add(unUsuario);
	}
	
	public List<Factura> facturar() {
		return this.usuarios.stream().map((Usuario usu)-> usu
				.facturarEnBaseA(this.getPrecioKW()))
				.collect(Collectors.toList()); 
	}
	
	public double consumoTotalActiva(){
		return this.usuarios.stream().mapToDouble((Usuario usu)-> 
		usu.ultimoConsumoActiva()).sum();
				
	}
	
	public void precioKw(double unPrecioKw) {
		precioKw = unPrecioKw;
	}
	
    public double getPrecioKW() {
    	return this.precioKw;
    }
}
