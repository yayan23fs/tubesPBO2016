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
import tubes.AplikasiKonsol;
import view.HapusAnggotaKelompokTA;

/**
 *
 * @author YAYAN
 */
public class HapusAnggotaKelompokTAController implements ActionListener{
  HapusAnggotaKelompokTA b;

  public HapusAnggotaKelompokTAController(HapusAnggotaKelompokTA b) {
    this.b = b;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    String topik = b.getTopik();
    Dosen d = b.getD();
    HubungDB hdb = b.getHdb();
    KelompokTA t = d.getKelompokTA(topik);
    Object o = e.getSource();
    if(o.equals(b.getButCek2())){
      Mahasiswa mm = getMahasiswa(b.getListMahasiswa(), b.getNIM());
      if(mm!=null) JOptionPane.showMessageDialog(b, "Mahasiswa ada");
      else JOptionPane.showMessageDialog(b, "Mahasiswa tidak ada");
    }
    if(o.equals(b.getButCek())){
      if (t==null)JOptionPane.showMessageDialog(b, "KelompokTA tidak ada");
      else JOptionPane.showMessageDialog(b, "Kelompok TA ada");
    }
    else {
      if(t==null) {
        JOptionPane.showMessageDialog(b, "KelompokTA tidak ada");
        return;
      }
      String nim = b.getNIM();
      Mahasiswa m = getMahasiswa(b.getListMahasiswa(),nim);
      if(m==null) {
        JOptionPane.showMessageDialog(b, "Mahasiswa tidak ada");
        return ;
      }
      if(t.getAnggota(nim)==null) {
        JOptionPane.showMessageDialog(b, "Mahasiswa tidak masuk di kelompok TA tersebut");
        return ;
      }
      t.removeAnggota(nim);
      hdb.executeQuery("update mahasiswa set topik=null where nim='"+m.getNim()+"'");
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
