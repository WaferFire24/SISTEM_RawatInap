/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Connection.ConnectionManager;
import Model.Petugas;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nada
 */
public class ExecutePetugas {
    public String InsertPetugas(Petugas pts){
        String query ="INSERT INTO petugas_kamar(id_petugas, nama_petugas)" + 
                " VALUES(?,?)";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.Logon();
        String Respon;
        try {
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setInt(1, pts.getID());
            pstm.setString(2, pts.getNama());
            pstm.executeUpdate();
            Respon="Data berhasil disimpan";
        } catch (SQLException ex) {
            Respon="Data gagal disimpan!";
            ex.printStackTrace();
        }
        conMan.Logoff();
        return Respon;
    }
    
    public List<Petugas> ListPts(){
        List<Petugas> arrlist= new ArrayList<>();
        String query = "SELECT * FROM petugas_kamar";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.Logon();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                Petugas tugas = new Petugas();
                tugas.setID(rs.getInt("id_petugas"));
                tugas.setNama(rs.getString("nama_petugas"));              
                arrlist.add(tugas);
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        conMan.Logoff();
        return arrlist;
    }

    public String UpdatePetugas(Petugas pts){
         String hasil = "";
         String query = "update petugas_kamar SET nama_petugas='" + pts.getNama() + "'";
        // 
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.Logon();
        try {
            Statement stm = conn.createStatement();
             stm.executeUpdate(query);
             hasil="Data berhasil diupdate";
        } catch (SQLException ex) {
            hasil="Data gagal diupdate";
            Logger.getLogger(ExecutePetugas.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.Logoff();
        return hasil;    
    }
    
     public String DeletePetugas(int id){
        String hasil = "";
        String query = "delete from petugas_kamar where id_petugas='"+id+"'";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.Logon();
        try {
            Statement stm = conn.createStatement();
            stm.executeUpdate(query);
            hasil="Data berhasil di hapus";
        } catch (SQLException ex) {
            hasil="Data gagal dihapus";
            Logger.getLogger(ExecutePetugas.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.Logoff();
        return hasil;  
    }



    
}
