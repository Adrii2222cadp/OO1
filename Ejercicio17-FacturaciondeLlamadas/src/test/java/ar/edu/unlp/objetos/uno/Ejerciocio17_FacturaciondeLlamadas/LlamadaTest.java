package ar.edu.unlp.objetos.uno.Ejerciocio17_FacturaciondeLlamadas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LlamadaTest {
	private LlamadaLocal local;
	private LlamadaInterUrbana interUrbana;
	private LlamadaInternacional internacional;
	
	@BeforeEach
	public void setUp() {
		local = new LlamadaLocal(LocalDateTime.of(2022, 11, 20, 9, 0), 0, null, null);
		
		interUrbana = new LlamadaInterUrbana(LocalDateTime.of(2022, 11, 20, 9, 0), 10, null, null, 99);
		
		internacional = new LlamadaInternacional(LocalDateTime.of(2022, 11, 20, 7, 59), 10, null, null, null, null);
		
	}
	
	@Test public void llamadaLocalTest() {
		assertEquals(0,local.calcularCosto());
		
		local = new LlamadaLocal(LocalDateTime.of(2022, 11, 20, 9, 0), 10, null, null);
		assertEquals(10,local.calcularCosto());
	}
	
	@Test
	public void llamadaInterUrbanaTest() {
		/*valores menores a 100*/
		assertEquals(25,interUrbana.calcularCosto());
		
		/*valores mayores a 100, pero menores a 500*/
		interUrbana = new LlamadaInterUrbana(LocalDateTime.of(2022, 11, 20, 9, 0), 10, null, null, 100);
		assertEquals(30,interUrbana.calcularCosto());
		interUrbana = new LlamadaInterUrbana(LocalDateTime.of(2022, 11, 20, 9, 0), 10, null, null, 499);
		assertEquals(30,interUrbana.calcularCosto());
		
		/*valores mayores a 500*/
		interUrbana = new LlamadaInterUrbana(LocalDateTime.of(2022, 11, 20, 9, 0), 10, null, null, 500);
		assertEquals(35,interUrbana.calcularCosto());
	}
	
	@Test
	public void llamadaInternacionalTest() {
		/*rangos para llamadas nocturas*/
		assertEquals(30,internacional.calcularCosto());
		internacional = new LlamadaInternacional(LocalDateTime.of(2022, 11, 20, 20, 1), 10, null, null, null, null);
		assertEquals(30,internacional.calcularCosto());
		
		/*rangos para llamadas diurnas*/
		internacional = new LlamadaInternacional(LocalDateTime.of(2022, 11, 20, 8, 0), 10, null, null, null, null);
		assertEquals(40,internacional.calcularCosto());
		internacional = new LlamadaInternacional(LocalDateTime.of(2022, 11, 20, 20, 0), 10, null, null, null, null);
		assertEquals(40,internacional.calcularCosto());
	}
	
}
