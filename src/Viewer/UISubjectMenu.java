package Viewer;

import Controller.SubjectController;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UISubjectMenu {
    public static void uiSubjectMenu() throws FileNotFoundException {
        SubjectController subjectController = new SubjectController();
        Scanner in = new Scanner(System.in);
        System.out.print("Subject Menu\n"
                +"1: Print out all subjects\n"
                +"2: Add new subject\n"
                +"3: Remove subject\n"
                +"4: Back\n");
        String answer = in.nextLine();

        switch(answer){
            case "1":
                System.out.print("Overview of subjects:\n\n");
                subjectController.printSubjects();
                System.out.print("\n");
                uiSubjectMenu();
                break;
            case "2":
                System.out.print("Write new subject\n");
                answer = in.nextLine();
                subjectController.addSubject(answer);
                subjectController.saveSubjects();
                System.out.println("Subject added\n");
                uiSubjectMenu();
                break;
            case "3":
                System.out.print("Write name of subject to remove it:\n");
                answer = in.nextLine();
                subjectController.deleteSubject(answer);
                subjectController.saveSubjects();
                uiSubjectMenu();
                break;
            case "4":
                UIMainMenu.mainMenu();
                break;
            default: uiSubjectMenu();
                break;
        }
    }
}
