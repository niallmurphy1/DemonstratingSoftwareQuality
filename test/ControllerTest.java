import driver.Controller;
import entities.Rubric;
import entities.Student;
import entities.StudentGrade;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class ControllerTest {


    final Controller controller = new Controller();

   @Test
    public void getAllRubricsTest(){
       ArrayList<Rubric> emptyRubricList = new ArrayList<>();
       assertEquals(emptyRubricList, controller.getAllRubrics());
   }


   @Test
    public void averageGradeTest(){

       ArrayList<Student> testStudents = new ArrayList<>();
       ArrayList<String> criteria = new ArrayList<>();
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

       assertEquals(controller.getAverage(testRubric), 4.25, 0.0);


   }
}
