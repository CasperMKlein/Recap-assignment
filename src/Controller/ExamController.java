package Controller;

import Model.Course;
import Model.Exam;
import Model.Student;
import Model.Teacher;
import Viewer.Viewer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class ExamController {

    private void addExamPrivate(int teacherID, int studentID, int CourseID){
        int examID = 1;
        if (Viewer.exams.size() != 0){
            int highExamID = Viewer.exams.get(Viewer.exams.size()-1).getExamID();
            examID = highExamID+1;}

        Viewer.exams.add(new Exam(examID,teacherID,studentID,CourseID));

    }

    public void addExam(int teacherID, int studentID, int courseID){

        int found = 0;


        for (Course course:Viewer.courses
             ) {
            if (course.getID() == courseID){
                found++;
            for (Teacher teacher : Viewer.teachers
                    ) {

                if (teacher.getID() == teacherID){

                    found++;

                    for (Student student : Viewer.students) {

                        if (student.getID() == studentID) {
                            addExamPrivate(teacherID, studentID, courseID);
                            found++;
                            break;
                        }
                    }

                    break;
                }
            }
            break;
            }
        }

        switch (found) {
            case 0:
                System.out.println("Course couldn't be found.");
                break;

            case 1:
                System.out.println("Teacher couldn't be found.");
                break;

            case 2:
                System.out.println("Student couldn't be found.");
                break;

            case 3:
                System.out.println("Exam added.");
                break;
        }

    }

    public void addExamsByCourse(int teacherID,int courseID) {


        int found = 0;


        for (Course course : Viewer.courses) {

            if (course.getID() == courseID) {
                found++;
                for (Teacher teacher : Viewer.teachers) {

                    if (teacher.getID() == teacherID) {

                        found++;

                        for (Integer student : Viewer.courses.get(courseID-1).getAllStudents()

                                ) {

                            addExamPrivate(teacherID, student, courseID);

                        }
                        break;
                    }
                }
                break;
            }
        }

        switch (found) {
            case 0:
                System.out.println("Course couldn't be found.");
                break;

            case 1:
                System.out.println("Teacher couldn't be found.");
                break;

            case 2:
                System.out.println("Exam added.");
                break;
        }
    }

    public void saveExamsFile(){
        try {
            PrintWriter outputStream = new PrintWriter(new File("src/Files/ExamFile"));
            for (int i = 0; i < Viewer.exams.size(); i++) {
                outputStream.println(
                        Viewer.exams.get(i).getExamID() + ";" +
                                Viewer.exams.get(i).getTeacherID() + ";" +
                                Viewer.exams.get(i).getStudentID() + ";" +
                                Viewer.exams.get(i).getCourseID() + ";"
                );
            }
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void loadExamsFile(){
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("src/Files/ExamFile")).useDelimiter(";").useLocale(Locale.US);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while(scanner.hasNextInt()){
            int examID = scanner.nextInt();
            int teacherID = scanner.nextInt();
            int studentID = scanner.nextInt();
            int CourseID = scanner.nextInt();

            Viewer.exams.add(new Exam(examID,teacherID,studentID,CourseID));
            scanner.nextLine();
        }
    }

    public void printExams(){

        for (Exam exam:Viewer.exams
                ) {

            System.out.println("examID: " + exam.getExamID() + " Lære ID: " + exam.getTeacherID() +
                    " Student ID: " + exam.getStudentID() + " Kursus ID: " + exam.getCourseID());

        }

    }

    private boolean deleteExamPrivate(int examID) {

        boolean found = false;

        for (Exam exam : Viewer.exams) {
            if (exam.getExamID() == examID) {
                Viewer.exams.remove(exam);
                found = true;
                break;

            }
        }
        return found;
    }

    public void deleteExam (int examID){

        boolean found = false;

        found = deleteExamPrivate(examID);

        if (found) {
            System.out.println("Exam deleted!");
        } else {
            System.out.println("Exam not found!");
        }


    }

    public void deleteExamsByCourse (int courseID) {

        int counter = 0;

        for (int i = 0; i < Viewer.exams.size(); i++) {
            {

            if (Viewer.exams.get(i).getCourseID() == courseID) {
                deleteExamPrivate(Viewer.exams.get(i).getExamID());
                counter++;
                i--;
            }

        }}

        System.out.println(counter + " exams deleted.");

    }

}