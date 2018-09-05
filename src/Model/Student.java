package Model;

public class Student {
    int ID;
    String name;

    public Student(int ID, String navn) {
        this.ID = ID;
        this.name = navn;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setNavn(String navn) {
        navn = navn;
    }

    public int getID() {
        return ID;
    }

    public String getNavn() {
        return name;
    }
}
