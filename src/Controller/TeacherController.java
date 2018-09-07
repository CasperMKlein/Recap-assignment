package Controller;

import Model.Student;
import Model.Teacher;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class TeacherController {
    private List<Teacher> teacherList = new ArrayList<>();

    public void removeTeacher(List list){

    }

    public void addTeacher(List list){

    }

    public void saveTeacher(){

    }

    public void printTeacher(){
        for(int i = 0;i < teacherList.size();i++){
            System.out.println(teacherList.get(i).toString());
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

            teacherList.add(new Teacher(ID,name));
            scanner.nextLine();
        }
    }
}
