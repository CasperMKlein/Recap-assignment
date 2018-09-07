package Model;

public class Teacher {
    private int ID;
    private String name;

    public Teacher(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String navn) {
        navn = navn;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return ID + " " + name;
    }
}
