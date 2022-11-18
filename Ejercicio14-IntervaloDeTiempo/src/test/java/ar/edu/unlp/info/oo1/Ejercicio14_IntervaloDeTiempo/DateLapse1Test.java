package ar.edu.unlp.info.oo1.Ejercicio14_IntervaloDeTiempo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DateLapse1Test {

	private DateLapse1 gestorDeFechas;
	private LocalDate diaInicial;
	private LocalDate diaFinal;
	private LocalDate otraFecha, otraFecha2;
	
	@BeforeEach   /*Acá inicializo*/
	public void setUp() {		
	    diaInicial= LocalDate.of(2022, 10, 02);
		diaFinal  = LocalDate.of(2022, 11, 02);
		
		otraFecha = LocalDate.of(2022, 10, 06);
		otraFecha2 = LocalDate.of(2022, 10, 01);
		gestorDeFechas = new DateLapse1(diaInicial, diaFinal);		
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
}
