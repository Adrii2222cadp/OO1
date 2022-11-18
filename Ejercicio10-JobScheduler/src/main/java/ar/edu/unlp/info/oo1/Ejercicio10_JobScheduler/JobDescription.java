package ar.edu.unlp.info.oo1.Ejercicio10_JobScheduler;

public class JobDescription{
	
	private double effort;  //* esfuerzo
	
	private int priority;    //* prioridad
	
	private String description;//* descripcion
	
	public JobDescription (double anEffort, int aPriority, String aDescription) {
		this.effort = anEffort;
		this.priority = aPriority;
		this.description = aDescription;
	}
		
	public double getEffort() {
			return effort;
	} 
	
	public int getPriority() {
		return priority;
	}
	
	public String getDescription() {
		return this.description;
	}
}
