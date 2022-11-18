package ar.edu.unlp.info.oo1.Ejercicio8_DistribuidoraElectrica;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	
	private String domicilio;
    private String nombre;
    private ArrayList<Consumo> consumos; /*0..**/
    private ArrayList<Factura> facturas; /*0..**/

   
    /*constructor*/
    public Usuario(String UnDomicilio, String unNombre){    	
    	this.domicilio = UnDomicilio;
    	this.nombre = unNombre;
    	this.consumos = new ArrayList<Consumo>();
    	this.facturas = new ArrayList<Factura>();
    	
    }
    /*Metodos pedidos*/
    public void agregarMedicion(Consumo unConsumo) {
    	consumos.add(unConsumo);
    }
    /*agrega una facturaa nuestra colecciòn*/
    public void agregaFactura(Factura unaFactura) {
    	this.facturas.add(unaFactura);
    }
    //*busca el ultimo consumo (el de la fecha mas reciente)*//
    /*metodo privado que reutilizamos*/
    public Consumo ultimoConsumo() {
    	return consumos.stream().max((consumo1,consumo2) -> consumo1.fecha()
    			.compareTo(consumo2.fecha())).orElse(null);
    }
    
    public Factura facturarEnBaseA(double unPrecioDeKw) {
    	Consumo ultimo = this.ultimoConsumo();
    	if(ultimo != null) {
    		if(ultimo.factorDePotencia()>0.8) {
    			return new Factura(ultimo.costoEnBaseA(unPrecioDeKw), 10, this);
    		}
    		return new Factura(ultimo.costoEnBaseA(unPrecioDeKw), 0, this);
    	}
    	
    	return new Factura(0, 0, this);
    }
    
    /*obtiene el consumo de energia activa desde elconsumo con fecha mas reciente.
     * si no hay ningùn consumo retorna 0 cero
     */
    public double ultimoConsumoActiva() {
    	if(this.ultimoConsumo()!= null) {
    		return this.ultimoConsumo().getConsumoDeEnergiaActiva();
    	}
    	return 0d;
	}
    
     public List<Factura> facturas(){
    	 return this.facturas;
     }

	public String getDomicilio() {
		return domicilio;
	}

	public String getNombre() {
		return nombre;
	}
     
	
     	
    
     
}
