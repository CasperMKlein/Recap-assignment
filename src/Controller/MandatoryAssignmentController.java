package Controller;


public class MandatoryAssignmentController extends ExamController implements MandatoryAssignmentInterface {


    public String file = "MandatoryAssignmentFile";

    @Override
    public void addManAss(int studentID, int courseID, String description) {
        super.addExam(studentID, courseID, description,"ManAss");
    }

    @Override
    public void addManAssByCourse(int courseID, String description) {
        super.addExamsByCourse(courseID,description,"ManAss");
    }

    @Override
    public void saveManAssFile(String fileName) {
        super.saveExamsFile(fileName,"ManAss");
    }

    @Override
    public void loadManAssFile(String fileName) {
        super.loadExamsFile(fileName,"ManAss");
    }

    @Override
    public void printManAss() {
        super.printExams("ManAss");
    }

    @Override
    public void printManAssByID(int ID) {
        super.printExamByID(ID,"ManAss");
    }

    @Override
    public void deleteManAss(int manAssID) {
        super.deleteExam(manAssID,"ManAss");
    }

    @Override
    public void deleteManAssByCourse(int courseID) {
        super.deleteExamsByCourse(courseID,"ManAss");
    }
}
