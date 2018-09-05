import Controller.StudentController;
import Model.Student;

public class Main {

    public static void main(String[] args) {

        StudentController studentController = new StudentController();

        studentController.LoadStudentsFile();
        studentController.AddStudent("Bo");
        studentController.SaveStudentsFile();

    }

}
