
package Viewer;

        import Controller.ExamController;

        import java.util.Scanner;

public class UIExamMenu {

    private static Scanner in = new Scanner(System.in);


    public static void examMenu() {

        ExamController examController = new ExamController();

        String answer;

        System.out.println(
                "_____Exam menu______" +
                        "\nType a number to issue a command" +
                        "\n1: Add new exam for a single student" +
                        "\n2: Add new exams for a whole course" +
                        "\n3: Delete an exam" +
                        "\n4: Delete exams for a whole course" +
                        "\n5: Print all exams" +
                        "\n6: Print specific exam (extended)" +
                        "\n7: Back"
        );

        answer = in.nextLine();

        switch (answer){
            case "1":

                System.out.println("Type the exam description.");
                String description = in.nextLine().toString();
                System.out.println("Type the student's ID.");
                int studentID = in.nextInt();
                System.out.println("Type the course's ID.");
                int courseID = in.nextInt();
                examController.addExam(studentID,courseID,description,"");
                break;

            case "2":
                System.out.println("Type the exam description.");
                String description1 = in.nextLine().toString();
                System.out.println("Type the course's ID.");
                int courseID1 = in.nextInt();
                examController.addExamsByCourse(courseID1,description1,"");
                break;

            case "3":

                System.out.println("Type the exam ID.");
                int examID = in.nextInt();

                examController.deleteExam(examID,"");
                break;

            case "4":

                System.out.println("Type the course ID for the course who's exams you want deleted.");
                int courseID2 = in.nextInt();

                examController.deleteExamsByCourse(courseID2,"");
                break;

            case "5":

                examController.printExams("");
                break;

            case "6":
                System.out.println("Type the exam ID.");
                int examID1 = in.nextInt();
                examController.printExamByID(examID1,"");
                break;

            case "7":
                UIMainMenu.mainMenu();
                break;

            default: examMenu();
        }

    }

}
