package Viewer;

import java.util.Scanner;

public class UIMainMenu {

    public static Scanner in = new Scanner(System.in);

    public static void mainMenu() {

        System.out.println(
                "_____Welcome_____" +
                        "\nType a number to issue a command" +
                        "\n1: Student overview" +
                        "\n2: Course overview" +
                        "\n3: Subject overview" +
                        "\n4: Exam overview" +
                        "\n5: Teacher overview" +
                        "\n6: Save & exit"
        );

        String answer = in.nextLine();

        switch (answer) {
            case "1": UIStudentMenu.studentMenu();
                break;
            case "2": UICourseMenu.courseMenu();
                break;
            case "3": System.out.println("subject!!!");
                break;
            case "4": System.out.println("Exams!!!!!!!!");
                break;
            case "5": System.out.println("Teachers!!!!");
                break;
            case "6": // ¯\_(ツ)_/¯
                break;
            default: mainMenu();
                break;
        }
    }
}
