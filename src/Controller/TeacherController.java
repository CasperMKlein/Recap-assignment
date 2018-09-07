package Controller;

import Model.Student;
import Model.Teacher;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import static Viewer.Viewer.teachers;

public class TeacherController {

    public void removeTeacher(List list){

    }

    public void addTeacher(List list){

    }

    public void saveTeacher() throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter("src/Files/TeacherFile");
        for (int i = 0; i < teachers.size();i++){
            printWriter.print(teachers.get(i).getID()+";"+teachers.get(i).getName()+";"+"\n");
            printTeachers();
        }
        printWriter.close();
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
