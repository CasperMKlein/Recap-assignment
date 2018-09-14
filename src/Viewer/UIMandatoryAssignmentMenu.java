package Viewer;

import Controller.ExamController;
import Controller.InputCheck;
import Controller.MandatoryAssignmentController;

import java.util.Scanner;

public class UIMandatoryAssignmentMenu {

    public static void ManAssMenu() {

        InputCheck inputCheck = new InputCheck();

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

        answer = inputCheck.inputString();

        switch (answer){
            case "1":

                System.out.println("Type the mandatory assignment description.");
                String description = inputCheck.inputString();
                System.out.println("Type the student's ID.");
                int studentID = inputCheck.inputIntegerSvar();
                System.out.println("Type the course's ID.");
                int courseID = inputCheck.inputIntegerSvar();
                mandatoryAssignmentController.addManAss(studentID,courseID,description);
                ManAssMenu();
                break;

            case "2":
                System.out.println("Type the mandatory assignment description.");
                String description1 = inputCheck.inputString();
                System.out.println("Type the course's ID.");
                int courseID1 = inputCheck.inputIntegerSvar();
                mandatoryAssignmentController.addManAssByCourse(courseID1,description1);
                ManAssMenu();
                break;

            case "3":

                System.out.println("Type the mandatory assignment ID.");
                int ManAssID = inputCheck.inputIntegerSvar();

                mandatoryAssignmentController.deleteManAss(ManAssID);
                ManAssMenu();
                break;

            case "4":

                System.out.println("Type the course ID for the course who's mandatory assignments you want deleted.");
                int courseID2 = inputCheck.inputIntegerSvar();

                mandatoryAssignmentController.deleteManAssByCourse(courseID2);
                ManAssMenu();
                break;

            case "5":

                mandatoryAssignmentController.printManAss();
                ManAssMenu();
                break;

            case "6":
                System.out.println("Type the mandatory assignment ID.");
                int ManAssID1 = inputCheck.inputIntegerSvar();
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
