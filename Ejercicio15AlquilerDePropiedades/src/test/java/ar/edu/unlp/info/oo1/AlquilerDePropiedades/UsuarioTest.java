package ar.edu.unlp.info.oo1.AlquilerDePropiedades;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UsuarioTest {
	
	private Usuario propietario,usuario;
	private DateLapse periodo,periodo2, periodo3,periodoCalculo;
	private Propiedad propiedad;
	private Reserva reserva, reserva2, reserva3;
	
	@BeforeEach
	private void setUp() {
		propietario = new Usuario("Adrian", "Carlitos", 2222222);
		
		
		usuario = new Usuario("Greta", "Vurrita", 2222222);
		
		
		periodo = new DateLapse(LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 10));
		periodo2 = new DateLapse(LocalDate.of(2023, 1, 10), LocalDate.of(2023, 1, 20));
		periodo3= new DateLapse(LocalDate.of(2023, 1, 20), LocalDate.of(2023, 1, 30));
		periodoCalculo = new DateLapse(LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 31));
		
		
		propiedad = new Propiedad("Chalet","cua cuac", "CasaDePatos", 5000, propietario);
		
		
		reserva = new Reserva(periodo,propiedad);
		reserva2 = new Reserva(periodo2,propiedad);
		reserva3 = new Reserva(periodo3,propiedad);
		}
		@Test
		public void agregarReserva() {
			assertEquals(0, usuario.getReservas().size());
			this.usuario.agregarReserva(reserva);
			assertEquals(1, usuario.getReservas().size());
		}
		@Test
		public void eliminarReserva() {
			this.propietario.agregarReserva(reserva);
			assertEquals(1, propietario.getReservas().size());
			this.propietario.eliminarReserva(reserva);
			assertEquals(0, propietario.getReservas().size());
		}
		@Test
		public void agregarPropiedad() {
			assertEquals(0, propietario.getPropiedades().size());
			this.propietario.agregarPropiedad(propiedad);
			assertEquals(1, propietario.getPropiedades().size());
		}
		@Test
		public void eliminarPropiedad() {
			this.usuario.agregarPropiedad(propiedad);
			assertEquals(1,usuario.getPropiedades().size());
			this.usuario.eliminarPropiedad(propiedad);
			assertEquals(0, usuario.getPropiedades().size());
		}
		@Test
		public void calcularIngresosDePropietario() {
			this.propietario.agregarPropiedad(propiedad);
			this.propiedad.agregarReserva(reserva);
			this.propiedad.agregarReserva(reserva2);
			this.propiedad.agregarReserva(reserva3);
			assertEquals(145000, propietario.calcularIngresosDePropietario(periodoCalculo));
		
		}
	}