package ar.edu.unlp.objetos.uno.Ejerciocio17_FacturaciondeLlamadas;

import java.time.LocalDateTime;

public class Factura {

	private LocalDateTime inicio;
	private LocalDateTime fin;
	private LocalDateTime fechaEmision;
	private double monto;
	
	public Factura(LocalDateTime inicio, LocalDateTime fin, LocalDateTime fechaEmision, double monto) {
		this.inicio = inicio;
		this.fin = fin;
		this.fechaEmision = fechaEmision;
		this.monto = monto;
	}
}
