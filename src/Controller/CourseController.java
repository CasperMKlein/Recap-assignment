package Controller;

import Model.Course;
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

public class CourseController {
    private List<Course> courseList = new ArrayList<>();

    public void saveCourseFile(){
        try {
            PrintWriter outputStream = new PrintWriter(new File("src/Files/CourseFile"));
            for (int i = 0; i < Viewer.courses.size(); i++) {
                outputStream.print(
                        Viewer.courses.get(i).getID() + ";" +
                                Viewer.courses.get(i).getName() + ";" +
                                Viewer.courses.get(i).getSubject() + ";"
                );

                for (int j = 0; j < Viewer.courses.get(i).getAllStudents().size(); j++) {

                    outputStream.print(
                            Viewer.courses.get(i).getStudentID(j) + ";"
                    );

                }
                outputStream.print(".;");

                for (int j = 0; j < Viewer.courses.get(i).getAllTeachers().size(); j++) {

                    outputStream.print(
                            Viewer.courses.get(i).getTeacherID(j) + ";"
                    );

                }
                outputStream.print("\n");

            }
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void loadCourseFile(){
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("src/Files/CourseFile")).useDelimiter(";").useLocale(Locale.US);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int current = 0; //counts the spot in the course arraylist
        while(scanner.hasNextInt()){
            int ID = scanner.nextInt();
            String name = scanner.next();
            String subject = scanner.next();

            Viewer.courses.add(new Course(ID,name,subject));

            while(scanner.hasNextInt()) {
                int studentID = scanner.nextInt();

                Viewer.courses.get(current).addStudent(studentID);
            }
            scanner.next();

            while(scanner.hasNextInt()) {
                int teacherID = scanner.nextInt();

                Viewer.courses.get(current).addTeacher(teacherID);
            }

            scanner.nextLine();
            current++;
        }
    }

    public void addCourse (String name, String subject) {

        int newID = 1;

        if (Viewer.courses.size() != 0) {
            int highestID = Viewer.courses.get(Viewer.courses.size()-1).getID();
            newID = highestID+1;
        }

        Viewer.courses.add(new Course(newID, name, subject));

    }

    public void readCourse (int courseID, boolean displayMembers) {

        Course course = findCourse(courseID);

        System.out.println("Course ID: " + course.getID()
                + "\t| Name: " + course.getName()
                + "\t| Subject: " + course.getSubject() );

        if (displayMembers) {
            readTeachers(courseID);
            readStudents(courseID);
        }

    }

    public void readAllCourses () {

        //læser kun navn op indtil videre

        for (int i = 0; i < Viewer.courses.size(); i++) {

            System.out.println(
                    Viewer.courses.get(i).getID() + " | "
                  + Viewer.courses.get(i).getName() + " | "
                  + Viewer.courses.get(i).getSubject()  );

        }
    }

    public void deleteCourse (int courseID) {

        boolean found = false;

        for (Course course : Viewer.courses) {
            if (courseID == course.getID()) {
                Viewer.courses.remove(course);
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Course deleted!");
        } else {
            System.out.println("Course not found!");
        }

    }

    public Course findCourse (int courseID) {

        for (int i = 0; i < Viewer.courses.size(); i++) {
            if (courseID == Viewer.courses.get(i).getID()) {
                return Viewer.courses.get(i);
            }
        }

        return null;
    }

    public void addStudent (int courseID, int studentID) {

        boolean foundCourse = false;
        boolean foundStudent = false;
        boolean alreadyParticipating = false; //makes sure we don't type out the wrong message
        Course course = null;

        //find the course
        for (int i = 0; i < Viewer.courses.size(); i++) {
            if (courseID == Viewer.courses.get(i).getID()) {
                course = Viewer.courses.get(i);
                foundCourse = true;
                break;
            }
        }
        //find the student
        if (foundCourse) {
            for (int i = 0; i < Viewer.students.size(); i++) {
                if (studentID == Viewer.students.get(i).getID()) {
                    alreadyParticipating = course.addStudent(studentID);
                    foundStudent = true;
                    break;
                }
            }

            if (!alreadyParticipating) {
                if (foundStudent) {
                    System.out.println("Student added to course");
                } else {
                    System.out.println("Student not found");
                }
            }

        } else {
            System.out.println("Course not found");
        }


    }

    public void readStudents (int courseID) {

        Course course = findCourse(courseID);

        System.out.println("- - Students - -");
        for (int i = 0; i < course.getAllStudents().size(); i++) {


            for (int j = 0; j < Viewer.students.size(); j++) {
                if (Viewer.students.get(j).getID() == course.getStudentID(i)) {
                    System.out.println("ID: " + Viewer.students.get(j).getID() +
                        "\t| Name: " + Viewer.students.get(j).getName());
                }
            }

        }

    }

    public void addTeacher (int courseID, int teacherID) {

        boolean foundCourse = false;
        boolean foundTeacher = false;
        boolean alreadyParticipating = false; //makes sure we don't type out the wrong message
        Course course = null;

        //find the course
        for (int i = 0; i < Viewer.courses.size(); i++) {
            if (courseID == Viewer.courses.get(i).getID()) {
                course = Viewer.courses.get(i);
                foundCourse = true;
                break;
            }
        }
        //find the teacher
        if (foundCourse) {
            for (int i = 0; i < Viewer.teachers.size(); i++) {
                if (teacherID == Viewer.teachers.get(i).getID()) {
                    alreadyParticipating = course.addTeacher(teacherID);
                    foundTeacher = true;
                    break;
                }
            }

            if (!alreadyParticipating) {
                if (foundTeacher) {
                    System.out.println("Teacher added to course");
                } else {
                    System.out.println("Teacher not found");
                }
            }

        } else {
            System.out.println("Course not found");
        }


    }

    public void readTeachers (int courseID) {

        Course course = findCourse(courseID);

        System.out.println("- - Teachers - -");
        for (int i = 0; i < course.getAllTeachers().size(); i++) {

            for (int j = 0; j < Viewer.teachers.size(); j++) {
                if (Viewer.teachers.get(j).getID() == course.getTeacherID(i)) {
                    System.out.println("ID: " + Viewer.teachers.get(j).getID() +
                            "\t| Name: " + Viewer.teachers.get(j).getName());
                }
            }
        }

    }


}