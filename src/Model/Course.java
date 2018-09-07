package Model;

import java.util.ArrayList;
import java.util.List;

public class Course {

    private int ID;
    private String name;
    private String subject;

    private List<Integer> students = new ArrayList();
    private List<Integer> teachers = new ArrayList();



    public Course(int ID, String name, String subject/*, ArrayList<Student> students, ArrayList<Teacher> teachers*/) {
        this.ID = ID;
        this.name = name;
        this.subject = subject;
        //this.students = students;
        //this.teachers = teachers;
    }

    // getters and setters

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public List<Integer> getAllTeachers() {
        return teachers;
    }

    public void setAllTeachers(ArrayList<Integer> teachers) {
        this.teachers = teachers;
    }

    public List<Integer> getAllStudents() {
        return students;
    }

    public void setAllStudents(ArrayList<Integer> students) {
        this.students = students;
    }

    public Integer getStudentID(int arrayID) {
        return this.students.get(arrayID);
    }

    public void addStudent(int studentID) {

        boolean found = false;

        for (int i = 0; i < this.students.size(); i++) {
            if (getStudentID(i) == studentID) {
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("This student is already participating in this course!");
        } else {
            this.students.add(studentID);
        }
    }

    public void deleteStudent(int studentID) {

        for (int i = 0; i < this.students.size(); i++) {
            if (getStudentID(i) == studentID) {
                this.students.remove(i);
                break;
            }
        }
    }





}
