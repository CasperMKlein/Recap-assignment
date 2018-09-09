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

    public Integer getTeacherID(int arrayID) {
        return this.teachers.get(arrayID);
    }

    public boolean addTeacher(int teacherID) {

        //the returned value determines whether the teacher is already participating in the course or not

        boolean found = false;

        for (int i = 0; i < this.teachers.size(); i++) {
            if (getTeacherID(i) == teacherID) {
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("This teacher is already teaching in this course!");
            return true;
        } else {
            this.teachers.add(teacherID);
            return false;
        }
    }

    //mainly here to fulfill crud requirements
    public void updateTeacher(int teacherID, int newTeacherID) {

        for (int i = 0; i < this.teachers.size(); i++) {
            if (getTeacherID(i) == teacherID) {
                this.teachers.set(i, newTeacherID);
            }
        }

    }

    public void deleteTeacher(int teacherID) {

        for (int i = 0; i < this.teachers.size(); i++) {
            if (getTeacherID(i) == teacherID) {
                this.teachers.remove(i);
                break;
            }
        }
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

    public boolean addStudent(int studentID) {

        //the returned value determines whether the student is already participating in the course or not

        boolean found = false;

        for (int i = 0; i < this.students.size(); i++) {
            if (getStudentID(i) == studentID) {
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("This student is already participating in this course!");
            return true;
        } else {
            this.students.add(studentID);
            return false;
        }
    }

    //mainly here to fulfill crud requirements
    public void updateStudent(int studentID, int newStudentID) {

        for (int i = 0; i < this.students.size(); i++) {
            if (getStudentID(i) == studentID) {
                this.students.set(i, newStudentID);
            }
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
