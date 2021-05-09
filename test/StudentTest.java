import entities.Student;
import entities.StudentGrade;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class StudentTest {


    @Test
    public void nullStudentGradeTest(){
        Student student = new Student();

        assertEquals(student.getGrades(), new ArrayList<StudentGrade>());
    }


    @Test
    public void nullStudentNameTest(){
        Student student = new Student();
        assertEquals(student.getName(), "");
    }

    @Test
    public void studentToStringTest() {

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

        String actual = "Student{" +
                "name='" + "Chelsea Blakemore" + '\'' +
                ", grades=" + testStudent.getGrades().toString() +
                '}';


        assertEquals(testStudent.toString(), actual);


    }

}
