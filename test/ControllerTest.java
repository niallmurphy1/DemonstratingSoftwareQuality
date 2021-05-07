import driver.Controller;
import entities.Rubric;
import entities.Student;
import entities.StudentGrade;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class ControllerTest {


    final Controller controller = new Controller();

    final ArrayList<Rubric> rubrics = new ArrayList<>();


    Rubric testRubric(){
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
        StudentGrade exampleGrade4 = new StudentGrade("Endowment", 4);

        exampleGrades.add(exampleGrade1);
        exampleGrades.add(exampleGrade2);
        exampleGrades.add(exampleGrade3);
        exampleGrades.add(exampleGrade4);

        Student testStudent = new Student("Chelsea Blakemore", exampleGrades);

        testStudents.add(testStudent);

        return new Rubric("Accounting", testStudents, criteria);

    }

   @Test
    public void getAllRubricsTest(){
       ArrayList<Rubric> emptyRubricList = new ArrayList<>();
       assertEquals(emptyRubricList, controller.getAllRubrics());
   }


   @Test
    public void averageGradeTest(){

       assertEquals(controller.getAverageOfRubric(testRubric()), 4.0, 0.0);

   }


   @Test
    public void minGradeRubricTest(){

       assertEquals(controller.getMinGradeInRubric(testRubric()), 3);

   }

   @Test
    public void maxGradeRubricTest(){
       assertEquals(controller.getMaxGradeRubric(testRubric()), 5);

   }

   @Test
    public void getStandardDeviationRubricTest(){
        assertEquals(controller.getStandardDeviationOfRubric(testRubric()), .7071067811865476, 0.00);
   }

   @Test
    public void showRubricStatsNonExistingRubricTest(){
        rubrics.add(testRubric());
        assertEquals(controller.showRubricStats("Software Design Patterns", rubrics), "Rubric not found!");
   }

   @Test
   public void showRubricStatsExistingRubric(){
        rubrics.add(testRubric());

        String expectedResult = "Rubric max: 5"
                + "\nRubric min: 3"
                +"\nRubric average: 4.0"
                +"\nRubric standard deviation: 0.7071067811865476";
        assertEquals(controller.showRubricStats("Accounting", rubrics), expectedResult);
   }


   @Test
   public void  AverageCriteriaTestNonExistingCriteria(){
        rubrics.add(testRubric());

   }
}
