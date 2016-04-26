/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import models.Dosen;
import models.HubungDB;
import view.BuatKelompokTA;

/**
 *
 * @author YAYAN)
 */
public class BuatKelompokTAController implements ActionListener{
  private BuatKelompokTA b;
  
  public BuatKelompokTAController(BuatKelompokTA b){
    this.b= b;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if(e.getSource().equals(b.getButInput())){
      String topik = b.getTopik();
      Dosen d = b.getD();
      HubungDB hdb = b.getHdb();
      if(d.getKelompokTA(topik)!=null) {
        JOptionPane.showMessageDialog(b, "Kelompok sudah ada");
        return;
      }
      if(d.getJum()>=3){
        JOptionPane.showMessageDialog(b, "Kelompok TA sudah memenuhi jumlah maksimum");
        return;
      }
      d.createKelompokTA(topik);
      hdb.executeQuery
        ("insert into kelompokta values('"+topik+"','"+d.getNip()+"')");
      JOptionPane.showMessageDialog(b, "Input sukses");
    }
  }
}
