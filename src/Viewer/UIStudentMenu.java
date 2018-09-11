package Viewer;

import Controller.StudentController;

import java.util.Scanner;

public class UIStudentMenu {

    public static Scanner in = new Scanner(System.in);

    public static StudentController studentController = new StudentController();

    public static void studentMenu() {

        System.out.println(
                "_____Student menu_____" +
                        "\nType a number to issue a command" +
                        "\n1: Register a new student" +
                        "\n2: View students" +
                        "\n3: Update student" +
                        "\n4: Delete student" +
                        "\n5: Back"
        );

        String answer = in.nextLine();

        switch (answer) {
            case "1":
                addStudent();
                break;
            case "2":
                readStudent();
                break;
            case "3":
                updateStudent();
                break;
            case "4":
                deleteStudent();
                break;
            case "5":
                UIMainMenu.mainMenu();
                break;
            default:
                studentMenu();
                break;
        }

    }

    private static void addStudent() {

        System.out.println("Please enter the students name");
        String answer = in.nextLine();
        studentController.addStudent(answer);
        System.out.println("Student added!\n");
        studentMenu();
    }

    private static void readStudent() {

        System.out.println("Do you wish to also view the courses each student participates in?\nY/N");

        String answer = in.nextLine();

        if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes")) {
            studentController.printStudents(true);
        } else {
            studentController.printStudents(false);
        }
        System.out.print("\n");
        studentMenu();

    }

    private static void updateStudent() {

        System.out.println("Please enter the ID of the student whose name you wish to update.\nType 'list' to view student list");

        String answer = in.nextLine();

        if (answer.equalsIgnoreCase("list")) {
            studentController.printStudents(false);
            System.out.print("\n");
            updateStudent();
        } else {

            if (answer.matches("[0-9]+")) {

                if (studentController.studentExist(Integer.parseInt(answer)) ) {
                    System.out.println("Please enter the new name.");
                    String newName = in.nextLine();

                    studentController.updateStudent(Integer.parseInt(answer),newName);
                    System.out.println("Student updated!");
                    studentMenu();
                } else {
                    System.out.println("Student not found!");
                    updateStudent();
                }
            } else {
                System.out.println("Please enter numbers only!");
                updateStudent();
            }

        }


    }

    private static void deleteStudent() {

        System.out.println("Please enter the ID of the student you wish to delete.\nType 'list' to view student list OR 'back' to cancel");

        String answer = in.nextLine();

        if (answer.equalsIgnoreCase("list")) {
            studentController.printStudents(false);
            System.out.print("\n");
            deleteStudent();
        } else {
            if (answer.matches("[0-9]+")) {

                if (studentController.studentExist(Integer.parseInt(answer)) ) {
                    studentController.deleteStudent(Integer.parseInt(answer));
                    studentMenu();
                } else {
                    System.out.println("Student not found!");
                    deleteStudent();
                }
            } else {
                studentMenu();
                }
            }

        }



}
