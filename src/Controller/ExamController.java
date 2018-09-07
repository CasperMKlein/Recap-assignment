package Controller;

import Model.Exam;
import Model.Student;
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

    public void addExam(int teacherID, int studentID, int CourseID){

        boolean found = false;
        for (Student student:Viewer.students) {
            if (student.getID() == studentID){
                addExamPrivate(teacherID,studentID,CourseID);
                found = true;
                break;
            }

        }

        if (!found) {
            System.out.println("Teacher, Student or Subject couldn't be found.");
        }else{
            System.out.println("Exam added.");
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
