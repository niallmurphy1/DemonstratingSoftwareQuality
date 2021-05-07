package entities;

import java.util.ArrayList;

public class Student {

    private String name;
    private ArrayList<StudentGrade> grades;

    public Student() {
        name = "";
        grades = new ArrayList<>();
    }

    public Student(String name, ArrayList<StudentGrade> grades) {
        this.name = name;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<StudentGrade> getGrades() {
        return grades;
    }

    public void setGrades(ArrayList<StudentGrade> grades) {
        this.grades = grades;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", grades=" + grades +
                '}';
    }
}
