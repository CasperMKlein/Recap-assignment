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
    List<Teacher> teacherList = new ArrayList<>();
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
