import driver.Controller;
import entities.Rubric;
import entities.Student;
import entities.StudentGrade;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

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
    public void getRubricByName(){
        ArrayList<Rubric> rubrics = new ArrayList<>();
        rubrics.add(testRubric());
        assertEquals(controller.getRubricByName("Accounting", rubrics), testRubric().toString());

    }




    @Test
    public void initialRubricsTest(){

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

    @Test
    public void standardDeviationCriteriaNonExisting(){
        rubrics.add(testRubric());
        assertEquals(controller.getStandardDeviationOfSpecificCriteria(testRubric().getStudents(), ""), "Criterion not found!");
    }



    @Test
    public void standardDeviationCriteriaExistingSameValues(){

        rubrics.add(testRubric());
        rubrics.add(testRubric());
        rubrics.add(testRubric());
        ArrayList<Student> students = new ArrayList<>();

        for(Rubric rubric: rubrics){
            students.addAll(rubric.getStudents());
        }
        assertEquals(controller.getStandardDeviationOfSpecificCriteria(students, "COA"), "Standard Deviation for COA: 0.0");


    }


    @Test
    public void standardDeviationCriteriaExisting(){

        ArrayList<Student> testStudents = new ArrayList<>();

        ArrayList<StudentGrade> exampleGrades = new ArrayList<>();
        StudentGrade exampleGrade1 = new StudentGrade("Account Check", 5);

        exampleGrades.add(exampleGrade1);

        Student testStudent = new Student("Chelsea Blakemore", exampleGrades);

        testStudents.add(testStudent);

        StudentGrade anotherGrade1 = new StudentGrade("Account Check", 4);
        StudentGrade anotherGrade2 = new StudentGrade("Account Check", 3);
        StudentGrade anotherGrade3 = new StudentGrade("Account Check", 5);
        StudentGrade anotherGrade4 = new StudentGrade("Account Check", 5);

        Student testStudent2 = new Student("Ronald McDonald", new ArrayList<StudentGrade>(Arrays.asList(anotherGrade1)));
        Student testStudent3 = new Student("Maureen Ponderossa",  new ArrayList<StudentGrade>(Arrays.asList(anotherGrade2)));
        Student testStudent4 = new Student("Dennis Reynolds",  new ArrayList<StudentGrade>(Arrays.asList(anotherGrade3)));
        Student testStudent5 = new Student("Charlie Kelly",  new ArrayList<StudentGrade>(Arrays.asList(anotherGrade4)));


        testStudents.add(testStudent2);
        testStudents.add(testStudent3);
        testStudents.add(testStudent4);
        testStudents.add(testStudent5);


        assertEquals(controller.getStandardDeviationOfSpecificCriteria(testStudents, "Account Check"), "Standard Deviation for Account Check: 0.7999999999999999");


    }




}
