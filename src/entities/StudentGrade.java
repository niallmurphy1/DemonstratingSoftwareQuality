package entities;

public class StudentGrade {

    private String criterion;
    private int grade;

    public StudentGrade(String criterion, int grade) {
        this.criterion = criterion;
        this.grade = grade;
    }

    public StudentGrade(){

    }


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
        return "StudentGrade{" +
                "criterion='" + criterion + '\'' +
                ", grade=" + grade +
                '}';
    }
}
