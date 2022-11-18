package ar.edu.unlp.info.oo1.Ejercicio12_VolumenYSuperficies;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReporteDeConstruccionTest {
	private ReporteDeConstruccion reporte;
	private Cilindro cilindro;
	private Esfera esfera;
	private PrismaRectangular prisma;
	
	/*constructores*/
	
	@BeforeEach
	public void setUp () {
		reporte = new ReporteDeConstruccion();
		
		/*superficie = 172.787596  / volumen = 392.699082 */
		cilindro = new Cilindro("plastico","mierda",5,5);
		
		/*superficie = 314.159265/ volumen = 523.598776 */
		esfera = new Esfera("plastico","mostaza",5); 
		
		/*superficie = 150 / volumen = 125 */
		prisma = new PrismaRectangular ("mosdera","mostaza",5,5,5); 
	
		
	}
	@Test
	public void volumenTest() {
		assertEquals(0,this.reporte.getVolumenDeMaterial("plastico"));
		this.reporte.agregarPiezza(prisma);
		this.reporte.agregarPiezza(prisma);
		this.reporte.agregarPiezza(esfera);
		this.reporte.agregarPiezza(cilindro);
		assertEquals(916.295878, reporte.getVolumenDeMaterial("plastico"),1);
	}
	
	@Test
	public void superficieTest() {
		assertEquals(0,this.reporte.getSuperficieDeColor("mostaza"));
		this.reporte.agregarPiezza(prisma);
		this.reporte.agregarPiezza(prisma);
		this.reporte.agregarPiezza(esfera);
		assertEquals(614.159265, reporte.getSuperficieDeColor("mostaza"),1);
	}
	
}
