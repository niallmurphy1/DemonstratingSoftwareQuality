package entities;

public class Topic {


    private String name;
    private Rubric rubric;


    public Topic(){


    }

    public Topic(String name, Rubric rubric) {
        this.name = name;
        this.rubric = rubric;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Rubric getRubric() {
        return rubric;
    }

    public void setRubric(Rubric rubric) {
        this.rubric = rubric;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "name='" + name + '\'' +
                ", rubric=" + rubric +
                '}';
    }
}
