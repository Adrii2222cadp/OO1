package ar.edu.unlp.objetos.uno.Ejerciocio17_FacturaciondeLlamadas;
	
	import java.time.LocalDateTime;

	public abstract class Llamada {
		private String emisor;
		private String receptor; 
		private int duracion;
		private LocalDateTime comienzo;

		public Llamada(LocalDateTime comienzo, int duracion, String emisor, String receptor) {
			this.emisor = emisor;
			this.receptor = receptor;
			this.duracion = duracion;
			this.comienzo = comienzo;
		}

		public String getEmisor() {
			return emisor;
		}

		public String getReceptor() {
			return receptor;
		}

		public int getDuracion() {
			return duracion;
		}

		public LocalDateTime getComienzo() {
			return comienzo;
		}

		public boolean lapso(LocalDateTime comienzo, LocalDateTime fin) {
			return this.getComienzo().isAfter(comienzo) || this.getComienzo().isBefore(fin) ||
					this.getComienzo().isEqual(comienzo) || this.getComienzo().isEqual(fin);
		}

		protected double calcularCosto(double monto) {
			return duracion*monto;
		}


		abstract double calcularCosto();
	}