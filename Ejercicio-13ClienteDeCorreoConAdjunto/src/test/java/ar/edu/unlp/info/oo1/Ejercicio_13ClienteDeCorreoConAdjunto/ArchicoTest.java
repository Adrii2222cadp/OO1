package ar.edu.unlp.info.oo1.Ejercicio_13ClienteDeCorreoConAdjunto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArchicoTest {
	private Archivo archivo;
		
		@BeforeEach
		public void setUp() {
			archivo = new Archivo("Archivo   "); /*archivo = 10 char*/
		}
		
		@Test
		public void testTamaño() {
			assertEquals(10,archivo.tamañoArchivo());
		}
	}
