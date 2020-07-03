/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import java.sql.Connection;

/**
 *
 * @author Nada
 */
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
