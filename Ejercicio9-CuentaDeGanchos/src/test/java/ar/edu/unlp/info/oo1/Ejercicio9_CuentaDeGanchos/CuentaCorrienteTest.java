package ar.edu.unlp.info.oo1.Ejercicio9_CuentaDeGanchos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class CuentaCorrienteTest {
	private CuentaCorriente unaCuenta;
	private  CuentaCorriente cuentaATransferir;
	
	@BeforeEach
	public void setUp() {
		unaCuenta = new CuentaCorriente();
		cuentaATransferir = new CuentaCorriente();
	}
	
	@Test
	/*chequeamos que los valores inicializados sean los correctos*/
	public void testConstructor() {
		assertEquals(0 ,unaCuenta.getSaldo());
		assertEquals(0 ,cuentaATransferir.getDescubierto());
	}
	@Test
	public void testExtraer() {
		unaCuenta.depositar(2000);
		unaCuenta.setDescubierto(10000);
		assertFalse(unaCuenta.puedeExtraer(13000));
		assertTrue(unaCuenta.puedeExtraer(12000));
		unaCuenta.extraer(12000);
		assertEquals(-10000, unaCuenta.getSaldo());
	}
	
	@Test
	public void testDepositar() {
		unaCuenta.depositar(10000);
		assertEquals(10000, unaCuenta.getSaldo());
		
	}
	@Test
	public void testTransferir() {
		unaCuenta.depositar(100);
		unaCuenta.setDescubierto(500);
		unaCuenta.transferirACuenta(500, cuentaATransferir);
		assertEquals(500, cuentaATransferir.getSaldo());	
	}
}
