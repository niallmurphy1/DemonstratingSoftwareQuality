package driver;

import entities.Rubric;
import entities.Student;
import entities.StudentGrade;

import java.sql.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Controller {



    public Controller(){


        //TODO: comment these methods out to run Controller tests
        //initialRubrics();
        //mainMenu();

    }

    private ArrayList<Rubric> rubrics = new ArrayList<>();
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<StudentGrade> grades = new ArrayList<>();
    double standardDeviation = 0;
    double res = 0.0;
    double sq = 0.0;





    public void initialRubrics(){

        //Create example Rubric

               ArrayList<Student> exampleStudents = new ArrayList<>();

        ArrayList<StudentGrade> exampleGrades = new ArrayList<>();
        StudentGrade exampleGrade1 = new StudentGrade("Account Check", 5);
        StudentGrade exampleGrade2 = new StudentGrade("Balance Sheet", 3);
        StudentGrade exampleGrade3 = new StudentGrade("COA", 4);
        StudentGrade exampleGrade4 = new StudentGrade("Endowment", 5);

        exampleGrades.add(exampleGrade1);
        exampleGrades.add(exampleGrade2);
        exampleGrades.add(exampleGrade3);
        exampleGrades.add(exampleGrade4);

        Student exampleStudent = new Student("Chelsea Blakemore", exampleGrades);

        exampleStudents.add(exampleStudent);

        Rubric exampleRubric = new Rubric("Accounting", exampleStudents, new ArrayList<>(Arrays.asList("Account Check", "Balance Sheet", "COA", "Endowment")));

        System.out.println(exampleRubric.toString());

        grades.add(exampleGrade1);
        grades.add(exampleGrade2);
        grades.add(exampleGrade3);
        grades.add(exampleGrade4);
        students.add(exampleStudent);
        rubrics.add(exampleRubric);

    }


    public void mainMenu(){



        System.out.println("\nWelcome to the Student Grade hub!");
        System.out.println("-------------------------------");

        System.out.println("Please enter in a number corresponding to the options on screen ");
        System.out.println("-------------------------------");
        System.out.println("#1 Create a new Rubric");
        System.out.println("#2 Display All Rubrics");
        System.out.println("#3 Add a criterion to a Rubric ");
        System.out.println("#4 Find a Rubric by name");
        System.out.println("#5 Get Rubric statistics");
        System.out.println("-------------------------------");


        Scanner scan = new Scanner(System.in);

        switch (scan.next()){

            case("1"):
                createNewRubric();
                break;

            case ("2"):
                getAllRubrics();
                returnToMainMenu();
                break;

            case ("3"):
                addCriterionToRubric();
                break;

            case("4"):
                getRubricByName();
                break;

            case("5"):
                Scanner scanner = new Scanner(System.in);
                System.out.println(" Enter topic name for the Rubric you would like to see the stats of:" );

                String rubricName = scanner.nextLine();

                showRubricStats(rubricName, rubrics);
                break;

            default:
                System.out.println("That is not a permitted response!\n\n");
                //mainMenu();
                break;
        }
    }


    public void createNewRubric() {


        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Topic Name for new Rubric:");
        String topicName = scan.nextLine();
        System.out.println("\nAdd criteria to this Rubric");
        Rubric rubric = new Rubric();
        rubric.setTopicName(topicName);
        addCriterion(rubric, scan);
        System.out.println("Go back to main menu? y/n");
        if (scan.next().equalsIgnoreCase("y")) {
            mainMenu();
        } else if (scan.next().equalsIgnoreCase("n")) {
            System.out.println("Goodbye!");

        }
    }



    public ArrayList<Rubric> getAllRubrics(){

        ArrayList<Rubric> allRubrics = new ArrayList<>();

        for(Rubric rubric: rubrics){

            System.out.println(rubric.toString());
        }

        return allRubrics;
    }



    public void addCriterionToRubric(){

            Scanner scan = new Scanner(System.in);

            System.out.println("Enter in the topic name for the Rubric you you want to add to");

            String topicName = scan.nextLine();
            for(Rubric rubric: rubrics) {

                if (rubric.getTopicName().equalsIgnoreCase(topicName)) {

                    System.out.println("Rubric found!\n");

                    System.out.println("\nEnter criteria name to add:");
                    String criterion = scan.nextLine();

                    rubric.getCriteria().add(criterion);

                    System.out.println("Criterion: "+ criterion +" added!");

                    for(Student student: rubric.getStudents()){

                        System.out.println("Enter " + student.getName()+ "'s grade for " + criterion);

                        student.getGrades().add(new StudentGrade(criterion, scan.nextInt()));
                    }


                    System.out.println("Criterion added! \n"
                            + "Updated Rubric: " + rubric.toString()+"\n");

                    returnToMainMenu();

                }else {

                    System.out.println("Rubric not found!\n");



                    returnToMainMenu();

                }



            }


        }



    public void addCriterion(Rubric rubric, Scanner scan) {

        do{
            System.out.println("\nEnter name of criteria:");
            String criterion = scan.nextLine();

            System.out.println(criterion+ " added to Rubric: " + rubric.getTopicName());

            rubric.getCriteria().add(criterion);

            System.out.println("\nWould you like to continue adding Criteria? y/n");
            String choice =scan.nextLine();

            if(choice.equalsIgnoreCase("y")){

                addCriterion(rubric, scan);
            }else if (choice.equalsIgnoreCase("n")){

                System.out.println("\nAdd students and their grades to this Rubric");


                addStudents(rubric);

                rubrics.add(rubric);
                System.out.println("New Rubric added:  " + rubric.toString());

                mainMenu();

            }

        }while (rubric.getCriteria().size() <= 10);

        if (rubric.getCriteria().size() == 10)
            System.out.println("Rubric criteria max limit reached!\n ");



    }

    public void getRubricByName(){
        Scanner scan = new Scanner(System.in);

        System.out.println("\nEnter topic name to view Rubric!");
        String topicName = scan.nextLine();

        for(Rubric rubric: rubrics){

            if(rubric.getTopicName().equalsIgnoreCase(topicName)){

                System.out.println("Rubric found!");
                System.out.println(rubric.toString());

                System.out.println("Return to main menu? y/n");

                if(scan.next().equalsIgnoreCase("y")){
                    mainMenu();
                }else {
                    System.out.println("Goodbye!");
                }
            }else {
                System.out.println("Could not find Rubric! Return to main menu? y/n");
                if(scan.next().equalsIgnoreCase("y")){
                    mainMenu();
                }else {
                    System.out.println("Goodbye!");
                }
            }
        }

    }

    public String showRubricStats(String rubricName, ArrayList<Rubric> rubrics){
        String response = "";

        for(Rubric rubric: rubrics){

            if(rubric.getTopicName().equalsIgnoreCase(rubricName)){

               response = "Rubric max: " + getMaxGradeRubric(rubric)
                       +"\nRubric min: " + getMinGradeInRubric(rubric)
                       +"\nRubric average: " + getAverageOfRubric(rubric)
                       +"\nRubric standard deviation: " + getStandardDeviationOfRubric(rubric);

            }else{
                response = "Rubric not found!";
            }
        }
        return response;
    }

    public double getAverageOfRubric(Rubric rubric){

        int gradesSum = 0;
        int numGrades =0;

        for(Student student : rubric.getStudents()){

            for(StudentGrade grades: student.getGrades()){

                gradesSum = gradesSum + grades.getGrade();
                numGrades++;
            }

        }


        return gradesSum/numGrades;
    }

    public int getMinGradeInRubric(Rubric rubric){

        ArrayList<Integer> grades = new ArrayList<>();


        for(Student student : rubric.getStudents()){

            for(StudentGrade studentGrade: student.getGrades()){

               grades.add(studentGrade.getGrade());

            }

        }

        return grades.stream()
                .reduce(Integer::min)
                .get();

    }


    public int getMaxGradeRubric(Rubric rubric){

        ArrayList<Integer> grades = new ArrayList<>();


        for(Student student : rubric.getStudents()){

            for(StudentGrade studentGrade: student.getGrades()){

                grades.add(studentGrade.getGrade());

            }

        }

        return grades.stream()
                .reduce(Integer::max)
                .get();

    }

    public double getStandardDeviationOfRubric(Rubric rubric) {

        double mean = getAverageOfRubric(rubric);

        System.out.println("mean: " + mean);

        int sum = 0;

        ArrayList<Integer> grades = new ArrayList<>();


        for (Student student : rubric.getStudents()) {

            for (StudentGrade studentGrade : student.getGrades()) {

                grades.add(studentGrade.getGrade());

            }

        }
        int n = grades.size();

        for (int i = 0; i < n; i++) {
            sum = sum + grades.get(i);
        }
        mean = sum/(n);

        for (int i = 0; i < n; i++) {

            standardDeviation
                    = standardDeviation + Math.pow((grades.get(i) - mean), 2);

        }

        sq = standardDeviation / n;
        res = Math.sqrt(sq);




        return res;
    }


    public void getAverageOfSpecificCriteria(ArrayList<Student> students, String criteriaName){



    }

    public void getMaxOfCriteria(){}


    public void getMinOfCriteria(){}


    public void getStandardDeviationOfSpecificCriteria(){

    }

    public void addStudents(Rubric rubric){

        Scanner scanner = new Scanner(System.in);


        Student newStudent = new Student();
        System.out.println("Enter Student name:");
        String studentName = scanner.nextLine();

        newStudent.setName(studentName);

        for(String criterion: rubric.getCriteria()){
            System.out.println("enter "+ studentName +"'s grade for criteria: " + criterion);

            newStudent.getGrades().add(new StudentGrade(criterion, scanner.nextInt()));
            rubric.getStudents().add(newStudent);


        }

        System.out.println("Would you like to add another Student to the Rubric? y/n");
        scanner.nextLine();
        String yesNo= scanner.next();
        if(yesNo.equalsIgnoreCase("y")){

            addStudents(rubric);
        }else if(yesNo.equalsIgnoreCase("n")){

            System.out.println("Finished adding");
        }



    }


    void returnToMainMenu(){

        Scanner scan = new Scanner(System.in);
        System.out.println("would you like to return to the main menu? y/n");
        String choice = scan.next();

        if(choice.equalsIgnoreCase("y")){
            mainMenu();
        }else {
            System.out.println("Goodbye!");
        }
    }

    public static void main(String[] args) {
        new Controller();


    }

}
