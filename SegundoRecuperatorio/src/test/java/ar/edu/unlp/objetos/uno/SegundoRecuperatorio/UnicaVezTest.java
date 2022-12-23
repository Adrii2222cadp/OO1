package ar.edu.unlp.objetos.uno.SegundoRecuperatorio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Aca escribiremos los test de unidad para cada clase 
 * 
 */
public class UnicaVezTest {
	
	private Limpieza l1, l2, l3;
	private Parquizacion p1, p2, p3;
	private Cliente cliente;
	
	@BeforeEach
	void setUp() throws Exception {
		cliente = new Cliente("Adrian","176 nª 2657");
		
		l1 = new Limpieza(500, 4, 1000); /*Mayor a la tarifa y fin de semana*/ 
		l1 = new Limpieza(500, 2, 1000); /*igual a la tarifa*/
		l1 = new Limpieza(500, 1, 1000); /*Menor a la tarifa*/
		/* precioPorHora,cantidadDeHoras,cantMaquinas, castoMantenimiento*/
		cliente.contratarPorUnicaVez(LocalDate.of(2022, 12, 24), l1); /*2.300*/
		cliente.contratarPorUnicaVez(LocalDate.of(2022, 12, 26), l2); /*1.000*/
		cliente.contratarPorUnicaVez(LocalDate.of(2022, 12, 29), l3); /*1.000*/
		
		p1 = new Parquizacion(1000, 4, 2, 1000); 
		p2 = new Parquizacion(1000, 2, 2, 1000); 
		p3 = new Parquizacion(1000, 1, 1, 1000); 
		
		
		
		
	}
	
    @Test
    public void testMontoAPagar() {
        assertEquals(4300, cliente.montoAPagar());
    }
}








