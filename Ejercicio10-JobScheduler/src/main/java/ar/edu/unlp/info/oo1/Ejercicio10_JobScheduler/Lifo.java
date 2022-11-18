package ar.edu.unlp.info.oo1.Ejercicio10_JobScheduler;

public class Lifo extends JobScheduler{
	
	
//* ultimo en entrar primero en salir en salir (PILA)
	public JobDescription next() {
		JobDescription nextJob = null;
		if(this.jobs != null){
			nextJob = jobs.get(jobs.size()-1);
			this.unschedule(nextJob);
		}
		return nextJob;
	}
}
