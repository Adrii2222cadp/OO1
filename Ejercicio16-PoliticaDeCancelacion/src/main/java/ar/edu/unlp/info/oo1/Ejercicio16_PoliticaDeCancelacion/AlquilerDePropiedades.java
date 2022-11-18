package ar.edu.unlp.info.oo1.Ejercicio16_PoliticaDeCancelacion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AlquilerDePropiedades {
	private ArrayList<Usuario> usuarios;
	private ArrayList<Propiedad> propiedades;
	
	
	public AlquilerDePropiedades() {
		this.usuarios = new ArrayList<>();
		this.propiedades = new ArrayList<>();
	}	
	
	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public ArrayList<Propiedad> getPropiedades() {
		return propiedades;
	}

	public Usuario registrarUsuario(String unNombre, String unaDireccion, int unDni) {
		Usuario unUsuario = new Usuario(unNombre,unaDireccion,unDni);
		usuarios.add(unUsuario);
		return unUsuario;
		
	}
	
	public Propiedad registrarPropiedad(String unNombre, String unaDescripcion, String unaDireccion, 
					double precioPorNoche, Usuario unPropietario, PoliticaDeDevolucion unaPolitica){
		Propiedad unaPropiedad = new Propiedad(unNombre, unaDescripcion, unaDireccion, 2000, unPropietario, unaPolitica);
		this.propiedades.add(unaPropiedad);
		return unaPropiedad;
	}
	
	public List<Propiedad> buscarPropiedadesDisponibles(DateLapse unPeriodo){
		return this.propiedades.stream().filter(p -> p.disponibilidad(unPeriodo)).collect(Collectors.toList());
	}
		
	public Reserva reservar(DateLapse unPeriodo, Propiedad unaPropiedad, Usuario unUsuario) {
		if(unaPropiedad.disponibilidad(unPeriodo)){
			Reserva reserva = new Reserva(unPeriodo, unaPropiedad);
			unUsuario.agregarReserva(reserva);
			unaPropiedad.agregarReserva(reserva);
			return reserva;	
		}		
		return null;
	}
	
	public double devolucion(PoliticaDeDevolucion politica,Reserva unaReserva ,LocalDate fecha) {
		return  politica.calcularDevolucion(unaReserva, fecha);		
	}

	public void eliminarReserva(Reserva unaReserva){
		if(unaReserva.inicioPoterior()) {
			this.usuarios.stream().forEach(u -> u.eliminarReserva(unaReserva));
			this.propiedades.stream().forEach(p -> p.eliminarReserva(unaReserva));
		}
	}
	
	public ArrayList<Reserva> obtenerReservasDeUsuario(Usuario unUsuario) {
		return unUsuario.getReservas();		
	}
	
	public double calcularIngresosDePropietario(Usuario unPropietario, DateLapse unPeriodo) {
		return unPropietario.calcularIngresosDePropietario(unPeriodo);
	}	
}
