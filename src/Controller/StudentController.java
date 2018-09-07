package Controller;

import Model.Student;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class StudentController {
    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(String name){
        int ID = 1;
        if (students.size() != 0){
        int highID = students.get(students.size()-1).getID();
        ID = highID+1;}

        students.add(new Student(ID,name));

    }

    public void saveStudentsFile(){
        try {
            PrintWriter outputStream = new PrintWriter(new File("src/Files/StudentsFile"));
            for (int i = 0; i < students.size(); i++) {
                outputStream.println(
                        students.get(i).getID() + ";" +
                                students.get(i).getName() + ";"
                );
            }
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void loadStudentsFile(){
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("src/Files/StudentsFile")).useDelimiter(";").useLocale(Locale.US);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while(scanner.hasNextInt()){
            int ID = scanner.nextInt();
            String name = scanner.next();

            students.add(new Student(ID,name));
            scanner.nextLine();
        }
    }

    public void deleteStudents(int ID) {

        boolean found = false;

        for (Student student : students) {
            if (student.getID() == ID) {
                students.remove(student);
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("Student deleted!");
        } else {
            System.out.println("Student not found!");
        }
    }

    public void printStudents(){
        for (Student student:students) {
            System.out.println("ID: " + student.getID() + " Navn: " + student.getName());
        }
    }
}



