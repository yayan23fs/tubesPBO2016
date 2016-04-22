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
import java.util.ArrayList;
import java.util.Scanner;
import models.*;
public class AplikasiKonsol {
  private ArrayList<Dosen> listDosen;
  private ArrayList<Mahasiswa> listMahasiswa;
  private HubungDB hdb;
  enum Return{
    SUKSES,
    KELOMPOKTASUDAHADA,
    GAGAL,
    MAHASISWATIDAKADA,
    DOSENTIDAKADA,
    KELOMPOKTATIDAKADA,
    MAHASISWASUDAHMASUK,
    MAHASISWATIDAKTERMASUK,
    SUDAHMENJADIPEMBIMBING,
    TIDAKPUNYATA,
    SUDAHADATA,
    TIDAKMENJADIPEMBIMBING,
    SUDAHADAPEMBIMBING
  }
  
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
    String topik, judul,nim;
    Return ret;
    int i=0;
    int pil=0;
    Scanner input = new Scanner(System.in);
    User u = null;
    while ((i <3)&&(u==null) ){
      System.out.println("Username:");
      username = input.next();
      System.out.println("Password:");
      password = input.next();
      u = hdb.getUser(username, password);
      i++;
    }
    if (u != null){
      System.out.println("-----Sistem Informasi Pengelolaan Data TA-----");
      if(u.isIsDosen()){
        Dosen d = hdb.getDosenOnly(u.getKode());
        listMahasiswa = hdb.getAllMahasiswa();System.out.println(listMahasiswa.size());
        hdb.getAllKelompokTA(d, listMahasiswa);
        while (pil !=4){
          System.out.println("1. Manage kelompok TA");
          System.out.println("2. Manage bimbingan");
          System.out.println("3. Lihat Semua Mahasiswa");
          System.out.println("4. Keluar");
          System.out.println("Pilihan:");
          pil = input.nextInt();
          switch(pil){
            case 1:
              while(pil != 5){
                System.out.println("Manage Kelompok TA");
                System.out.println("1. Buat Kelompok TA");
                System.out.println("2. Tambah Anggota Kelompok TA");
                System.out.println("3. Hapus Anggota Kelompok TA");
                System.out.println("4. Lihat semua Kelompok TA");
                System.out.println("5. Kembali ke menu sebelumnya");
                System.out.println("Pilihan:");
                pil = input.nextInt();
                switch(pil){
                  case 1:
                    System.out.println("Masukkan topik: ");
                    topik = input.next();
                    ret = buatKelompokTA(topik,d);
                    if(ret==Return.KELOMPOKTASUDAHADA)
                      System.out.println("Kelompok TA sudah ada");
                    else System.out.println("Kelompok TA berhasil dibuat");
                    break;
                  case 2:
                    System.out.println("Masukkan topik: ");
                    topik = input.next();
                    System.out.println("Masukkan nim mahasiswa: ");
                    nim = input.next();
                    ret = masukkanAnggotaKelTA(topik, nim, d);
                    if(ret==Return.MAHASISWATIDAKADA)
                      System.out.println("Mahasiswa tidak ada");
                    if(ret == Return.MAHASISWASUDAHMASUK)
                      System.out.println("Mahasiswa sudah masuk dalam topik tersebut");
                    if(ret == Return.KELOMPOKTATIDAKADA)
                      System.out.println("Kelompok TA tidak ada");
                    if(ret== Return.SUKSES)
                      System.out.println("Sukses menginputkan mahasiswa");
                    break;
                  case 3:
                    System.out.println("Masukkan topik: ");
                    topik = input.next();
                    System.out.println("Masukkan nim mahasiswa: ");
                    nim = input.next();
                    ret = deleteAnggotaKelTA(topik, nim, d);
                    if(ret==Return.MAHASISWATIDAKADA)
                      System.out.println("Mahasiswa tidak ada");
                    if(ret == Return.MAHASISWATIDAKTERMASUK)
                      System.out.println("Mahasiswa tidak masuk dalam topik tersebut");
                    if(ret == Return.KELOMPOKTATIDAKADA)
                      System.out.println("Kelompok TA tidak ada");
                    if(ret== Return.SUKSES)
                      System.out.println("Sukses menghapus mahasiswa dari kelompok TA tersebut");
                    break;
                  case 4: 
                    System.out.println("Kelompok TA:");
                    for(int k =0; k<3 ;k++){
                      KelompokTA kk = d.getKelompokTA(k);
                      if(kk==null) continue;
                      System.out.println(k+". "+kk.getTopik());
                      for(int j =0; j<5;j++){
                        Mahasiswa m = kk.getAnggota(j);
                        if(m!=null) 
                          System.out.println("\t"+m.getNim()+" "+m.getNama());
                      }
                    }
                    break;
                  case 5 : break;
                  default:
                    System.out.println("Input Salah!");
                  }
                
              }
              
            case 2:
              while(pil!=5) {
                System.out.println("Manage Bimbingan");
                System.out.println("1. Ubah Status Pembimbing TA");
                System.out.println("2. Semua mahasiswa yang dibimbing");
                System.out.println("3. Kembali ke menu sebelumnya");
                System.out.println("Pilihan:");
                pil = input.nextInt();
                switch(pil){
                  case 1:
                    System.out.println("Masukkan nim mahasiswa: ");
                    nim = input.next();
                    System.out.println("Sebagai pembimbing ke(1/2/0 ; 0=bukan pembimbing) :");
                    int pem = input.nextInt();
                    if(pem<0 || pem>2) {
                      System.out.println("Input harus 1/2/0");
                      continue;
                    }
                    ret = setPembimbingMahasiswa(nim, d, pem);
                    if(ret==Return.SUKSES)
                      System.out.println("Sukses ubah status pembimbing");
                    if(ret==Return.MAHASISWATIDAKADA)
                      System.out.println("Mahasiswa Tidak Ada");
                    if(ret==Return.TIDAKPUNYATA)
                      System.out.println("Mahasiswa Tidak Punya TA");
                    if(ret==Return.SUDAHADAPEMBIMBING)
                      System.out.println("Sudah ada pembimbing untuk posisi tersebut");
                    if(ret==Return.TIDAKMENJADIPEMBIMBING)
                      System.out.println("Anda tidak menjadi pembimbing untuk mahasiswa tersebut");
                    if(ret==Return.SUDAHMENJADIPEMBIMBING)
                      System.out.println("Anda sudah menjadi pembimbing untuk mahasiswa tersebut");
                    break;
                  case 2:
                    for(Mahasiswa m: listMahasiswa){
                      TugasAkhir ta = m.getTugasAkhir();
                      if(ta.getPembimbing(1).getNip().equals(d.getNip()))
                        System.out.println(m.getNim()+" "+m.getNama()+ ": Pembimbing 1");
                      if(ta.getPembimbing(2).getNip().equals(d.getNip()))
                        System.out.println(m.getNim()+" "+m.getNama()+ ": Pembimbing 2");
                    }
                    break;
                  case 3 : break;
                  default: System.out.println("input salah!");
                }
              }
              break;
            case 3:
              for(Mahasiswa m : listMahasiswa){
                System.out.println(m.getNim()+" "+m.getNama());
              }
              break;
            case 4: break;
            default:
              System.out.println("Input salah!");
          }
        }
      }else{
        Mahasiswa m = hdb.getMahasiswa(u.getKode());
        //listDosen = hdb.getAllDosen();
        hdb.getAllDosen();
        while (pil !=4){
          System.out.println("1. Buat TA");
          System.out.println("2. Revisi judul TA");
          System.out.println("3. Keluar");
          System.out.println("Pilihan:");
          pil = input.nextInt();
          switch(pil){
            case 1:
              System.out.println("Masukkan judul TA:");
              judul = input.next();
              ret =buatTA(judul, m);
              if(ret==Return.SUDAHADATA)
                System.out.println("Anda Sudah Mempunyai Judul TA");
              if(ret==Return.SUKSES)
                System.out.println("Sukses");
              break;
            case 2:
              System.out.println("Masukkan judul TA yang baru:");
              judul = input.next();
              ret = ubahJudulTA(judul, m);
              if(ret==Return.TIDAKPUNYATA)
                System.out.println("Anda Belum memasukkan judul TA");
              if(ret==Return.SUKSES)
                System.out.println("Sukses");
              break;
            case 3: break;
            default: System.out.println("Input Salah");
          }
        }   
      }
    } 
  }
  
 
  private Return buatTA(String judul, Mahasiswa m){
    if(m.getTugasAkhir()!=null) return Return.SUDAHADATA;
    m.createTA(judul);
    hdb.executeQuery("insert into tugasakhir values('"+m.getNim()+"','"+judul+"',null,null)");
    return Return.SUKSES;
  }
  private Return ubahJudulTA(String judul, Mahasiswa m){
    if(m.getTugasAkhir()==null) return Return.TIDAKPUNYATA;
    m.updateTA(judul);
    hdb.executeQuery("update tugasakhir set judul='"+judul+"' where nim='"+m.getNim()+"'");
    return Return.SUKSES;
  }
  private Return buatKelompokTA(String topik, Dosen d){
    if(d.getKelompokTA(topik)!=null) return Return.KELOMPOKTASUDAHADA;
    d.createKelompokTA(topik);
    hdb.executeQuery
        ("insert into kelompokta values('"+topik+"','"+d.getNip()+"')");
    return Return.SUKSES;
  }
  private Return masukkanAnggotaKelTA(String topik, String nim, Dosen d){
    KelompokTA t = d.getKelompokTA(topik);
    if(t==null) return Return.KELOMPOKTATIDAKADA;
    Mahasiswa m = getMahasiswa(nim);
    if(m==null) return Return.MAHASISWATIDAKADA;
    if(t.getAnggota(nim)!=null) return Return.MAHASISWASUDAHMASUK;
    t.addAnggota(m);
    hdb.executeQuery("update mahasiswa set topik='"+topik+"' where nim='"+m.getNim()+"'");
    return Return.SUKSES;
  }
  private Return deleteAnggotaKelTA(String topik, String nim , Dosen d){
    KelompokTA t = d.getKelompokTA(topik);
    if(t==null) return Return.KELOMPOKTATIDAKADA;
    Mahasiswa m = getMahasiswa(nim);
    if(m==null) return Return.MAHASISWATIDAKADA;
    if(t.getAnggota(nim)==null) return Return.MAHASISWATIDAKTERMASUK;
    t.removeAnggota(nim);
    hdb.executeQuery("update mahasiswa set topik=null where nim='"+m.getNim()+"'");
    return Return.SUKSES;
  }
  private Return setPembimbingMahasiswa(String nim, Dosen d,int status){
    Mahasiswa m = getMahasiswa(nim);
    if(m==null) return Return.MAHASISWATIDAKADA;
    TugasAkhir ta = m.getTugasAkhir();
    if(ta==null) return Return.TIDAKPUNYATA;
    Dosen p = ta.getPembimbing(d.getNip());
    if(p==null){
      if(status == 0) return Return.TIDAKMENJADIPEMBIMBING;
      p = ta.getPembimbing(status-1);
      if(p!=null) return Return.SUDAHADAPEMBIMBING;
      ta.setPembimbing(d, status);
      hdb.executeQuery("update tugasakhir set pembimbing"+status+"='"+d.getNip()+"' where nim='"+nim+"'");
    }
    else {
      if(status>0) return Return.SUDAHMENJADIPEMBIMBING;
      ta.removePembimbing(d.getNip());
      hdb.executeQuery("update tugasakhir set pembimbing1='"+
              ta.getPembimbing(1).getNip()+"',pembimbing2='"+
              ta.getPembimbing(2).getNip()+"' where nim='"+nim+"'");
    }
    return Return.SUKSES;
  }
  private Mahasiswa getMahasiswa(String nim){
    for(Mahasiswa m : listMahasiswa){
      if(m.getNim().equals(nim)) return m;
    }
    return null;
  }
}
