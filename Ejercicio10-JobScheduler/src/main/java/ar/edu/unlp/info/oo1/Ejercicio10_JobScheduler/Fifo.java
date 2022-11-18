package ar.edu.unlp.info.oo1.Ejercicio10_JobScheduler;

public class Fifo extends JobScheduler{   //* primero en entrar primero en salir  (COLA)

	public JobDescription next() {  
		JobDescription nextJob = null; 
		if(this.jobs != null) {			
			nextJob = jobs.get(0);
			this.unschedule(nextJob);		
		}
		return nextJob;
    }
}