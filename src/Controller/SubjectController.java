package Controller;

import Model.Subject;
import Viewer.Viewer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;
import static Viewer.Viewer.subjects;

public class SubjectController {

    public void deleteSubject(String subject_name) {

        boolean found = false;

        for (Subject subject : Viewer.subjects) {
            if (subject_name.equalsIgnoreCase(subject.getName())) {
                Viewer.subjects.remove(subject);
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("Subject removed");
        } else {
            System.out.println("Subject not found");
        }
    }

    public void addSubject(String name){
        Viewer.subjects.add(new Subject(name));
    }

    public void saveSubjects() throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter("src/Files/SubjectFile");
        for (int i = 0; i < subjects.size();i++){
            printWriter.print(subjects.get(i).getName()+";"+"\n");
        }
        printWriter.close();
    }

    public void printSubjects(){
        for(int i = 0;i < subjects.size();i++){
            System.out.println(subjects.get(i).toString());
        }
    }

    public void loadSubjectFile(){
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("src/Files/SubjectFile")).useDelimiter(";").useLocale(Locale.US);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while(scanner.hasNext()){
            String name = scanner.next();

            subjects.add(new Subject(name));
            scanner.nextLine();
        }
    }
}