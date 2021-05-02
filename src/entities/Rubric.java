package entities;

import java.util.ArrayList;

public class Rubric {

    String name;
    ArrayList<String> criteria;


    public Rubric(){

    }

    public Rubric(String name, ArrayList<String> criteria) {
        this.name = name;
        this.criteria = criteria;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getCriteria() {
        return criteria;
    }

    public void setCriteria(ArrayList<String> criteria) {
        this.criteria = criteria;
    }

    @Override
    public String toString() {
        return "Rubric{" +
                "name='" + name + '\'' +
                ", criteria=" + criteria +
                '}';
    }
}
