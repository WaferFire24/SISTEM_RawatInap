/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Connection.ConnectionManager;
import Model.Kamar;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nada
 */
public class ExecuteKamar {
    public String InsertKamar(Kamar kmr){
        String query ="INSERT INTO ruangan(id_ruangan, n_pasien, penyakit, n_dokter, id_petugas, tgl_masuk, tgl_keluar)" + 
                " VALUES(?,?,?,?,?,?,TO_DATE(?, DD/MM/YYYY))";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.Logon();
        String Respon;
        try {
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setInt(1, kmr.getKamar());
            pstm.setString(2, kmr.getPasien());
            pstm.setString(3, kmr.getPenyakit());
            pstm.setString(4, kmr.getDokter());
            pstm.setInt(5, kmr.getPetugas());
            pstm.setString(6, kmr.getMasuk());
            pstm.setString(7, kmr.getKeluar());
            pstm.executeUpdate();
            Respon="Data berhasil disimpan";
        } catch (SQLException ex) {
            Respon="Data gagal disimpan!";
            ex.printStackTrace();
        }
        conMan.Logoff();
        return Respon;
    }
    
    public List<Kamar> ListKmr(){
        List<Kamar> arrlist= new ArrayList<>();
        String query = "SELECT * FROM ruangan";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.Logon();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                Kamar kam = new Kamar();
                kam.setKamar(rs.getInt("id_ruangan"));
                kam.setPasien(rs.getString("n_pasien"));
                kam.setPenyakit(rs.getString("penyakit"));
                kam.setDokter(rs.getString("n_Dokter"));
                kam.setPetugas(rs.getInt("id_petugas"));
                kam.setMasuk(rs.getString("tgl_masuk"));
                kam.setKeluar(rs.getString("tgl_keluar"));
                arrlist.add(kam);
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        conMan.Logoff();
        return arrlist;
    }

    public String UpdateKamar(Kamar kmr){
        String hasil = "";
        String query = "update ruangan SET id_ruangan='" + kmr.getKamar() + "'";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.Logon();
        try {
            Statement stm = conn.createStatement();
            stm.executeUpdate(query);
            hasil="Data berhasil diupdate";
        } catch (SQLException ex) {
            hasil="Data gagal diupdate";
            Logger.getLogger(ExecuteKamar.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.Logoff();
        return hasil;    
    }
    
     public String DeletePetugas(int id){
        String hasil = "";
        String query = "delete from ruangan where id_ruangan='"+id+"'";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.Logon();
        try {
            Statement stm = conn.createStatement();
            stm.executeUpdate(query);
            hasil="Data berhasil di hapus";
        } catch (SQLException ex) {
            hasil="Data gagal dihapus";
            Logger.getLogger(ExecuteKamar.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.Logoff();
        return hasil;  
    }



    
}
