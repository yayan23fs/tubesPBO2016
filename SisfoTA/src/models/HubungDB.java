/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author YAYAN
 */
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HubungDB {
  private final String username ="root";
  private final String pass="";
  private Statement stat=null;
  private Connection conn= null;
  
  public HubungDB(){
    try{
      conn = DriverManager.getConnection("jdbc:mysql://localhost/tubespbo", username, pass);
      stat = conn.createStatement();
    }catch(SQLException e){
      e.printStackTrace();
    }
  }
  
  public ResultSet getData(String query){
    ResultSet rs = null;
    try{
      rs = stat.executeQuery(query);
    }catch(SQLException e){
      e.printStackTrace();
    }
    return rs;
  }
  
  public void executeQuery(String query){
    try{
      stat.executeUpdate(query);
    }catch(SQLException e){
      e.printStackTrace();
    }
  }
  
  
  public void saveMahasiswa(Mahasiswa m){
    String query = "insert into mahasiswa values(";
    query += "'"+m.getNama()+"','"+m.getTgl()+","+m.getAddress()+"','"+m.getTelp()+"',"+m.getNim()+","+m.isStatusLulus()+")";
    executeQuery(query);
  }
  public Mahasiswa getMahasiswa(String nim){
    String query = "select * from mahasiswa where nim="+nim;
    ResultSet rs = getData(query);
    try {
      if(rs.isBeforeFirst()){
        rs.next();
        String nama = rs.getString("nama");
        Date tgl = rs.getDate("tglLahir");
        String alamat = rs.getString("alamat");
        String telp = rs.getString("telp");
        boolean status = rs.getBoolean("status");
        Mahasiswa m = new Mahasiswa(nim,nama,tgl,alamat,telp,nim, status);
        query = "select * from tugasakhir where nim='"+nim+"'";
        rs = getData(query);
        if(rs.isBeforeFirst()){
          String judul = rs.getString("judul");
          String pembimbing1 = rs.getString("pembimbing1");
          String pembimbing2 = rs.getString("pembimbing2");
          m.createTA(judul);
          Dosen d1=null,d2=null;
          TugasAkhir ta = m.getTugasAkhir();
          if(pembimbing1 != null){
            d1 = getDosenOnly(pembimbing1);
            ta.setPembimbing(d1, 1);
          }
          if(pembimbing2 != null){
            d2 = getDosenOnly(pembimbing2);
            ta.setPembimbing(d2, 2);
          }
        }
        return m;
      }
    } catch (SQLException ex) {
      Logger.getLogger(HubungDB.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
  }
  
  private Mahasiswa getMahasiswaOnly(String nim){
    String query = "select * from mahasiswa where nim="+nim;
    ResultSet rs = getData(query);
    try {
      if(rs.isBeforeFirst()){
        rs.next();
        String nama = rs.getString("nama");
        Date tgl = rs.getDate("tglLahir");
        String alamat = rs.getString("alamat");
        String telp = rs.getString("telp");
        boolean status = rs.getBoolean("status");
        Mahasiswa m = new Mahasiswa(nim, nama,tgl,alamat,telp,nim, status);   
        return m;
      }
    } catch (SQLException ex) {
      Logger.getLogger(HubungDB.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
  }
  
  
  public void deleteMahasiswa(String nim){
    String query = "delete from mahasiswa where nim="+nim;
    executeQuery(query);
  }
  
  public ArrayList<Mahasiswa> getAllMahasiswa(){
    ArrayList<Mahasiswa> ret = new ArrayList();
    try {
      String query = "select * from mahasiswa";
      ResultSet rs = getData(query);
      if(rs.isBeforeFirst()){
        while(rs.next()){
          Mahasiswa m = new Mahasiswa();
          m.setNama(rs.getString("nama"));
          m.setTgl(rs.getDate("tglLahir"));
          m.setAddress(rs.getString("alamat"));
          m.setTelp(rs.getString("telp"));
          m.setNim(rs.getString("nim"));
          m.setStatusLulus(rs.getBoolean("status"));
          ret.add(m);
        }
      }
      rs.close();
    } catch (SQLException ex) {
      Logger.getLogger(HubungDB.class.getName()).log(Level.SEVERE, null, ex);
    }
    return ret;
  }
  
  public void getAllKelompokTA(Dosen d, ArrayList<Mahasiswa> rm){
    try {
      String query="select * from kelompokta where dosen='"+d.getNip()+"'";
      ResultSet rs = getData(query);
      if(rs.isBeforeFirst()){
        try {
          int jum = 0;
          while(rs.next()){
            d.createKelompokTA(rs.getString("topik"));
            jum++;
          }
          rs.close();
          for(int i=0;i<jum;i++){
            KelompokTA k = d.getKelompokTA(i);
            query = "select nim from mahasiswa where topik ='"+k.getTopik()+"'";
            rs = getData(query);
            if(rs.isBeforeFirst()){
              while(rs.next()){
                String nim = rs.getString("nim");
                k.addAnggota(rm.get(rm.indexOf(nim)));
              }
            }
          }
        } catch (SQLException ex) {
          Logger.getLogger(HubungDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        rs.close();
      }
    } catch (SQLException ex) {
      Logger.getLogger(HubungDB.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  public void getTugasAkhir(ArrayList<Dosen> rd, Mahasiswa m){
    try {
      String query="select * from tugasakhir where nim='"+m.getNim()+"'";
      ResultSet rs = getData(query);
      if(rs.isBeforeFirst()){
        try {
          rs.next();
          m.createTA(rs.getString("judul"));
          TugasAkhir ta = m.getTugasAkhir();
          String nip = rs.getString("pembimbing1");
          if(nip!=null){
            ta.setPembimbing(rd.get(rd.indexOf(nip)), 0);
          }
          nip = rs.getString("pembimbing2");
          if(nip!=null){
            ta.setPembimbing(rd.get(rd.indexOf(nip)), 0);
          }
          rs.close();
        } catch (SQLException ex) {
          Logger.getLogger(HubungDB.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    } catch (SQLException ex) {
      Logger.getLogger(HubungDB.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  public void saveDosen(Dosen d){
    String query = "insert into dosen values(";
    query += "'"+d.getNama()+"','"+d.getTgl()+","+d.getAddress()+"','"+d.getTelp()+"',"+d.getNip()+","+d.isStatusPembimbing()+")";
    executeQuery(query);
  }
  public Dosen getDosen(String nip){
    String query = "select * from dosen where nip='"+nip+"'";
    ResultSet rs = getData(query),rs2;
    try {
      if(rs.isBeforeFirst()){
        rs.next();
        String nama = rs.getString("nama");
        Date tgl = rs.getDate("tglLahir");
        String alamat = rs.getString("alamat");
        String telp = rs.getString("telp");
        boolean status = rs.getBoolean("status");
        query = "select * from kelompokta where dosen='"+nip+"'";
        rs.close();
        rs = getData(query);
        Dosen d = new Dosen(nama,tgl,alamat,telp,nip, status);
        if(rs.isBeforeFirst()){
          while(rs.next()){
            String topik = rs.getString("topik");
            query = "select * from mahasiswa where topik='"+topik+"'";
            d.createKelompokTA(topik);
            KelompokTA k = d.getKelompokTA(topik);
            ResultSet r = getData(query);
            if(r.isBeforeFirst()){
              while(r.next()){
                String namaMhs = r.getString("nama");
                Date tglMhs = r.getDate("tglLahir");
                String alamatMhs = r.getString("alamat");
                String telpMhs = r.getString("telp");
                String nimMhs = r.getString("nim");
                boolean statusMhs = r.getBoolean("status");
                Mahasiswa m = 
                        new Mahasiswa(nimMhs, namaMhs, tglMhs, alamatMhs, telpMhs, nimMhs, statusMhs);
                k.addAnggota(m);
              }
            }
            
          }
        }
        return d;
      }
    } catch (SQLException ex) {
      Logger.getLogger(HubungDB.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
  }
  
  public Dosen getDosenOnly(String nip){
    String query = "select * from dosen where nip='"+nip+"'";
    ResultSet rs = getData(query);
    try {
      if(rs.isBeforeFirst()){
        rs.next();
        String nama = rs.getString("nama");
        Date tgl = rs.getDate("tglLahir");
        String alamat = rs.getString("alamat");
        String telp = rs.getString("telp");
        boolean status = rs.getBoolean("status");
        return new Dosen(nama,tgl,alamat,telp,nip, status);
      }
      rs.close();
    } catch (SQLException ex) {
      Logger.getLogger(HubungDB.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
  }
  
  
  public void deleteDosen(String nip){
    String query = "delete from dosen where nim="+nip;
    executeQuery(query);
  }
  
  public ArrayList<Dosen> getAllDosen(){
    ArrayList<Dosen> ret = new ArrayList<>();
    try {
      String query = "select * from dosen";
      ResultSet rs = getData(query);
      if(rs.isBeforeFirst()){
        while(rs.next()){
          Dosen d = new Dosen();
          d.setNama(rs.getString("nama"));
          d.setTgl(rs.getDate("tglLahir"));
          d.setAddress(rs.getString("alamat"));
          d.setTelp(rs.getString("telp"));
          d.setNip(rs.getString("nip"));
          d.setStatusPembimbing(rs.getBoolean("status"));
          ret.add(d);
        }
        rs.close();
      }
      rs.close();
    } catch (SQLException ex) {
      Logger.getLogger(HubungDB.class.getName()).log(Level.SEVERE, null, ex);
    }
    return ret;
  }
  
  public User getUser(String username, String password){
    try {
      String query = "select * from user where username='"+username+"' and password='"+password+"'";
      ResultSet rs = getData(query);
      if(rs.isBeforeFirst()){
        rs.next();
        String kode = rs.getString("kode");
        boolean isDosen = rs.getBoolean("isdosen");
        return new User(kode, isDosen);
      }
      rs.close();
    } catch (SQLException ex) {
      Logger.getLogger(HubungDB.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
  }
}


