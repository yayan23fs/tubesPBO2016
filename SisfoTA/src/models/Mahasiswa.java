/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;

/**
 *
 * @author YAYAN
 */
public class Mahasiswa extends Orang {
  private TugasAkhir tugasAkhir;
  private String nim;
  private  boolean statusLulus ;
  
  public Mahasiswa(){
    super();
  }
  
  public Mahasiswa(String nim, String nama, Date tgl, String address, String telp, String nip, boolean statusLulus){
    super(nama, tgl, address, telp);
    this.nim = nim;
    this.statusLulus = false;
  }
  public void createTA(String judul){
    this.tugasAkhir = new TugasAkhir(judul);
  } 
  public void updateTA(String judul){
    if(tugasAkhir != null)
      tugasAkhir.setJudul(judul);
  }

  public TugasAkhir getTugasAkhir() {
    return tugasAkhir;
  }

  public void setTugasAkhir(TugasAkhir tugasAkhir) {
    this.tugasAkhir = tugasAkhir;
  }

  public String getNim() {
    return nim;
  }

  public void setNim(String nim) {
    this.nim = nim;
  }

  public boolean isStatusLulus() {
    return statusLulus;
  }

  public void setStatusLulus(boolean statusLulus) {
    this.statusLulus = statusLulus;
  }
  
  @Override 
  public boolean equals(Object o){
    if(o instanceof String) return nim.equals(o);
    return super.equals(o);
  }
}
