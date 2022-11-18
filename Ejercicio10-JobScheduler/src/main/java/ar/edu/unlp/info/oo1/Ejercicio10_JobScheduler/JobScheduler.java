package ar.edu.unlp.info.oo1.Ejercicio10_JobScheduler;

import java.util.ArrayList;
import java.util.List;

public abstract class JobScheduler { //* programador de trabajos
    protected List<JobDescription> jobs;  //* lista de trabajos
    protected String strategy;      
    
  	//* constructor, inicializa la lista de trabajos
    public JobScheduler () {              
    	this.jobs = new ArrayList<>();  
    	this.strategy = "FIFO";
    }
  //* agrega un trabajo al final de la lista de trabajos
    public void schedule(JobDescription job) { 
    	this.jobs.add(job);                  
    }
  //* quita de la lista el trabajo
    public void unschedule(JobDescription job) { 
    	if (job != null) {
    	   this.jobs.remove(job);
    	}
    }
    
    public List<JobDescription> getJobs(){
    	return jobs;
    }
    
    public void setStrategy(String aStrategy) {
    	this.strategy = aStrategy; 
    }
    
    public abstract JobDescription next();
}

