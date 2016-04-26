/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import models.HubungDB;
import models.Mahasiswa;
import view.BuatTA;

/**
 *
 * @author YAYAN
 */
public class BuatTAController implements ActionListener {
  BuatTA b ;

  public BuatTAController(BuatTA b) {
    this.b = b;
  }
  
  
  @Override
  public void actionPerformed(ActionEvent e) {
    if(e.getSource().equals(b.getButSubmit())){
      Mahasiswa m = b.getM();
      String judul = b.getJudul();
      HubungDB hdb = b.getHdb();
      if(m.getTugasAkhir()!=null) {
        JOptionPane.showMessageDialog(b, "Tugas Akhir sudah ada");
        return;
      }
      m.createTA(judul);
      hdb.executeQuery("insert into tugasakhir values('"+m.getNim()+"','"+judul+"',null,null)");
      JOptionPane.showMessageDialog(b, "Sukses");
    }
  }
  
}
