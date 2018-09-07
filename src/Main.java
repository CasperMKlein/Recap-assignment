import Controller.TeacherController;
import Viewer.Viewer;

public class Main {

    public static void main(String[] args) {

        Viewer viewer = new Viewer();
        viewer.menu();
        TeacherController teacherController = new TeacherController();
    }

}
