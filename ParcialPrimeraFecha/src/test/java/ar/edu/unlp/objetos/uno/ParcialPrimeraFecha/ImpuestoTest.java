package ar.edu.unlp.objetos.uno.ParcialPrimeraFecha;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class ImpuestoTest {
	
	private Contribuyente c;
	private Embarcacion e1, e2, e3;
	
	@BeforeEach
	void setUp() throws Exception {
		c = new Contribuyente("pepe","25 n° 2555" ,"18251258","mail","localidad" );
		e1 = c.registrarEmbarcacion("patente", LocalDate.of(2012, 11, 29) , 1000001 ,"nombre");
		e2 = c.registrarEmbarcacion("patente", LocalDate.of(2014, 12, 30) , 1000000 ,"nombre");
		e3 = c.registrarEmbarcacion("patente", LocalDate.of(2012, 12, 01) , 999999 ,"nombre");
	}
	
    @Test
    public void calcularImpuesto() {
    	/* mayor a los 10 años */
    	assertEquals(0, e1.calcularImpuesto());
    	assertEquals((e2.getValor()/100)*15, e2.calcularImpuesto());
    	assertEquals((999999/100)*10, e3.calcularImpuesto());
    	assertEquals((((100000/100)*15))+((999999/100)*10), c.calcularImpuestos());
    }
}