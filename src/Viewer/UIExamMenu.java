

package Viewer;

        import Controller.ExamController;
        import Controller.InputCheck;

public class UIExamMenu {




    public static void examMenu() {

        InputCheck inputCheck = new InputCheck();

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

        answer = inputCheck.inputString();

        switch (answer){
            case "1":

                System.out.println("Type the exam description.");
                String description = inputCheck.inputString();
                System.out.println("Type the student's ID.");
                int studentID = inputCheck.inputIntegerSvar();
                System.out.println("Type the course's ID.");
                int courseID = inputCheck.inputIntegerSvar();
                examController.addExam(studentID,courseID,description,"");
                examMenu();
                break;

            case "2":
                System.out.println("Type the exam description.");
                String description1 = inputCheck.inputString();
                System.out.println("Type the course's ID.");
                int courseID1 = inputCheck.inputIntegerSvar();
                examController.addExamsByCourse(courseID1,description1,"");
                examMenu();
                break;

            case "3":

                System.out.println("Type the exam ID.");
                int examID = inputCheck.inputIntegerSvar();

                examController.deleteExam(examID,"");
                examMenu();
                break;

            case "4":

                System.out.println("Type the course ID for the course who's exams you want deleted.");
                int courseID2 = inputCheck.inputIntegerSvar();

                examController.deleteExamsByCourse(courseID2,"");
                examMenu();
                break;

            case "5":

                examController.printExams("");
                examMenu();
                break;

            case "6":
                System.out.println("Type the exam ID.");
                int examID1 = inputCheck.inputIntegerSvar();
                examController.printExamByID(examID1,"");
                examMenu();
                break;

            case "7":
                UIMainMenu.mainMenu();
                break;

            default: examMenu();
        }

    }

}
