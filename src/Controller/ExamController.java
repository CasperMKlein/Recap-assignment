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
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ExamController{

    public ArrayList<Exam> chooseList (String choice){

        if (choice == ""){
            return Viewer.exams;
        } else if (choice == "ManAss"){
            return Viewer.mandatoryAssignments;
        }

        return null;
    }

    private void addExamPrivate(int studentID, int CourseID,String description,String selection){
        int examID = 1;
        if (chooseList(selection).size() != 0){
            int highExamID = chooseList(selection).get(chooseList(selection).size()-1).getExamID();
            examID = highExamID+1;}

        chooseList(selection).add(new Exam(examID,studentID,CourseID,description));

    }

    public void addExam(int studentID, int courseID,String description,String selection){

        int found = 0;


        for (Course course:Viewer.courses
                ) {
            if (course.getID() == courseID){
                found++;

                    for (Student student : Viewer.students) {

                        if (student.getID() == studentID) {
                            addExamPrivate(studentID, courseID,description,selection);
                            found++;
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
                System.out.println("Student couldn't be found.");
                break;

            case 2:
                if(selection=="ManAss"){
                    System.out.println("Mandatory Assignment added.");
                }else{
                System.out.println("Exam added.");}
                break;
        }

    }

    public void addExamsByCourse(int courseID,String description,String selection) {


        int found = 0;


        for (Course course : Viewer.courses) {

            if (course.getID() == courseID) {
                found++;

                        for (Integer student : Viewer.courses.get(courseID-1).getAllStudents()

                                ) {

                            addExamPrivate(student, courseID, description,selection);

                        }
                break;
                }

        }

        switch (found) {
            case 0:
                System.out.println("Course couldn't be found.");
                break;
            case 1:
                if(selection=="ManAss"){
                    System.out.println("Mandatory assignments added.");
                }
                System.out.println("Exams added.");
                break;
        }
    }

    public void saveExamsFile(String fileName,String selection){
        try {
            PrintWriter outputStream = new PrintWriter(new File("src/Files/"+fileName));
            for (int i = 0; i < chooseList(selection).size(); i++) {
                outputStream.println(
                        chooseList(selection).get(i).getExamID() + ";" +
                                chooseList(selection).get(i).getStudentID() + ";" +
                                chooseList(selection).get(i).getCourseID() + ";"+
                                chooseList(selection).get(i).getDescription() + ";"
                );
            }
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void loadExamsFile(String fileName,String selection){
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("src/Files/"+fileName)).useDelimiter(";").useLocale(Locale.US);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while(scanner.hasNextInt()){
            int examID = scanner.nextInt();
            int studentID = scanner.nextInt();
            int courseID = scanner.nextInt();
            String description = scanner.next();

            chooseList(selection).add(new Exam(examID,studentID,courseID,description));
            scanner.nextLine();
        }
    }

    public void printExams(String selection){
        List<Integer> integers = new ArrayList<>();

        for (Exam exam:chooseList(selection)
                ) {

            for (Course course: Viewer.courses
                 ) {

                if(course.getID()==exam.getCourseID()){
                    integers = course.getAllTeachers();
                }

            }

            if(selection=="ManAss"){
                System.out.println("Mandatory Assignment ID: " + exam.getExamID() + " Teacher ID(s): " + integers +
                        " Student ID: " + exam.getStudentID() + " Course ID: " + exam.getCourseID());
            }else {
                System.out.println("Exam ID: " + exam.getExamID() + " Teacher ID(s): " + integers +
                        " Student ID: " + exam.getStudentID() + " Course ID: " + exam.getCourseID());
            }

        }

    }

    public void printExamByID (int ID,String selection) {

        Exam exam = new Exam(0,0,0,"");
        Teacher teacher = new Teacher(0,"");
        Student student = new Student(0,"");
        Course course = new Course(0,"","");
        String teacherNames = "";
        Boolean found = false;

        for (Exam exam1: chooseList(selection)
             ) {
            if (exam1.getExamID() == ID) {

                found = true;
                exam = exam1;
                break;

            }
        }

        for (Student student1: Viewer.students
                ) {
            if (student1.getID() == exam.getStudentID()) {

                student = student1;
                break;

            }
        }

        for (Course course1: Viewer.courses
                ) {
            if (course1.getID() == exam.getCourseID()) {

                course = course1;
                break;

            }
        }

        for (int teacherID: course.getAllTeachers()
             ) {
        for (Teacher teacher1: Viewer.teachers
                ) {
            if (teacher1.getID() == teacherID) {

                teacherNames = teacherNames+teacher1.getName()+"/";

            }
        }
        }

        if (teacherNames != null && teacherNames.length() > 0) {
            teacherNames = teacherNames.substring(0, teacherNames.length() - 1);}



        if (!found) {

            if(selection=="ManAss"){
                System.out.println("Couldn't find Mandatory Assignment with ID: " + ID);
            }else{
            System.out.println("Couldn't find exam with ID: " + ID);}

        } else {

            if(selection=="ManAss"){
                System.out.println("Mandatory assignment info for exam ID: " + ID); }
                else{
            System.out.println("Exam info for exam ID: " + ID); }

            System.out.println("---------------------------");
            System.out.println("Student: " + student.getName());
            System.out.println("Teacher(s): " + teacherNames);
            System.out.println("Course: " + course.getName());
            System.out.println("Subject: " + course.getSubject());
            System.out.println("---------------------------");
            System.out.println("Description: " + exam.getDescription());
        }

    }

    private boolean deleteExamPrivate(int examID,String selection) {

        boolean found = false;

        for (Exam exam : chooseList(selection)) {
            if (exam.getExamID() == examID) {
                chooseList(selection).remove(exam);
                found = true;
                break;

            }
        }
        return found;
    }

    public void deleteExam (int examID,String selection){

        boolean found = false;

        found = deleteExamPrivate(examID,selection);

        if (selection=="ManAss"){
        if (found) {
            System.out.println("Mandatory assignment deleted!");
        } else {
            System.out.println("Mandatory assignment not found!");
        }}else{
            if (found) {
                System.out.println("Exam deleted!");
            } else {
                System.out.println("Exam not found!");
            }
        }


    }

    public void deleteExamsByCourse (int courseID,String selection) {

        int counter = 0;

        for (int i = 0; i < chooseList(selection).size(); i++) {
            {

            if (chooseList(selection).get(i).getCourseID() == courseID) {
                deleteExamPrivate(chooseList(selection).get(i).getExamID(),selection);
                counter++;
                i--;
            }

            }}

        if(selection=="ManAss"){
        System.out.println(counter + " mandatory assignments deleted.");
        }else{
            System.out.println(counter + " exams deleted.");
        }

    }

}