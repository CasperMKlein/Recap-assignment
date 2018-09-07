package Model;

public class Teacher {
    int ID;
    String navn;

    public Teacher(int ID, String navn) {
        this.ID = ID;
        this.navn = navn;
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
        return navn;
    }
}
