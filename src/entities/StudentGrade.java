package entities;

public class Rubric {

    private String criterion;
    private int grade;

    public Rubric(String criterion, int grade) {
        this.criterion = criterion;
        this.grade = grade;
    }

    public Rubric(){}


    public String getCriterion() {
        return criterion;
    }

    public void setCriterion(String criterion) {
        this.criterion = criterion;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Rubric{" +
                "criterion='" + criterion + '\'' +
                ", grade=" + grade +
                '}';
    }
}
