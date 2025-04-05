package Tp3exo2;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private List<Model> tasks;
    private String tache;
    private String etat;

    public Model() {
        tasks = new ArrayList<>();
    }

    public Model(String tache, String etat) {
        this.tache = tache;
        this.etat = etat;
    }

    public String getTache() {
        return tache;
    }

    public void setTache(String tache) {
        this.tache = tache;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public void add(Model task) {
        tasks.add(task);
    }

    public void delete(Model task) {
        tasks.remove(task);
    }

    public void edit(Model taskToEdit) {
    	if(taskToEdit.getEtat().equals("Accomplie"))
    	{
    		taskToEdit.setEtat("Non Accomplie");
    	}
    	else if(taskToEdit.getEtat().equals("Non Accomplie"))
    	{
    		taskToEdit.setEtat("Accomplie");
    	}
        
    }

    public List<Model> getTasks() {
        return tasks;
    }
}
