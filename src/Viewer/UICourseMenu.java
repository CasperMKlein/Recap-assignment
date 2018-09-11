package Viewer;

import java.util.Scanner;

public class UICourseMenu {

    public static Scanner in = new Scanner(System.in);

    public static void courseMenu() {

        System.out.println(
                "_____Course menu_____" +
                        "\nType a number to issue a command" +
                        "\n1: Add new course" +
                        "\n2: View courses" +
                        "\n3: Update course" +
                        "\n4: Delete course" +
                        "\n5: Student assignment overview" +
                        "\n6: Teacher assignment overview" +
                        "\n7: Exam assignment overview" +
                        "\n8: Back"
        );

        String answer = in.nextLine();

        switch (answer) {
            case "1": courseMenu();
                break;
            case "2": courseMenu();
                break;
            case "3": courseMenu();
                break;
            case "4": courseMenu();
                break;
            case "5": studentMenu();
                break;
            case "6": teacherMenu();
                break;
            case "7": examMenu();
                break;
            case "8": UIMainMenu.mainMenu();
                break;
            default: courseMenu();
                break;
        }
    }

    private static void studentMenu() {

        System.out.println(
                "_____Assign students to courses_____" +
                        "\nType a number to issue a command" +
                        "\n1: Add student to course" +
                        "\n2: View students from course" +
                        "\n3: Update student from course" +
                        "\n4: Remove student from course" +
                        "\n5: View courses" +
                        "\n6: Back"
        );

        String answer = in.nextLine();

        switch (answer) {
            case "1": studentMenu();
                break;
            case "2": studentMenu();
                break;
            case "3": studentMenu();
                break;
            case "4": studentMenu();
                break;
            case "5": studentMenu();
                break;
            case "6": courseMenu();
                break;
            default: studentMenu();
                break;
        }

    }

    private static void teacherMenu() {

        System.out.println(
                "_____Assign teachers to courses_____" +
                        "\nType a number to issue a command" +
                        "\n1: Add teacher to course" +
                        "\n2: View teachers from course" +
                        "\n3: Update teacher from course" +
                        "\n4: Remove teacher from course" +
                        "\n5: View courses" +
                        "\n6: Back"
        );

        String answer = in.nextLine();

        switch (answer) {
            case "1": teacherMenu();
                break;
            case "2": teacherMenu();
                break;
            case "3": teacherMenu();
                break;
            case "4": teacherMenu();
                break;
            case "5": teacherMenu();
                break;
            case "6": courseMenu();
                break;
            default: teacherMenu();
                break;
        }

    }

    private static void examMenu() {

        System.out.println(
                "_____Assign exams to courses_____" +
                        "\nType a number to issue a command" +
                        "\n1: wip" +
                        "\n2: wip" +
                        "\n3: wip" +
                        "\n4: wip" +
                        "\n5: wip" +
                        "\n6: Back"
        );

        String answer = in.nextLine();

        switch (answer) {
            case "1": examMenu();
                break;
            case "2": examMenu();
                break;
            case "3": examMenu();
                break;
            case "4": examMenu();
                break;
            case "5": examMenu();
                break;
            case "6": courseMenu();
                break;
            default: examMenu();
                break;
        }

    }


}
