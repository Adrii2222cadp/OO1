package ar.edu.unlp.info.oo1.AlquilerDePropiedades;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PropiedadTest {
	private Propiedad propiedad;
	private Usuario propietario;
	private Reserva reserva, reserva2, reserva3;
	private DateLapse periodo, periodo2, periodo3, periodoCalculo;
	
	@BeforeEach
	private void setUp() {
		propiedad = new Propiedad("Chalet","cua cuac", "CasaDePatos", 5000, propietario);
		
		propietario = new Usuario("Adrian", "Carlitos", 2222222);
		
		periodo = new DateLapse(LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 10));
		periodo2 = new DateLapse(LocalDate.of(2023, 1, 10), LocalDate.of(2023, 1, 20));
		periodo3= new DateLapse(LocalDate.of(2023, 1, 20), LocalDate.of(2023, 1, 30));
		periodoCalculo = new DateLapse(LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 31));
		
		reserva = new Reserva(periodo,propiedad);
		reserva2 = new Reserva(periodo2,propiedad);
		reserva3 = new Reserva(periodo3,propiedad);	
	}
	@Test
	public void agregarReserva() {
		assertEquals(0, propiedad.getReservas().size());
		this.propiedad.agregarReserva(reserva);
		assertEquals(1, propiedad.getReservas().size());
	}
	@Test
	public void eliminarReserva() {
		this.propietario.agregarReserva(reserva);
		assertEquals(1, propietario.getReservas().size());
		this.propietario.eliminarReserva(reserva);
		assertEquals(0, propietario.getReservas().size());
	}
	@Test
	public void disponibilidad() {
		this.propiedad.agregarReserva(reserva);
		this.propiedad.agregarReserva(reserva2);
		assertTrue(propiedad.disponibilidad(periodo3));
		assertFalse(propiedad.disponibilidad(periodo2));
	}
	@Test 
	public void calcularIngresoPropietario() {
		this.propiedad.agregarReserva(reserva);
		this.propiedad.agregarReserva(reserva2);
		assertEquals(95000, propiedad.calcularIngresosPropiedad(periodoCalculo));
	}
	@Test
	private void cacularPrecio() {
		assertEquals(50000, propiedad.calcularPrecio(10));
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
