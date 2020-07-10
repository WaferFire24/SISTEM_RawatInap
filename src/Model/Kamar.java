package Model;
import java.util.Date;

public class Kamar {
    private String Pasien, Penyakit, Dokter;
    private int Kamar, Petugas;
    private Date Masuk, Keluar;

    public Kamar() {
    }

    public Kamar(int Kamar, String Pasien, String Penyakit, String Dokter, int Petugas) {
        this.Kamar = Kamar;
        this.Pasien = Pasien;
        this.Penyakit = Penyakit;
        this.Dokter = Dokter;
        this.Petugas = Petugas; 
    }

    public Date getMasuk() {
        return Masuk;
    }

    public void setMasuk(Date Masuk) {
        this.Masuk = Masuk;
    }

    public Date getKeluar() {
        return Keluar;
    }

    public void setKeluar(Date Keluar) {
        this.Keluar = Keluar;
    }

    public String getPasien() {
        return Pasien;
    }

    public void setPasien(String Pasien) {
        this.Pasien = Pasien;
    }

    public String getPenyakit() {
        return Penyakit;
    }

    public void setPenyakit(String Penyakit) {
        this.Penyakit = Penyakit;
    }

    public String getDokter() {
        return Dokter;
    }

    public void setDokter(String Dokter) {
        this.Dokter = Dokter;
    }

    public int getKamar() {
        return Kamar;
    }

    public void setKamar(int Kamar) {
        this.Kamar = Kamar;
    }

    public int getPetugas() {
        return Petugas;
    }

    public void setPetugas(int Petugas) {
        this.Petugas = Petugas;
    }
    
    @Override
    public String toString() {
        return "(ID Kamar = " + Kamar + ", Nama Pasien=" + Pasien + ", Penyakit=" + Penyakit + ", Dokter=" + Dokter + ", Petugas=" + Petugas + ')';
    } 
}