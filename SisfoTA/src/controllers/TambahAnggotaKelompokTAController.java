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
import models.KelompokTA;
import models.Mahasiswa;
import view.TambahAnggotaKelompokTA;

/**
 *
 * @author YAYAN
 */
public class TambahAnggotaKelompokTAController implements ActionListener{
  TambahAnggotaKelompokTA b;

  public TambahAnggotaKelompokTAController(TambahAnggotaKelompokTA b) {
    this.b = b;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Object o = e.getSource();
    HubungDB hdb = b.getHdb();
    Dosen d = b.getD();
    String topik = b.getTopik();
    String nim = b.getNIM();
    if(o.equals(b.getButCek())){
      KelompokTA k = d.getKelompokTA(topik);
      if(k==null) JOptionPane.showMessageDialog(b, "Kelompok TA tidak ada");
      else JOptionPane.showMessageDialog(b, "Kelompok TA ada");
    }
    if(o.equals(b.getButInput())){
      KelompokTA t = d.getKelompokTA(topik);
      if(t==null) {
        JOptionPane.showMessageDialog(b, "Kelompok TA tidak ada");
        return;
      }
      Mahasiswa m = getMahasiswa(b.getLm(),nim);
      if(m==null) {
        JOptionPane.showMessageDialog(b, "Mahasiswa tidak ada");
        return;
      }
      if(t.getAnggota(nim)!=null) {
        JOptionPane.showMessageDialog(b, "Mahasiswa sudah masuk dalam kelompok TA");
        return;
      }
      if(t.getJumMahasiswa()>=5){
        JOptionPane.showMessageDialog(b, "Kelompok TA sudah penuh");
        return;
      }  
      t.addAnggota(m);
      hdb.executeQuery("update mahasiswa set topik='"+topik+"' where nim='"+m.getNim()+"'");
      JOptionPane.showMessageDialog(b, "Sukses");
    }
  }
  private Mahasiswa getMahasiswa(ArrayList<Mahasiswa> l, String nim){
    for(Mahasiswa m: l){
      if(m.getNim().equals(nim)) return m;
    }
    return null;
  }
  
}
