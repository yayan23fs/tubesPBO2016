/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes;

import java.util.Date;

/**
 *
 * @author YAYAN
 */
public abstract class Orang {
  private String nama;
  private Date tgl;
  private String address;
  private String telp;
  
  public Orang(){
    
  }

  public Orang(String nama, Date tgl, String address, String telp) {
    this.nama = nama;
    this.tgl = tgl;
    this.address = address;
    this.telp = telp;
  }
    
  public String getNama() {
    return nama;
  }

  public void setNama(String nama) {
    this.nama = nama;
  }

  public Date getTgl() {
    return tgl;
  }

  public void setTgl(Date tgl) {
    this.tgl = tgl;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getTelp() {
    return telp;
  }

  public void setTelp(String telp) {
    this.telp = telp;
  }
}
