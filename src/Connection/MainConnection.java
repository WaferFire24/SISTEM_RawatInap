package Connection;

import java.sql.Connection;

public class MainConnection {
    public static void main(String[] args) {
      ConnectionManager conMan = new ConnectionManager();
        try {
        conMan.Logon();
        System.out.println(" Koneksi Tersedia");   
        } catch (Exception e) {
            System.out.println(e);
        }
    } 
}
