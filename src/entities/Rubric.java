package entities;

import java.util.ArrayList;

public class Rubric {


    private String topicName;
    private ArrayList<Student> students;
    private ArrayList<String> criteria;

    public Rubric(){

        students = new ArrayList<>();
        criteria = new ArrayList<>();

    }

    public Rubric(String topicName, ArrayList<Student> students, ArrayList<String> criteria) {
        this.topicName = topicName;
        this.students = students;
        this.criteria = criteria;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
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
                "topicName='" + topicName + '\'' +
                ", students=" + students +
                ", criteria=" + criteria +
                '}';
    }
}
