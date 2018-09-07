import Controller.StudentController;
import Controller.TeacherController;
import Model.Student;

public class Main {

    public static void main(String[] args) {
        TeacherController teacherController = new TeacherController();
        teacherController.loadTeacherFile();
        teacherController.printTeacher();
    }
}
