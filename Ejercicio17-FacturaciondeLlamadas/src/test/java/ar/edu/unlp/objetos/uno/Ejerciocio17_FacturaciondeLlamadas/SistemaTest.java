package ar.edu.unlp.objetos.uno.Ejerciocio17_FacturaciondeLlamadas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SistemaTest {

	private Sistema sistema;
	
	private PersonaFisica emisorF1;
	private PersonaFisica emisorF2;
	private PersonaFisica emisorF3;
	private PersonaFisica reseptorF4;

	private PersonaJuridica emisorJ1;
	private PersonaJuridica emisorJ2;
	private PersonaJuridica emisorJ3;
	private PersonaJuridica reseptorJ4;
	
	private LocalDateTime comienzo;
	private LocalDateTime fin;
	
	@BeforeEach
	/*acá instancio las variables*/
	private void setUp() throws Exception{
	
		sistema = new Sistema();
		/*cargamos los números en el sistema*/
		this.sistema.agregarNumeroDisponible("4762150");
		this.sistema.agregarNumeroDisponible("4762149");
		this.sistema.agregarNumeroDisponible("4762148");
		this.sistema.agregarNumeroDisponible("6666666");
		
		this.sistema.agregarNumeroDisponible("4644270");
		this.sistema.agregarNumeroDisponible("4762169");
		this.sistema.agregarNumeroDisponible("4762168");
		this.sistema.agregarNumeroDisponible("5555555");
	}
	@Test
	public void darDeAltaPersonaFisica(){
		emisorF1  = this.sistema.darDeAltaPersonaFisica("Adrian", "176 n°2657", 18251258);
		emisorF2  = this.sistema.darDeAltaPersonaFisica("Edy", "28 n°4628", 18251258);
		emisorF3  = this.sistema.darDeAltaPersonaFisica("Alejandro", "29 n°4648", 18251258);
		assertEquals(3, sistema.getPersonas().size());
		assertEquals(5, sistema.getNumeros().size());
		reseptorF4= this.sistema.darDeAltaPersonaFisica("Ely", "55 n°4628", 18251258);
		assertEquals(4, sistema.getNumeros().size());	
		assertEquals(4, sistema.getPersonas().size());
	}
	@Test
	public void darDeAltaPersonajuridica() {
		emisorJ1 = this.sistema.darDeAltaPersonaJuridica("Fasdas", "23 n° 4625", 30709756, "srl");
		emisorJ2 = this.sistema.darDeAltaPersonaJuridica("Caldos", "22 n° 4625", 30709756, "srl");
		assertEquals(2, sistema.getPersonas().size());
		assertEquals(6, sistema.getNumeros().size());
		emisorJ3 = this.sistema.darDeAltaPersonaJuridica("Bioservicios", "33 n° 4625", 30709756, "SA");
		reseptorJ4 = this.sistema.darDeAltaPersonaJuridica("Tecnologias", "43 n° 4625", 30709756, "SA");
		assertEquals(4, sistema.getPersonas().size());
		assertEquals(4, sistema.getNumeros().size());
	}
	public void registrarLlamadaLocal() {
		this.emisorF1  = this.sistema.darDeAltaPersonaFisica("Adrian", "176 n°2657", 18251258);
		this.reseptorF4 = this.sistema.darDeAltaPersonaFisica("Edy", "28 n°4628", 18251258);
		this.sistema.registrarLlamadaLocal(LocalDateTime.of(2022, 10, 10, 14, 10), 62, "4762150", "4762149");
														   /*año, mes,dia,hora,minuto ,*/
		assertEquals(62, emisorF1.calcularMonto(comienzo, comienzo));
	}
	public void registrarLlamadaInterUrbana() {
		this.emisorJ1 = this.sistema.darDeAltaPersonaJuridica("Fasdas", "23 n° 4625", 30709756, "srl");
		this.emisorJ2 = this.sistema.darDeAltaPersonaJuridica("Caldos", "22 n° 4625", 30709756, "srl");
		this.sistema.registrarLlamadaInterUrbana(LocalDateTime.of(2022, 11, 10, 12, 15), 25, "4762150", "4762149", 99);
		assertEquals(396, emisorJ1.calcularCosto(LocalDateTime.of(2022, 11, 10, 12, 15), LocalDateTime.of(2022, 11, 15, 12, 45)));
		
	/*	(99*2)+5=198*2=396*/
	}
	public void registrarLlamadaInternacional() {
		this.emisorJ1 = this.sistema.darDeAltaPersonaJuridica("Fasdas", "23 n° 4625", 30709756, "srl");
		this.emisorJ2 = this.sistema.darDeAltaPersonaJuridica("Caldos", "22 n° 4625", 30709756, "srl");
		this.sistema.registrarLlamadaInternacional(comienzo, 35, "4762150", "4762149", "Berisso", "Qatar");
		assertEquals();
		
		/*(35*)  */
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
