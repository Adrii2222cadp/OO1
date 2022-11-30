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
		c = new contribuyente("pepe", "123","mail","localidad" );
		e1 = c.registrarEmbarcacion("patente", LocalDate.of(2012, 11, 29) , 1000001 ,"nombre");
		e2 = c.registrarEmbarcacion("patente", LocalDate.of(2012, 11, 30) , 1000000 ,"nombre");
		e3 = c.registrarEmbarcacion("patente", LocalDate.of(2012, 12, 01) , 999999 ,"nombre");
	}
	
    @Test
    public void calcularImpuesto() {
    	/* mayor a los 10 años */
    	assertequals(0, e1.calcularImpuesto());
    	assertequals((100000/100)*15, e2.calcularImpuesto());
    	assertequals((999999/100)*10, e3.calcularImpuesto());
    	assertequals(((100000/100)*15))+((999999/100)*10), c.calcularImpuestos());
    }
}
