import Controller.StudentController;
import Model.Student;

public class Main {

    public static void main(String[] args) {

        StudentController studentController = new StudentController();

        studentController.loadStudentsFile();
        studentController.addStudent("Bo");
        studentController.deleteStudents(4);
        studentController.saveStudentsFile();
        studentController.printStudents();

    }

}
