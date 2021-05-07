import entities.Student;
import entities.StudentGrade;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

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

}
