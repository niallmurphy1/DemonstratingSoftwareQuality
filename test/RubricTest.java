import entities.Rubric;
import entities.Student;
import entities.StudentGrade;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


import java.util.ArrayList;
import java.util.Arrays;

public class RubricTest{

    @Test
    public void rubricNameTest(){
        Rubric rubric = new Rubric();
        rubric.setTopicName("Accounting");
        assertEquals("Accounting", rubric.getTopicName());
    }

    @Test
    public void rubricNullStudentTest(){
        Rubric rubric = new Rubric();
        assertEquals(new ArrayList<Student>(), rubric.getStudents());
    }

    @Test
    public void nullCriteriaTest() {
        Rubric rubric = new Rubric();
        assertEquals(new ArrayList<String>(), rubric.getCriteria());

    }

    @Test
    public void createNewRubricToStringTest(){
        ArrayList<Student> testStudents = new ArrayList<>();
        ArrayList<String> criteria = new ArrayList<>();
        String name = "Accounting";
        criteria.add("Account Check");
        criteria.add("Balance Sheet");
        criteria.add("COA");
        criteria.add("Endowment");



        ArrayList<StudentGrade> exampleGrades = new ArrayList<>();
        StudentGrade exampleGrade1 = new StudentGrade("Account Check", 5);
        StudentGrade exampleGrade2 = new StudentGrade("Balance Sheet", 3);
        StudentGrade exampleGrade3 = new StudentGrade("COA", 4);
        StudentGrade exampleGrade4 = new StudentGrade("Endowment", 5);

        exampleGrades.add(exampleGrade1);
        exampleGrades.add(exampleGrade2);
        exampleGrades.add(exampleGrade3);
        exampleGrades.add(exampleGrade4);

        Student testStudent = new Student("Chelsea Blakemore", exampleGrades);

        testStudents.add(testStudent);

        Rubric testRubric = new Rubric("Accounting", testStudents, criteria);

        assertEquals(testRubric.toString(), new Rubric(name, testStudents, criteria).toString());

    }
}
