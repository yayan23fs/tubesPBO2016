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
public class User {
  private String kode;
  private boolean isDosen;

  public User(String kode, boolean isDosen) {
    this.kode = kode;
    this.isDosen = isDosen;
  }

  public String getKode() {
    return kode;
  }

  public void setKode(String kode) {
    this.kode = kode;
  }

  public boolean isIsDosen() {
    return isDosen;
  }

  public void setIsDosen(boolean isDosen) {
    this.isDosen = isDosen;
  }
  
  
}
