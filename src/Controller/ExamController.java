package Controller;

import Model.Exam;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class ExamController {

    private ArrayList<Exam> exams = new ArrayList<>();

    public void addExam(int teacherID, int studentID, int subjectID){
        int examID = 1;
        if (exams.size() != 0){
            int highExamID = exams.get(exams.size()-1).getExamID();
            examID = highExamID+1;}

        exams.add(new Exam(examID,teacherID,studentID,subjectID));;

    }

    public void saveExamsFile(){
        try {
            PrintWriter outputStream = new PrintWriter(new File("src/Files/ExamFile"));
            for (int i = 0; i < exams.size(); i++) {
                outputStream.println(
                        exams.get(i).getExamID() + ";" +
                                exams.get(i).getTeacherID() + ";" +
                                exams.get(i).getStudentID() + ";" +
                                exams.get(i).getSubjectID() + ";"
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
            int subjectID = scanner.nextInt();

            exams.add(new Exam(examID,teacherID,studentID,subjectID));
            scanner.nextLine();
        }
    }

    public void deleteexams(int examID) {

        boolean found = false;

        for (Exam exam : exams) {
            if (exam.getExamID() == examID) {
                exams.remove(exam);
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("Exam deleted!");
        } else {
            System.out.println("Exam not found!");
        }
    }

    public void printExams(){

        for (Exam exam:exams
                ) {

            System.out.println("examID: " + exam.getExamID() + " Lære ID: " + exam.getTeacherID() +
                    " Student ID: " + exam.getStudentID() + " Kursus ID: " + exam.getSubjectID());

        }

    }

}
