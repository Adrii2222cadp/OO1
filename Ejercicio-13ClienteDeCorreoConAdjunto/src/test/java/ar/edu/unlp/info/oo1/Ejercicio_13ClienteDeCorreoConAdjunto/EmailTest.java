package ar.edu.unlp.info.oo1.Ejercicio_13ClienteDeCorreoConAdjunto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmailTest {
	private Email email;
	private Archivo archivo;
	

	/*setUp*/
	@BeforeEach
	public void SetUp(){
	  this.email = new Email("Nombre    ","Cuerpo    "); /*vale 20 el email*/
	  this.archivo = new Archivo("NombreArch");
	}

	/*agregarAdjunto*/
	@Test
	public void testAgregarAdjunto(){
	  assertTrue(this.email.adjuntos().isEmpty()); 
	  this.email.agregarAdjunto(archivo);
	  assertFalse(this.email.adjuntos().isEmpty());
	}

	/*tamaño*/
	@Test
	public void testTamaño(){
	  this.email.agregarAdjunto(archivo);
	  assertEquals(30, email.tamaño());
	}

	/*contiene*/
	@Test
	public void testContiene() {
		assertFalse(this.email.contiene("Pepe"));
        assertTrue(this.email.contiene("Nombre    "));
	}
}
