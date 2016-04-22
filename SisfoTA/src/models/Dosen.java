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
public class Dosen extends Orang{
  private KelompokTA[] topikTA;
  private String nip;
  private boolean statusPembimbing;
  private int jum;
  
  public Dosen(){
    super();
  }
  
  public Dosen(String nama, Date tgl, String address, String telp, String nip, boolean statusPembimbing){
    super(nama, tgl, address, telp);
    this.nip = nip;
    this.statusPembimbing = false;
    this.topikTA = new KelompokTA[3];
    jum =0;
  }
  public void createKelompokTA(String topik){
    if(jum<3){
      KelompokTA k = new KelompokTA(topik);
      topikTA[jum++] = k;
    }
  }
  public void deleteKelompokTA(String topik){
    for(int i=0; i<jum;i++){
      if(topikTA[i].getTopik().equals(topik)){
        topikTA[i] = null;
        for(int j=i+1; j<jum; j++){
          topikTA[j-1] = topikTA[j];
        }
        topikTA[jum-1] = null;
        jum--;
        return;
      }
    }
  }
  
  public KelompokTA getKelompokTA(int indeks){
    if (indeks < jum)
      return topikTA[indeks];
    return null;
  }
  public KelompokTA getKelompokTA(String topik){
    for(int i=0; i<jum;i++){
      if(topikTA[i].getTopik().equals(topik)){
        return topikTA[i];
      }
    }
    return null;
  }

  public String getNip() {
    return nip;
  }

  public void setNip(String nip) {
    this.nip = nip;
  }

  public boolean isStatusPembimbing() {
    return statusPembimbing;
  }

  public void setStatusPembimbing(boolean statusPembimbing) {
    this.statusPembimbing = statusPembimbing;
  }

  public int getJum() {
    return jum;
  }

  public void setJum(int jum) {
    this.jum = jum;
  }
  
  @Override 
  public boolean equals(Object o){
    if(o instanceof String) return nip.equals(o);
    return super.equals(o);
  }
  
}
