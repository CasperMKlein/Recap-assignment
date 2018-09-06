package Model;

import java.util.ArrayList;

public class Course {

    int ID;
    String name;
    String subject;

    ArrayList<Student> students = new ArrayList();
    ArrayList<Teacher> teachers = new ArrayList();

    public Course(int ID, String name, String subject, ArrayList<Student> students, ArrayList<Teacher> teachers) {
        this.ID = ID;
        this.name = name;
        this.subject = subject;
        this.students = students;
        this.teachers = teachers;
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

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(ArrayList<Teacher> teachers) {
        this.teachers = teachers;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }



}
