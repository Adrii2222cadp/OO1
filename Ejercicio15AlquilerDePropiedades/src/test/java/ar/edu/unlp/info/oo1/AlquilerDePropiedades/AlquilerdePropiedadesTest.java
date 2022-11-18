package ar.edu.unlp.info.oo1.AlquilerDePropiedades;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AlquilerdePropiedadesTest {
	
	private AlquilerDePropiedades sistema;
	
	private Usuario propietario, propietario2,usuario,usuario2,usuario3;
	private DateLapse periodo,periodo2, periodo3,periodoCalculo, periodoLapso;
	private Propiedad propiedad,propiedad2,propiedad3;
	private Reserva reserva, reserva2, reserva3;
	
	@BeforeEach
	private void setUp() {
		sistema = new AlquilerDePropiedades();
		
		propietario  = sistema.registrarUsuario("Adrian", "Carlitos",4444444);
		propietario2 = sistema.registrarUsuario("Freta", "Patitos", 2222222);
		
		usuario  = sistema.registrarUsuario("Greta", "Vurrita", 2222222);
		usuario2 = sistema.registrarUsuario("Greoide", "Capita", 2222222);
		usuario3 = sistema.registrarUsuario("Gretuona", "Tontita", 2222222);
			
		propiedad  = sistema.registrarPropiedad("Chalet","cua cuac", "CasaDePatos", 5000, propietario);
		propiedad2 = sistema.registrarPropiedad("Casa"  ,"cua "    , "CasaDes"    , 5000, propietario);
		propiedad3 = sistema.registrarPropiedad("Pieza" ,"Grande " , "Des"        , 5000, propietario2);
		
		propietario.agregarPropiedad(propiedad);  /* 1 */
		propietario.agregarPropiedad(propiedad2); /* 2 */
		propietario2.agregarPropiedad(propiedad3);/* 3 */
		
		periodo       = new DateLapse(LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 10));
		periodo2      = new DateLapse(LocalDate.of(2023, 1, 10), LocalDate.of(2023, 1, 20));
		periodo3      = new DateLapse(LocalDate.of(2023, 1, 20), LocalDate.of(2023, 1, 30));
		periodoCalculo= new DateLapse(LocalDate.of(2023, 1, 9), LocalDate.of(2023, 1, 19));
		periodoLapso  = new DateLapse(LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 31));
		
		
	/*	reserva  = new Reserva(periodo ,propiedad);
		reserva2 = new Reserva(periodo2,propiedad);
		reserva3 = new Reserva(periodo3,propiedad);*/
		
	}
	@Test
	public void registrarUsuario() {
		assertEquals(5, sistema.getUsuarios().size());
		this.sistema.registrarUsuario("Adrian", "Carlitos",4444444);
		this.sistema.registrarUsuario("Greta", "Vurrita", 2222222);
		assertEquals(7, sistema.getUsuarios().size());	
	}
	@Test
	public void registrarPropiedad() {
		assertEquals(3, sistema.getPropiedades().size());
		this.sistema.registrarPropiedad("Chalet","cua cuac", "CasaDePatos", 5000, propietario);
		this.sistema.registrarPropiedad("Chalet","cua cuac", "CasaDePatos", 5000, propietario);
		assertEquals(5, sistema.getPropiedades().size());	
	}
	
	
	
	@Test	
	public void reservar() {
		this.sistema.reservar(periodo, propiedad, usuario);
		this.sistema.reservar(periodo2, propiedad, usuario);
		this.sistema.reservar(periodo3, propiedad, usuario3);
		assertEquals(2, this.usuario.getReservas().size());
		assertEquals(1, this.usuario3.getReservas().size());
	}
	
	
	
	
	
	
	
	
	
	@Test
	public void buscarPorpiedadDisponible() {	
		this.sistema.reservar(periodo, propiedad, usuario);
		this.sistema.reservar(periodo2, propiedad2, usuario2);
		this.sistema.reservar(periodo3, propiedad3, usuario3);
		assertEquals(1, sistema.buscarPropiedadesDisponibles(periodoCalculo).size());
	}
	
	@Test
	public void eliminarReserva() {
		this.sistema.reservar(periodo, propiedad, usuario);
		reserva2 = this.sistema.reservar(periodo2, propiedad2, usuario);
		
		this.sistema.reservar(periodo3, propiedad3, usuario);
		assertEquals(3, this.usuario.getReservas().size());
		
		this.sistema.eliminarReserva(reserva2);
		assertEquals(2, this.usuario.getReservas().size());
	}
	
	@Test
	public void  obtenerReservasUsuario() {
		this.sistema.reservar(periodo, propiedad, usuario);
		this.sistema.reservar(periodo2, propiedad2, usuario);
		this.sistema.reservar(periodo3, propiedad3, usuario3);
		assertEquals(2, this.sistema.obtenerReservasDeUsuario(usuario).size());
		assertEquals(1, this.sistema.obtenerReservasDeUsuario(usuario3).size());
	}
	
	
	
	
	@Test
	public void calcularIngresoDePropietario() {
		this.sistema.reservar(periodo,  propiedad, usuario);   //* 50000
		this.sistema.reservar(periodo2, propiedad2, usuario);  //* 55000 
		this.sistema.reservar(periodo3, propiedad3,usuario);//* 55000
		assertEquals(95000, this.sistema.calcularIngresosDePropietario(propietario, periodoLapso));
		assertEquals(45000, this.sistema.calcularIngresosDePropietario(propietario2, periodoLapso));
	}	
}
	
	
