/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import models.Mahasiswa;
import view.RevisiJudulTA;

/**
 *
 * @author YAYAN
 */
public class RevisiJudulController implements ActionListener{
  RevisiJudulTA b;

  public RevisiJudulController(RevisiJudulTA b) {
    this.b = b;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if(e.getSource().equals(b.getUbah())){System.out.println("here");
      String judul = b.getJudul();
      Mahasiswa m = b.getM();
      if(m.getTugasAkhir()==null) {
        JOptionPane.showMessageDialog(b, "Mahasiswa tidak punya TA");
        return;
      }
      m.updateTA(judul);
      b.getHdb().executeQuery("update tugasakhir set judul='"+judul+"' where nim='"+m.getNim()+"'");
      JOptionPane.showMessageDialog(b, "sukses");
    }
  }
  
}
