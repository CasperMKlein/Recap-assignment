package Viewer;

import Controller.TeacherController;
import Model.Teacher;

import java.util.Scanner;

public class UITeacherMenu{

    public static Scanner in = new Scanner(System.in);
    public static TeacherController teacherController = new TeacherController();

    public static void teacherMenu() {

        System.out.println(
                "_____Teacher Menu______" +
                        "\nType a number to issue a command" +
                        "\n1: Register a new teacher" +
                        "\n2: View teachers" +
                        "\n3: Update teacher" +
                        "\n4: Delete teacher" +
                        "\n5: Back"
        );

        String answer = in.nextLine();

        switch(answer){
            case "1": addTeacher();
                break;
            case "2": readTeacher();
                break;
            case "3": updateTeacher();
                break;
            case "4": deleteTeacher();
                break;
            case "5": UIMainMenu.mainMenu();
                break;
            default: teacherMenu();
                break;
        }
    }

    private static void addTeacher() {

        System.out.println("Please enter the teacher name");
        String answer = in.nextLine();
        teacherController.addTeacher(answer);
        System.out.println("Teacher added!\n");
        teacherMenu();
    }

    private static void readTeacher() {

        System.out.println("Do you wish to also view the courses each student participates in?\nY/N");

        String answer = in.nextLine();

        if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes")) {
            teacherController.printTeachers(true);
        } else {
            teacherController.printTeachers(false);
        }
        System.out.print("\n");
        teacherMenu();

    }

    private static void updateTeacher() {

        System.out.println("Please enter the ID of the teacher whose name you wish to update.\nType 'list' to view teacher list");

        String answer = in.nextLine();

        if (answer.equalsIgnoreCase("list")) {
            teacherController.printTeachers(false);
            System.out.print("\n");
            updateTeacher();
        } else {

            if (answer.matches("[0-9]+")) {

                if (teacherController.teacherExist(Integer.parseInt(answer)) ) {
                    System.out.println("Please enter the new name.");
                    String newName = in.nextLine();

                    teacherController.updateTeacher(Integer.parseInt(answer),newName);
                    System.out.println("Teacher updated!");
                    teacherMenu();
                } else {
                    System.out.println("Teacher not found!");
                    updateTeacher();
                }
            } else {
                System.out.println("Please enter numbers only!");
                updateTeacher();
            }
        }
    }

    private static void deleteTeacher() {

        System.out.println("Please enter the ID of the teacher you wish to delete.\nType 'list' to view teacher list OR 'back' to cancel");

        String answer = in.nextLine();

        if (answer.equalsIgnoreCase("list")) {
            teacherController.printTeachers(false);
            System.out.print("\n");
            deleteTeacher();
        } else {
            if (answer.matches("[0-9]+")) {

                if (teacherController.teacherExist(Integer.parseInt(answer)) ) {
                    teacherController.deleteTeacher(Integer.parseInt(answer));
                    teacherMenu();
                } else {
                    System.out.println("teacher not found!");
                    deleteTeacher();
                }
            } else {
                teacherMenu();
            }
        }

    }

}