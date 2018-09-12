package Controller;

public interface MandatoryAssignmentInterface {
    abstract void addManAss(int studentID, int courseID, String description);

    void addManAssByCourse(int courseID, String description);

    void saveManAssFile(String fileName);

    void loadManAssFile(String fileName);

    void printManAss();

    void printManAssByID(int ID);

    void deleteManAss(int manAssID);

    void deleteManAssByCourse(int courseID);
}
