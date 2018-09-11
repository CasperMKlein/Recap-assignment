package Viewer;

import Controller.TeacherController;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class UITeacherMenu{
    public static void uiTeacherMenu() throws FileNotFoundException {
        TeacherController teacherController = new TeacherController();
        Scanner in = new Scanner(System.in);
        System.out.print("Teacher Menu\n"
        +"1: Print out all teachers\n"
        +"2: Add new teacher\n"
        +"3: Remove teacher\n"
        +"4: Back\n");
        String answer = in.nextLine();

        switch(answer){
            case "1":
                System.out.print("Overview of teachers:\n\n");
                teacherController.printTeachers();
                System.out.print("\n");
                uiTeacherMenu();
                break;
            case "2":
                System.out.print("Write new name for teacher:\n");
                answer = in.nextLine();
                teacherController.addTeacher(answer);
                teacherController.saveTeacher();
                System.out.println("Teacher added\n");
                uiTeacherMenu();
                break;
                case "3":
                    System.out.print("Write ID of a teacher you want to remove:\n");
                    answer = in.nextLine();
                    teacherController.deleteTeacher(Integer.parseInt(answer));
                    teacherController.saveTeacher();
                    uiTeacherMenu();
                break;
                case "4":
                    UIMainMenu.mainMenu();
                    break;
            default: uiTeacherMenu();
            break;
        }
    }
}