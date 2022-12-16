package ar.edu.unlp.objetos.uno.Ejerciocio17_FacturaciondeLlamadas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SistemaTest {
	private Sistema sistema, sistemaSinRegistros;
	private PersonaJuridica personaConLlamadas, personaSinLlamadas;
	private PersonaFisica personaConLlamadas2, personaSinLlamadas2;
	
	@BeforeEach
	public void setUp(){
		sistemaSinRegistros = new Sistema();
		sistema = new Sistema();
		
		/*cargamos numeros a nuestro sistema*/
		sistema.AgregarNumeroDisponible("123");
		sistema.AgregarNumeroDisponible("456");
		sistema.AgregarNumeroDisponible("789");
		sistema.AgregarNumeroDisponible("1011");
		
		/*registramos personas en nuestro sistema*/
		
		/*personas juridicas*/
		personaConLlamadas = sistema.darDeAltaPersonaJurica("greta","tolosa", 1, "1"); /*num = 123*/
		personaSinLlamadas = sistema.darDeAltaPersonaJurica("adrian", "berisso", 1, "1"); /*num = 456*/
	
		/*personas fisicas*/
		personaConLlamadas2 = sistema.darDeAltaPersonaFisica("clemente", "tandil", 123); /*num = 789*/
		personaSinLlamadas2 = sistema.darDeAltaPersonaFisica("emanuel", "florencio varela", 123); /*num = 101*/
	}
	
	@Test
	public void altaDePersonasTest() {
		/*testeamos un sistema sin registros y uno con*/
		assertEquals(0,sistemaSinRegistros.getPersonas().size());
		assertEquals(0,sistemaSinRegistros.getNumeros().size());
		assertEquals(4,sistema.getPersonas().size());
	}
	
	@Test
	public void registrarLlamadasTest() {
		/*registramos que las llamadas se registren adecuadamente*/
		
		/*registro de llamadas a persona juridica*/
		sistema.registrarLlamadaLocal(null, 0, personaConLlamadas.getNroTelefono(), personaSinLlamadas.getNroTelefono());
		sistema.registrarLlamadaInterUrbana(null, 0, personaConLlamadas.getNroTelefono(), personaSinLlamadas.getNroTelefono(), 0);
		sistema.registrarLlamadaInternacional(null, 0, personaConLlamadas.getNroTelefono(), personaSinLlamadas.getNroTelefono(), null, null);
		
		/*registro de llamadas a personas fisicas*/
		sistema.registrarLlamadaLocal(null, 0, personaConLlamadas2.getNroTelefono(), personaSinLlamadas2.getNroTelefono());
		sistema.registrarLlamadaInterUrbana(null, 0, personaConLlamadas2.getNroTelefono(), personaSinLlamadas2.getNroTelefono(), 0);
		sistema.registrarLlamadaInternacional(null, 0, personaConLlamadas2.getNroTelefono(), personaSinLlamadas2.getNroTelefono(), null, null);
	
		assertEquals(0,personaSinLlamadas.getLlamadas().size());
		assertEquals(0,personaSinLlamadas2.getLlamadas().size());
		
		assertEquals(3,personaConLlamadas.getLlamadas().size());
		assertEquals(3,personaConLlamadas2.getLlamadas().size());
	}
	
	@Test 
	public void facturarLlamadasTest() {
		/*registro de llamadas a persona juridica*/
		sistema.registrarLlamadaLocal(LocalDateTime.of(2022, 10, 10, 10, 00), 10, personaConLlamadas.getNroTelefono(), personaSinLlamadas.getNroTelefono()); /*vale 10*/
		sistema.registrarLlamadaInterUrbana(LocalDateTime.of(2022, 10, 10, 10, 00), 10, personaConLlamadas.getNroTelefono(), personaSinLlamadas.getNroTelefono(), 45); /*vale 25*/
		sistema.registrarLlamadaInternacional(LocalDateTime.of(2022, 10, 10, 9, 0), 10, personaConLlamadas.getNroTelefono(), personaSinLlamadas.getNroTelefono(), null, null); ; /*vale 40*/
		
		assertEquals(0, sistema.facturarLlamada(personaSinLlamadas, LocalDateTime.of(2022, 10, 10, 10, 00), LocalDateTime.of(2022, 10, 11, 10, 00)).getMonto());
		assertEquals(75, sistema.facturarLlamada(personaConLlamadas, LocalDateTime.of(2022, 10, 6, 10, 00), LocalDateTime.of(2022, 10, 11, 10, 00)).getMonto());

		
		/*registro de llamadas a personas fisicas (se le aplica el 10 de descuento)*/
		sistema.registrarLlamadaLocal(LocalDateTime.of(2022, 10, 10, 10, 00), 10, personaConLlamadas2.getNroTelefono(), personaSinLlamadas2.getNroTelefono());
		sistema.registrarLlamadaInterUrbana(LocalDateTime.of(2022, 10, 10, 10, 00), 10, personaConLlamadas2.getNroTelefono(), personaSinLlamadas2.getNroTelefono(), 45);
		sistema.registrarLlamadaInternacional(LocalDateTime.of(2022, 10, 10, 9, 0), 10, personaConLlamadas2.getNroTelefono(), personaSinLlamadas2.getNroTelefono(), null, null);
		
		assertEquals(0, sistema.facturarLlamada(personaSinLlamadas2, LocalDateTime.of(2022, 10, 10, 10, 00), LocalDateTime.of(2022, 10, 11, 10, 00)).getMonto());
		assertEquals(67.5, sistema.facturarLlamada(personaConLlamadas2, LocalDateTime.of(2022, 10, 6, 10, 00), LocalDateTime.of(2022, 10, 11, 10, 00)).getMonto());		
	}
}