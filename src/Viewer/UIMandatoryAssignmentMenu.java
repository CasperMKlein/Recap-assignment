package Viewer;

import Controller.ExamController;
import Controller.MandatoryAssignmentController;

import java.util.Scanner;

public class UIMandatoryAssignmentMenu {

    private static Scanner in = new Scanner(System.in);



    public static void ManAssMenu() {

        MandatoryAssignmentController mandatoryAssignmentController = new MandatoryAssignmentController();

        String answer;

        System.out.println(
                "_____Mandatory assignment menu______" +
                        "\nType a number to issue a command" +
                        "\n1: Add new mandatory assignment for a single student" +
                        "\n2: Add new mandatory assignment for a whole course" +
                        "\n3: Delete an mandatory assignment" +
                        "\n4: Delete mandatory assignment for a whole course" +
                        "\n5: Print all mandatory assignment" +
                        "\n6: Print specific mandatory assignment (extended)" +
                        "\n7: Back"
        );

        answer = in.nextLine();

        switch (answer){
            case "1":

                System.out.println("Type the mandatory assignment description.");
                String description = in.nextLine().toString();
                System.out.println("Type the student's ID.");
                int studentID = in.nextInt();
                System.out.println("Type the course's ID.");
                int courseID = in.nextInt();
                mandatoryAssignmentController.addManAss(studentID,courseID,description);
                ManAssMenu();
                break;

            case "2":
                System.out.println("Type the mandatory assignment description.");
                String description1 = in.nextLine().toString();
                System.out.println("Type the course's ID.");
                int courseID1 = in.nextInt();
                mandatoryAssignmentController.addManAssByCourse(courseID1,description1);
                ManAssMenu();
                break;

            case "3":

                System.out.println("Type the mandatory assignment ID.");
                int ManAssID = in.nextInt();

                mandatoryAssignmentController.deleteManAss(ManAssID);
                ManAssMenu();
                break;

            case "4":

                System.out.println("Type the course ID for the course who's mandatory assignments you want deleted.");
                int courseID2 = in.nextInt();

                mandatoryAssignmentController.deleteManAssByCourse(courseID2);
                ManAssMenu();
                break;

            case "5":

                mandatoryAssignmentController.printManAss();
                ManAssMenu();
                break;

            case "6":
                System.out.println("Type the mandatory assignment ID.");
                int ManAssID1 = in.nextInt();
                mandatoryAssignmentController.printManAssByID(ManAssID1);
                ManAssMenu();
                break;

            case "7":
                UIMainMenu.mainMenu();
                break;

            default: ManAssMenu();
        }

    }

}
