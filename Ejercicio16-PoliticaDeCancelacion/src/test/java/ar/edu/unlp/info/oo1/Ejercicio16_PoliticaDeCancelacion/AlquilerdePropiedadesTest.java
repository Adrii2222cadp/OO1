package ar.edu.unlp.info.oo1.Ejercicio16_PoliticaDeCancelacion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class AlquilerdePropiedadesTest {
	
	private AlquilerDePropiedades sistema;
	
	private Usuario propietario, propietario2,usuario,usuario2,usuario3;
	private DateLapse periodo,periodo2, periodo3,periodoCalculo, periodoLapso;
	private Propiedad propiedad,propiedad2,propiedad3;
	private Reserva reserva, reserva2;
	private PoliticaDeDevolucion politicaF, politicaE, politicaM;
	private LocalDate fechaSusp,fechaSusp1, fechaSusp2,fechaSusp21,fechaSusp22,fechaSusp3;
	
	
	@BeforeEach
	private void setUp() {
        sistema = new AlquilerDePropiedades();
		
		propietario  = sistema.registrarUsuario("Adrian", "Carlitos",4444444);
		propietario2 = sistema.registrarUsuario("Freta", "Patitos", 2222222);
		
		usuario  = sistema.registrarUsuario("Greta", "Vurrita", 2222222);
		usuario2 = sistema.registrarUsuario("Greoide", "Capita", 2222222);
		usuario3 = sistema.registrarUsuario("Gretuona", "Tontita", 2222222);
		
		politicaE = new CalcularEstricta();
		politicaM = new CalcularModerada();
		politicaF = new CalcularFlexible();

		
		propiedad  = sistema.registrarPropiedad("Chalet","cua cuac", "CasaDePatos", 5000, propietario, politicaF);
		propiedad2 = sistema.registrarPropiedad("Casa"  ,"cua "    , "CasaDes"    , 5000, propietario, politicaM);
		propiedad3 = sistema.registrarPropiedad("Pieza" ,"Grande " , "Des"        , 5000, propietario2, politicaE);
		
		propietario.agregarPropiedad(propiedad);  /* 1 */
		propietario.agregarPropiedad(propiedad2); /* 2 */
		propietario2.agregarPropiedad(propiedad3);/* 3 */
		
		
		
		periodo = new DateLapse(LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 10));
		fechaSusp = LocalDate.of(2022, 12, 12);
		fechaSusp1 = LocalDate.of(2022, 12, 30);
		
		periodo2      = new DateLapse(LocalDate.of(2023, 1, 10), LocalDate.of(2023, 1, 20));
		fechaSusp2= LocalDate.of(2023, 1, 3);
		fechaSusp21= LocalDate.of(2023, 1, 8);
		fechaSusp22= LocalDate.of(2023, 1, 9);
		
		periodo3  = new DateLapse(LocalDate.of(2023, 1, 21), LocalDate.of(2023, 1, 30));
		fechaSusp3= LocalDate.of(2023, 1, 19);
		
		periodoCalculo= new DateLapse(LocalDate.of(2023, 2, 1), LocalDate.of(2023, 2, 10));
		periodoLapso  = new DateLapse(LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 31));
		
	}
	@Test
	public void registrarUsuario() {
		assertEquals(5, sistema.getUsuarios().size());
		this.sistema.registrarUsuario("Adrian", "Carlitos",4444444);
		this.sistema.registrarUsuario("Greta", "Vurrita", 2222222);
		assertEquals(7, sistema.getUsuarios().size());	
	}
	@Test
	public void registrarPropiedad() {
		assertEquals(3, sistema.getPropiedades().size());
		this.sistema.registrarPropiedad("Chalet","cua cuac", "CasaDePatos", 5000, propietario,politicaM);
		this.sistema.registrarPropiedad("Chalet","cua cuac", "CasaDePatos", 5000, propietario,politicaE);
		assertEquals(5, sistema.getPropiedades().size());	
	}
	@Test	
	public void reservar() {
		this.sistema.reservar(periodo, propiedad, usuario);
		this.sistema.reservar(periodo2, propiedad, usuario);
		this.sistema.reservar(periodo3, propiedad, usuario3);
		assertEquals(2, this.usuario.getReservas().size());
		assertEquals(1, this.usuario3.getReservas().size());
	}
	@Test
	public void buscarPorpiedadDisponible() {	
		this.sistema.reservar(periodo, propiedad, usuario);   /*2023/1/1 -- 2023/1/10*/
		this.sistema.reservar(periodo2, propiedad2, usuario2);/*2023/1/10-- 2023/1/20*/
		this.sistema.reservar(periodo3, propiedad3, usuario3);/*2023/1/20-- *2023/1/30*/
		assertEquals(3, sistema.buscarPropiedadesDisponibles(periodoCalculo).size());/*2023/1/9--2023/1/19*/
	}
	@Test
	public void eliminarReserva() {
		this.sistema.reservar(periodo, propiedad, usuario);
		reserva2 = this.sistema.reservar(periodo2, propiedad2, usuario);
		
		this.sistema.reservar(periodo3, propiedad3, usuario);
		assertEquals(3, this.usuario.getReservas().size());
		
		this.sistema.eliminarReserva(reserva2);
		assertEquals(2, this.usuario.getReservas().size());
	}
	@Test
	public void  obtenerReservasUsuario() {
		this.sistema.reservar(periodo, propiedad, usuario);
		assertEquals(1, this.sistema.obtenerReservasDeUsuario(usuario).size());
		this.sistema.reservar(periodo2, propiedad2, usuario);
		this.sistema.reservar(periodo3, propiedad3, usuario3);
		assertEquals(2, this.sistema.obtenerReservasDeUsuario(usuario).size());
		assertEquals(1, this.sistema.obtenerReservasDeUsuario(usuario3).size());
	}
	@Test
	public void calcularIngresoDePropietario() {
		this.sistema.reservar(periodo,  propiedad,  usuario);   //* 50000
		this.sistema.reservar(periodo2, propiedad, usuario);  //* 55000 
		this.sistema.reservar(periodo3, propiedad3, usuario);//* 55000
		assertEquals(18000, this.sistema.calcularIngresosDePropietario(propietario, periodoLapso));	
	}	
	@Test
	public void devolucion() {
		/*Flexible*/
		reserva = this.sistema.reservar(periodo, propiedad, usuario); //*F 50000
		assertEquals(45000, this.sistema.devolucion(propiedad.getPolitica(), reserva, fechaSusp));
		
		
		/*Moderada*/
		reserva2 = this.sistema.reservar(periodo2, propiedad2, usuario2); //*F 45000
		assertEquals(45000, this.sistema.devolucion(propiedad.getPolitica(), reserva2, LocalDate.of(2023, 1, 1)));
			
		
		
		
		
		/*estricta*/
		
		reserva2= this.sistema.reservar(periodo2,propiedad2,usuario); //*M 45000 
		this.sistema.reservar(periodo3,propiedad3,usuario3);//*F 55000
		
		assertEquals(0 , this.sistema.devolucion(politicaM, reserva, fechaSusp));
		assertEquals(45000, this.sistema.devolucion(politicaM, reserva, fechaSusp));/* + de 7 dias*/
		assertEquals(22500, this.sistema.devolucion(politicaM, reserva, fechaSusp1)); /* 2 dias*/
		
		assertEquals(22500, sistema.devolucion(politicaM, reserva, fechaSusp21)); /* 2 dias*/
		assertEquals(0, sistema.devolucion(politicaM, reserva, fechaSusp22));
	}	
	
	/*periodo2      = new DateLapse(LocalDate.of(2023, 1, 10), LocalDate.of(2023, 1, 20));
	fechaSusp2= LocalDate.of(2023, 1, 3);
	fechaSusp21= LocalDate.of(2023, 1, 8);
	fechaSusp22= LocalDate.of(2023, 1, 9);*/
}