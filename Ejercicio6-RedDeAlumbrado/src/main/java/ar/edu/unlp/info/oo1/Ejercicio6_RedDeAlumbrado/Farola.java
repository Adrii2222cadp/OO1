package ar.edu.unlp.info.oo1.Ejercicio6_RedDeAlumbrado;

import java.util.ArrayList;
import java.util.List;

public class Farola {
	private ArrayList<Farola> redAlumbrado;
	private boolean estado;
	
	public Farola(){
		redAlumbrado = new ArrayList<Farola>();
		this.estado = false;
	}
	
	
	/* par como vecina*/
	public void pairWithNeighbor(Farola otraFarola) {
		if(!redAlumbrado.contains(otraFarola)) {
			redAlumbrado.add(otraFarola);
			otraFarola.agregarme(this);
		}
	}
	
	public void agregarme(Farola unaFarola) {
		this.redAlumbrado.add(unaFarola);
	}

	/* retorna sus farolas vecinas*/
	public List<Farola> getNeighbors() {
		return this.redAlumbrado;
	}
	/* Si la farola no esta encendida la enciende y propaga la acción */
	public boolean isOn() {
		return estado;
	}
	/*Si la farola no esta ensendida la ensiende y propaga la acción  */
	public void turnOn() {
		if(this.isOn()==false) {
			this.estado =true;
			this.redAlumbrado.forEach(pepe -> pepe.turnOn());
		}
	}
	
	public void turnOff() {
		if(this.isOn()==true) {
			this.estado =false;
			this.redAlumbrado.forEach(pepe -> pepe.turnOff());
		}
	}

}
