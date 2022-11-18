package ar.edu.unlp.info.oo1.Ejercicio16_PoliticaDeCancelacion;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReservaTest {
	private Reserva reserva, reserva2;
	private DateLapse periodo, periodo2,periodo3;
	private Propiedad propiedad;
	private Usuario propietario;
	private PoliticaDeDevolucion politica;
	
	@BeforeEach
	public void setUp(){
		periodo = new DateLapse(LocalDate.of(2023, 5, 1), LocalDate.of(2023, 5, 10));
		periodo2 = new DateLapse(LocalDate.of(2022, 5, 1), LocalDate.of(2022, 5, 10));
		periodo3 = new DateLapse(LocalDate.of(2022, 5, 3), LocalDate.of(2022, 5, 9));
		propietario = new Usuario("El mas capo", "direccion", 18251258);
		propiedad = new Propiedad("ChaleT", "ElPapo", "Apto para capos", 5000, propietario, politica);
		
		
		reserva2= new Reserva(periodo2, propiedad);
		reserva = new Reserva(periodo, propiedad);
	}
	@Test
	public void calcularPrecioReserva() {
		assertEquals(45000, this.reserva.calcularPrecioReserva());
	}
	@Test
	public void inicioPosterior() {
		assertTrue(reserva.inicioPoterior());
		assertFalse(reserva2.inicioPoterior());
	}
	@Test
	public void overLap() {
		assertTrue(reserva2.overLaps(periodo2));
		assertFalse(reserva2.overLaps(periodo3));
	}
	
	
	
	
	
	
	
	
	
	
}
