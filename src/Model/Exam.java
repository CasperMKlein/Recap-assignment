package Model;

public class Exam {

    int examID;
    int studentID;
    int courseID;
    String description;

    public Exam(int examID, int studentID, int courseID,String description) {
        this.examID = examID;
        this.studentID = studentID;
        this.courseID = courseID;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
