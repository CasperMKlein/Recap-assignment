package Model;

public class Exam {

    int examID;
    int teacherID;
    int studentID;
    int subjectID;

    public Exam(int examID, int teacherID, int studentID, int subjectID) {
        this.examID = examID;
        this.teacherID = teacherID;
        this.studentID = studentID;
        this.subjectID = subjectID;
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

    public int getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(int subjectID) {
        this.subjectID = subjectID;
    }
}
