/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.BuatKelompokTA;
import view.DashboardDosen;
import view.HapusAnggotaKelompokTA;
import view.LihatSemuaKelompokTA;
import view.SemuaMahasiswaDibimbing;
import view.TambahAnggotaKelompokTA;
import view.UbahStatusPembimbingTA;

/**
 *
 * @author YAYAN
 */
public class DashboardDosenController implements ActionListener{
  DashboardDosen b;
  BuatKelompokTA bta;
  HapusAnggotaKelompokTA hka;
  LihatSemuaKelompokTA lska;
  SemuaMahasiswaDibimbing semua;
  TambahAnggotaKelompokTA taka;
  UbahStatusPembimbingTA uspa;
  public DashboardDosenController(DashboardDosen b) {
    this.b = b;
    bta= new BuatKelompokTA(b.getD(), b.getHdb());
    hka = new HapusAnggotaKelompokTA(b.getD(),b.getHdb(), b.getListMahasiswa());
    lska = new LihatSemuaKelompokTA(b.getD());
    semua = new SemuaMahasiswaDibimbing(b.getListMahasiswa(),b.getD());
    taka = new TambahAnggotaKelompokTA(b.getD(),b.getHdb(),b.getListMahasiswa());
    uspa = new UbahStatusPembimbingTA(b.getD(), b.getHdb(), b.getListMahasiswa());
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Object s = e.getSource();
    if(s.equals(b.getButBuatKelompokTA())) bta.setVisible(true);
    if(s.equals(b.getButHapusAnggotaKelompokTA())) hka.setVisible(true);
    if(s.equals(b.getButLihatSemuaKelompokTA())) {
      lska.isiTabel();
      lska.setVisible(true);
    }
    if(s.equals(b.getButLihatMahasiswaDibimbing())) {
      semua.isiTable();
      semua.setVisible(true);
    }
    if(s.equals(b.getButTambahAnggotaKelompokTA())) taka.setVisible(true);
    if(s.equals(b.getButUbahStatusPembimbingTA())) uspa.setVisible(true);
  }
  
  
}
