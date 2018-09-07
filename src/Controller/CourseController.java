package Controller;

import Model.Course;
import Model.Student;
import Model.Teacher;
import Viewer.Viewer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class CourseController {
    private List<Course> courseList = new ArrayList<>();

    public void addCourse (String name, String subject) {

        int newID = 1;

        if (Viewer.courses.size() != 0) {
            int highestID = Viewer.courses.get(Viewer.courses.size()-1).getID();
            newID = highestID+1;
        }

        Viewer.courses.add(new Course(newID, name, subject));

    }

    public void readCourse (int courseID) {

        for (int i = 0; i < Viewer.courses.size(); i++) {
            if (courseID == Viewer.courses.get(i).getID()) {

                System.out.println(
                        Viewer.courses.get(i).getID() + " | "
                      + Viewer.courses.get(i).getName() + " | "
                      + Viewer.courses.get(i).getSubject()  );

                break;
            }

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
                    course.addStudent(studentID);
                    foundStudent = true;
                    break;
                }
            }
            if (foundStudent) {
                System.out.println("Student added to course");
            } else {
                System.out.println("Student not found");
            }

        } else {
            System.out.println("Course not found");
        }


    }

    public void readStudents (int courseID) {

        Course course = findCourse(courseID);

        for (int i = 0; i < course.getAllStudents().size(); i++) {

            System.out.println(course.getStudentID(i));

        }

    }





}