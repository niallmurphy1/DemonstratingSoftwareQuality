package entities;

import java.util.ArrayList;

public class Topic {


    private String name;
    private ArrayList<Rubric> grades;


    public Topic(){


    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Topic(String name, ArrayList<Rubric> rubrics) {
        this.name = name;
        this.grades = rubrics;
    }

    public ArrayList<Rubric> getGrades() {
        return grades;
    }

    public void setGrades(ArrayList<Rubric> grades) {
        this.grades = grades;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "name='" + name + '\'' +
                ", grades=" + grades +
                '}';
    }
}
