package Controller;

import Model.Course;
import Model.Student;
import Model.Teacher;
import Viewer.Viewer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class StudentController {

    public static CourseController courseController = new CourseController();

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

    public void deleteStudent(int studentID) {

        boolean found = false;

        for (Teacher teacher:Viewer.teachers) {

        }
        for (Student student : Viewer.students) {
            if (student.getID() == studentID) {
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

    public void printStudents(boolean viewCourses){
        for (Student student:Viewer.students) {

            System.out.println("ID: " + student.getID() + " Name: " + student.getName());

            if (viewCourses) {

                for (int i = 0; i < Viewer.courses.size(); i++) {

                    for (int j = 0; j < Viewer.courses.get(i).getAllStudents().size(); j++) {

                        if (Viewer.courses.get(i).getAllStudents().get(j) == student.getID()) {

                            courseController.readCourse(Viewer.courses.get(i).getID(),false);
                        }
                    }
                }
                System.out.println("___________________________________________");
            }
        }
    }

    public void updateStudent(int studentID, String newName) {

        int array = 0;

        for (Student student:Viewer.students) {

            if (student.getID() == studentID) {
                Viewer.students.get(array).setName(newName);
                break;
            }
            array++;
        }
    }

    public boolean studentExist(int studentID) {

        boolean success = false;

        for (Student student:Viewer.students) {
            if (student.getID() == studentID) {
                success = true;
                break;
            }
        }
        return success;
    }

}