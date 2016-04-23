/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import models.Dosen;
import models.HubungDB;
import models.Mahasiswa;
import models.TugasAkhir;
import tubes.AplikasiKonsol;
import view.UbahStatusPembimbingTA;

/**
 *
 * @author BagusThanatos (github.com/BagusThanatos)
 */
public class UbahStatusPembimbingTAController implements ActionListener{
  UbahStatusPembimbingTA b;

  public UbahStatusPembimbingTAController(UbahStatusPembimbingTA b) {
    this.b = b;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Dosen d = b.getD();
    HubungDB hdb = b.getHdb();
    ArrayList<Mahasiswa> list = b.getListMahasiswa();
    String nim = b.getNIM();
    int status = b.getStatusPembimbing();
    Object s = e.getSource();
    if(s.equals(b.getButConfirm())){
      Mahasiswa m = getMahasiswa(list,nim);
      if(m==null) {
        JOptionPane.showMessageDialog(b, "Mahasiswa tidak ada");
        return;
      }
      TugasAkhir ta = m.getTugasAkhir();
      if(ta==null) {
        JOptionPane.showConfirmDialog(b, "Mahasiswa tidak punya TA");
        return;
      }
      Dosen p = ta.getPembimbing(d.getNip());
      if(p==null){
        if(status == 0) {
          JOptionPane.showMessageDialog(b, "Tidak menjadi pembimbing");
          return;
        }
        p = ta.getPembimbing(status-1);
        if(p!=null) {
          JOptionPane.showMessageDialog(b, "Sudah ada pembimbing");
          return;
        }
        ta.setPembimbing(d, status);
        hdb.executeQuery("update tugasakhir set pembimbing"+status+"='"+d.getNip()+"' where nim='"+nim+"'");
      }
      else {
        if(status>0) {
          JOptionPane.showMessageDialog(b, "sudah menjadi pembimbing");
          return;
        }
        ta.removePembimbing(d.getNip());
        hdb.executeQuery("update tugasakhir set pembimbing1='"+
                ta.getPembimbing(1).getNip()+"',pembimbing2='"+
                ta.getPembimbing(2).getNip()+"' where nim='"+nim+"'");
      }
      JOptionPane.showMessageDialog(b, "Sukses");
    }
    if (s.equals(b.getButCek())){
      Mahasiswa m = getMahasiswa(b.getListMahasiswa(), b.getNIM());
      if(m==null) JOptionPane.showMessageDialog(b, "Mahasiswa tidak ada");
      else JOptionPane.showMessageDialog(b, "Mahasiswa ada");
    }
  }
  private Mahasiswa getMahasiswa(ArrayList<Mahasiswa> l, String nim){
    for(Mahasiswa m: l){
      if(m.getNim().equals(nim)) return m;
    }
    return null;
  }
  
}
