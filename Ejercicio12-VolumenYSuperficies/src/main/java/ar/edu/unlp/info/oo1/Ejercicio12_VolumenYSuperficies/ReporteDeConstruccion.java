package ar.edu.unlp.info.oo1.Ejercicio12_VolumenYSuperficies;

import java.util.ArrayList;

public class ReporteDeConstruccion {
	private ArrayList<Pieza> piezas;
	
	public ReporteDeConstruccion() {
		piezas = new ArrayList<>();
	}
	
	public void agregarPiezza(Pieza unaPieza) {
		this.piezas.add(unaPieza);
	}
	
	/*Recibe un material por parametro, y retorna la suma de los VOLUMENES de todas las piezas
	 * hechas de ese material*/
	
	public double getVolumenDeMaterial(String material) {
		return this.piezas.stream().filter(p -> p.getMaterial().equals(material)).
				mapToDouble(p -> p.getVolumenDeMaterial()).sum();
	}
	
	/*Recibe como parametro un color y retorna la suma de todas las superficies externas pintadas de ese COLOR*/
	public double getSuperficieDeColor(String color) {
		return this.piezas.stream().filter(p -> p.getColor().equals(color)).
			   mapToDouble(p -> p.getSuperficieDeColor()).sum();
	}
	
}
