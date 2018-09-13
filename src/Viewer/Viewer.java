package Viewer;

import Controller.*;
import Model.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Viewer {
    public static ArrayList<Student> students = new ArrayList<Student>();
    public static ArrayList<Exam> exams = new ArrayList<Exam>();
    public static ArrayList<Teacher> teachers = new ArrayList<Teacher>();
    public static ArrayList<Subject> subjects = new ArrayList<Subject>();
    public static ArrayList<Course> courses = new ArrayList<Course>();
    public static ArrayList<Exam> mandatoryAssignments = new ArrayList<Exam>();



    StudentController studentController = new StudentController();
    TeacherController teacherController = new TeacherController();
    CourseController courseController = new CourseController();
    SubjectController subjectController = new SubjectController();
    ExamController examController = new ExamController();
    MandatoryAssignmentController mandatoryAssignmentController = new MandatoryAssignmentController();

    public void loadAll (){

        studentController.loadStudentsFile();
        examController.loadExamsFile("ExamFile","");
        teacherController.loadTeacherFile();
        courseController.loadCourseFile();
        subjectController.loadSubjectFile();
        mandatoryAssignmentController.loadManAssFile("MandatoryAssignmentFile");

    }

    public void saveAll () throws FileNotFoundException {
        studentController.saveStudentsFile();
        examController.saveExamsFile("ExamFile","");
        teacherController.saveTeacher();
        courseController.saveCourseFile();
        subjectController.saveSubjects();
        mandatoryAssignmentController.saveManAssFile("MandatoryAssignmentFile");

    }

    public void menu () throws FileNotFoundException {
        loadAll();


        UIMainMenu.mainMenu();


        saveAll();
    }

    public void test () {

    }


}
