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

    public void saveSubjects() {
        try {
            PrintWriter fileWriter = new PrintWriter("src/Files/SubjectFile");
            for (int i = 0; i < subjects.size(); i++) {
                fileWriter.print(subjects.get(i).getName() + ";" + "\n");
            }
            fileWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void printSubjects(){
        for(int i = 0;i < subjects.size();i++){
            System.out.println(subjects.get(i).toString());
        }
    }

    public void loadSubjectFile(){
        try {
            Scanner fileScanner = new Scanner(new File("src/Files/SubjectFile")).useDelimiter(";").useLocale(Locale.US);
            while(fileScanner.hasNext()){
                String name = fileScanner.next();
                subjects.add(new Subject(name));
                fileScanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}