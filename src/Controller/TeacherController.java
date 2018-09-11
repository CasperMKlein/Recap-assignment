package Controller;

import Model.Student;
import Model.Teacher;
import Viewer.Viewer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import static Viewer.Viewer.teachers;

public class TeacherController {

    public void deleteTeacher(int ID) {

        boolean found = false;

        for (Teacher teacher : Viewer.teachers) {
            if (teacher.getID() == ID) {
                Viewer.teachers.remove(teacher);
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("Teacher removed\n");
        } else {
            System.out.println("Teacher not found\n");
        }
    }

    public void addTeacher(String name){
        int ID = 1;

        if (Viewer.teachers.size() != 0){
            int highID = Viewer.teachers.get(Viewer.teachers.size()-1).getID();
            ID = highID+1;
        }

        Viewer.teachers.add(new Teacher(ID,name));
    }

    public void saveTeacher() {
        try {
            PrintWriter printWriter = new PrintWriter("src/Files/TeacherFile");
            for (int i = 0; i < teachers.size(); i++) {
                printWriter.print(teachers.get(i).getID() + ";" + teachers.get(i).getName() + ";" + "\n");
            }
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void printTeachers(){
        for(int i = 0;i < teachers.size();i++){
            System.out.println(teachers.get(i).toString());
        }
    }

    public void loadTeacherFile(){
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("src/Files/TeacherFile")).useDelimiter(";").useLocale(Locale.US);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while(scanner.hasNextInt()){
            int ID = scanner.nextInt();
            String name = scanner.next();

            teachers.add(new Teacher(ID,name));
            scanner.nextLine();
        }
    }
}
