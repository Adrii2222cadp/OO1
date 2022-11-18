package ar.edu.unlp.info.oo1.AlquilerDePropiedades;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DateLapseTest {

	private DateLapse gestorDeFechas;
	private DateLapse futuro;
	private DateLapse lapsoSolapado; 
	private LocalDate diaInicial;
	private LocalDate diaFinal;
	private LocalDate otraFecha, otraFecha2;
	
	
	@BeforeEach   /*Acá inicializo*/
	public void setUp() {		
	    diaInicial= LocalDate.of(2022, 10, 02);
		diaFinal  = LocalDate.of(2022, 11, 02);
		
		otraFecha = LocalDate.of(2022, 10, 06);
		otraFecha2 = LocalDate.of(2022, 10, 01);
		gestorDeFechas = new DateLapse(diaInicial, diaFinal);
		futuro = new DateLapse(LocalDate.of(2023, 01, 10), LocalDate.of(2023, 01, 15));
		lapsoSolapado = new DateLapse(LocalDate.of(2023, 01, 14), LocalDate.of(2023, 01, 20));
	}
	@Test
	public void sizeIsDaysTest() {
		assertEquals(31, this.gestorDeFechas.sizeInDays());
	}
	@Test
	public void includesDateTest() {
		assertTrue(this.gestorDeFechas.includesDate(otraFecha));
		assertFalse(this.gestorDeFechas.includesDate(otraFecha2));
	}
	@Test
	public void testEqualsFrom() {
		assertTrue(gestorDeFechas.equalsFrom(diaInicial));
		assertFalse(gestorDeFechas.equalsFrom(otraFecha));
	}	
	@Test
	public void testEqualsTo() {
		assertTrue(gestorDeFechas.equalsTo(diaFinal));
		assertFalse(gestorDeFechas.equalsTo(otraFecha));
	}
	@Test
	public void laterForm() {
		assertFalse(gestorDeFechas.laterFrom());
		assertTrue(futuro.laterFrom());
	}
	@Test
	public void overLap() {
		assertFalse(futuro.overLap(gestorDeFechas));
		assertTrue(futuro.overLap(lapsoSolapado));
	}
	
}
