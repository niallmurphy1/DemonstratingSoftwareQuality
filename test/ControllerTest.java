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
        StudentGrade exampleGrade4 = new StudentGrade("Endowment", 5);

        exampleGrades.add(exampleGrade1);
        exampleGrades.add(exampleGrade2);
        exampleGrades.add(exampleGrade3);
        exampleGrades.add(exampleGrade4);

        Student testStudent = new Student("Chelsea Blakemore", exampleGrades);

        testStudents.add(testStudent);

        return new Rubric("Accounting", testStudents, criteria);

    }

    @Test
    public void initalRubricsTest(){

        ArrayList<Rubric> rubrics = new ArrayList<>();
        rubrics.add(testRubric());

        assertEquals(controller.initialRubrics().toString(),rubrics.toString());
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
        assertEquals(controller.getStandardDeviationOfRubric(testRubric()), .8660254037844386, 0.00);
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
                +"\nRubric standard deviation: 0.8660254037844386";
        assertEquals(controller.showRubricStats("Accounting", rubrics), expectedResult);
   }


   @Test
   public void  averageCriteriaTestNonExistingCriteria(){
        rubrics.add(testRubric());

        assertEquals(controller.getAverageOfSpecificCriteria(testRubric().getStudents(), ""), "Criterion not found!");

   }

   @Test
    public void averageCriteriaTestExistingCriteria(){
        rubrics.add(testRubric());
        assertEquals(controller.getAverageOfSpecificCriteria(testRubric().getStudents(), "Account check"), "Average of criteria Account check: 5");
   }


   @Test
   public void maxCriteriaTestNonExisting(){
        rubrics.add(testRubric());
        assertEquals(controller.getMaxOfCriteria(testRubric().getStudents(), ""), "Criterion not found!");
   }

   @Test
    public void maxCriteriaTestExisting(){
       rubrics.add(testRubric());
       assertEquals(controller.getMaxOfCriteria(testRubric().getStudents(), "COA"), "4");
   }

    @Test
    public void minCriteriaTestNonExisting(){
        rubrics.add(testRubric());
        assertEquals(controller.getMinOfCriteria(testRubric().getStudents(), ""), "Criterion not found!");
    }

    @Test
    public void minCriteriaTestExisting(){
        rubrics.add(testRubric());
        assertEquals(controller.getMinOfCriteria(testRubric().getStudents(), "COA"), "4");
    }


}
