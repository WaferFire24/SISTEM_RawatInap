package Model;

public class Petugas {
    private String Nama;
    private int ID;

    public Petugas() {
    }

    public Petugas(int ID, String Nama) {
        this.ID = ID;
        this.Nama = Nama;
    }

    public int getID() {
        return ID;
    }
    
    public String getNama() {
        return Nama;
    }

    public void setNama(String Nama) {
        this.Nama = Nama;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "(ID Petugas = " + ID + ", Nama Petugas=" + Nama + ')';
    } 
}