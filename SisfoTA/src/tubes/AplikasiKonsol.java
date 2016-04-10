/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes;

/**
 *
 * @author YAYAN
 */
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.*;

public class AplikasiKonsol {
  private ArrayList<Dosen> listDosen;
  private ArrayList<Mahasiswa> listMahasiswa;
  private HubungDB hdb;
  
  public AplikasiKonsol(){
    listDosen = new ArrayList<>();
    listMahasiswa = new ArrayList<>();
    hdb = new HubungDB();
  }
  
  public void addMahasiswa(Mahasiswa m){
    if(!listMahasiswa.contains(m)){
      listMahasiswa.add(m);
    }
  }
  public Mahasiswa searchMahasiswa(String nim){
    for(int i=0;i<listMahasiswa.size();i++){
      if (listMahasiswa.get(i).getNim().equals(nim)){
        return listMahasiswa.get(i);
      }
    }
    return null;
  }
  public void deleteMahasiswa(String nim){
    for(int i=0;i<listMahasiswa.size();i++){
      if (listMahasiswa.get(i).getNim().equals(nim)){
        listMahasiswa.remove(i);
        return;
      }
    }
  }
  public void addDosen(Dosen d){
    if(!listDosen.contains(d)){
      listDosen.add(d);
    }
  }
  public Dosen searchDosen(String nip){
    for(int i=0;i<listDosen.size();i++){
      if (listDosen.get(i).getNip().equals(nip)){
        return listDosen.get(i);
      }
    }
    return null;
  }
  public void deleteDosen(String nip){
    for(int i=0;i<listDosen.size();i++){
      if (listDosen.get(i).getNip().equals(nip)){
        listDosen.remove(i);
        return;
      }
    }
  }
  public void mainMenu(){
    String username, password;
    String topik, judul;
    int i=0;
    int pil=0;
    Scanner input = new Scanner(System.in);
    User u = null;
    while ((i <=3)&&(u==null) ){
      System.out.println("Username:");
      username = input.next();
      System.out.println("Password:");
      password = input.next();
      u = hdb.getUser(username, password);
    }
    if (u == null){
      System.out.println("-----Sistem Informasi Pengelolaan Data TA-----");
      if(u.isIsDosen()){
        Dosen d = hdb.getDosen(u.getKode());
        while (pil !=5 && pil >5){
          System.out.println("1. Buat kelompok TA");
          System.out.println("2. Tambah anggota kelompok TA");
          System.out.println("3. Hapus anggota kelompok TA");
          System.out.println("4. Tambahkan diri sebagai pembimbing TA mahasiswa");
          System.out.println("5. Keluar");
          System.out.println("Pilihan:");
          pil = input.nextInt();
          switch(pil){
            case 1:
              System.out.println("Masukkan topik: ");
              topik = input.next();
              
              break;
            case 2:
              break;
            case 3:
              break;
            case 4:
              break;
          }
        }
      }else{
        while (pil != 3 && pil >3){
          System.out.println("1. Buat TA");
          System.out.println("2. Revisi judul TA");
          System.out.println("3. Keluar");
          System.out.println("Pilihan:");
          pil = input.nextInt();
          switch(pil){
            case 1:
              System.out.println("Masukkan judul TA:");
              judul = input.next();
              break;
            case 2:
              System.out.println("Masukkan judul TA yang baru:");
              judul = input.next();
              break;
          }
        }   
      }
    } 
  }
  
  private int buatKelompokTA(String topik){
    
    return 0;
  }
}
