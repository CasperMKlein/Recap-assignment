package Controller;

import Model.Student;
import Viewer.Viewer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class StudentController {

    public void addStudent(String name){
        int ID = 1;
        if (Viewer.students.size() != 0){
        int highID = Viewer.students.get(Viewer.students.size()-1).getID();
        ID = highID+1;}


        Viewer.students.add(new Student(ID,name));

    }

    public void saveStudentsFile(){
        try {
            PrintWriter outputStream = new PrintWriter(new File("src/Files/StudentsFile"));
            for (int i = 0; i < Viewer.students.size(); i++) {
                outputStream.println(
                        Viewer.students.get(i).getID() + ";" +
                                Viewer.students.get(i).getName() + ";"
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

            Viewer.students.add(new Student(ID,name));
            scanner.nextLine();
        }
    }

    public void deleteStudents(int ID) {

        boolean found = false;

        for (Student student : Viewer.students) {
            if (student.getID() == ID) {
                Viewer.students.remove(student);
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
        for (Student student:Viewer.students) {
            System.out.println("ID: " + student.getID() + " Navn: " + student.getName());
        }
    }
}



