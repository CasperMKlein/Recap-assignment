package Model;

public class Exam {

    int examID;
    int teacherID;
    int studentID;
    int courseID;

    public Exam(int examID, int teacherID, int studentID, int courseID) {
        this.examID = examID;
        this.teacherID = teacherID;
        this.studentID = studentID;
        this.courseID = courseID;
    }

    public int getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public int getExamID() {
        return examID;
    }

    public void setExamID(int examID) {
        this.examID = examID;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }
}
