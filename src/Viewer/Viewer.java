package Viewer;

import Controller.*;
import Model.*;

import java.util.ArrayList;

public class Viewer {
    public static ArrayList<Student> students = new ArrayList<Student>();
    public static ArrayList<Exam> exams = new ArrayList<Exam>();
    public static ArrayList<Teacher> teachers = new ArrayList<Teacher>();
    public static ArrayList<Subject> subjects = new ArrayList<Subject>();
    public static ArrayList<Course> courses = new ArrayList<Course>();



    StudentController studentController = new StudentController();
    TeacherController teacherController = new TeacherController();
    //CourseController courseController = new CourseController();
    //SubjectController subjectController = new SubjectController();
    ExamController examController = new ExamController();

    public void loadAll (){

        studentController.loadStudentsFile();
        examController.loadExamsFile();

    }

    public void saveAll (){
        studentController.saveStudentsFile();
        examController.saveExamsFile();

    }

    public void menu (){
        loadAll();


        //test();
        //Indsæt menu


        saveAll();
    }

    public void test () {

        //Indsæt tests

    }


}
