package Viewer;

import Controller.ExamController;

import java.util.Scanner;

public class UIExamMenu {

    public static Scanner in = new Scanner(System.in);

    public static void examMenu(ExamController examController) {

        String answer;

        System.out.println(
                "_____Exam menu______" +
                        "\nType a number to issue a command" +
                        "\n1: Add new exam for a single student" +
                        "\n2: Add new exams for a whole course" +
                        "\n3: Delete an exam" +
                        "\n4: Delete exams for a whole course" +
                        "\n5: Print all exams" +
                        "\n5: Print specific exam (extended)" +
                        "\n5: Back"
        );

        answer = in.nextLine();

        switch (answer){
            case "1":
                System.out.println("Type the student's ID.");
                int studentID = in.nextInt();
                System.out.println("Type the course's ID.");
                int courseID = in.nextInt();
                System.out.println("Type the exam description.");
                String description = in.nextLine();
                examController.addExam(studentID,courseID,description,"");
                break;



        }

    }

}
