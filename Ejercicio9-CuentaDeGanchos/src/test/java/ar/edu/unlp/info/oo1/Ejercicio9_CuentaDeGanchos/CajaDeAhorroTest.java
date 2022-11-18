package ar.edu.unlp.info.oo1.Ejercicio9_CuentaDeGanchos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CajaDeAhorroTest {
	
	private CajaDeAhorro unaCaja;
	private CajaDeAhorro otraCaja;
	
	@BeforeEach
	public void setUp() {
		unaCaja   = new CajaDeAhorro();
		otraCaja = new CajaDeAhorro();
	}
	
	@Test
	public void testConstructor() {
		assertEquals(0, unaCaja.getSaldo());
		assertEquals(0, otraCaja.getSaldo());
	}
	
	@Test
	public void testDepositar() {
		unaCaja.depositar(100);
		assertEquals(98, unaCaja.getSaldo());			
	}
	
	@Test
	public void testExtraer() {
		unaCaja.depositar(200);
		assertFalse(unaCaja.puedeExtraer(700));
		assertTrue(unaCaja.puedeExtraer(100));
		unaCaja.extraerSinControlar(100);
		assertEquals(94, unaCaja.getSaldo());
	}
	@Test
	public void TestTransferir() {
		unaCaja.depositar(200);
		unaCaja.transferirACuenta(100, otraCaja);
		assertEquals(98, otraCaja.getSaldo());
		assertEquals(94, unaCaja.getSaldo());
	}
	
	
}
