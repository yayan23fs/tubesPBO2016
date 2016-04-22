/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import javax.swing.JButton;
import models.Dosen;
import models.HubungDB;
import models.Mahasiswa;

/**
 *
 * @author YAYAN
 */
public class TambahAnggotaKelompokTA extends javax.swing.JFrame {

  /**
   * Creates new form TambahAnggotaKelompokTA
   */
  Dosen d;
  HubungDB hdb;
  ArrayList<Mahasiswa> lm;
  public TambahAnggotaKelompokTA() {
    initComponents();
  }

  public TambahAnggotaKelompokTA(Dosen d, HubungDB hdb,ArrayList<Mahasiswa> l) {
    this.d = d;
    this.hdb = hdb;
    this.lm = l;
  }

  public Dosen getD() {
    return d;
  }

  public HubungDB getHdb() {
    return hdb;
  }

  public JButton getButCek() {
    return butCek;
  }

  public JButton getButInput() {
    return butInput;
  }
  
  public String getNIM(){
    return textNim.getText();
  }
  public String getTopik(){
    return textTopik.getText();
  }

  public ArrayList<Mahasiswa> getLm() {
    return lm;
  }

  
  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jInternalFrame1 = new javax.swing.JInternalFrame();
    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    textTopik = new javax.swing.JTextField();
    jLabel3 = new javax.swing.JLabel();
    butCek = new javax.swing.JButton();
    textNim = new javax.swing.JTextField();
    butInput = new javax.swing.JButton();

    jInternalFrame1.setVisible(true);

    javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
    jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
    jInternalFrame1Layout.setHorizontalGroup(
      jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 0, Short.MAX_VALUE)
    );
    jInternalFrame1Layout.setVerticalGroup(
      jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 0, Short.MAX_VALUE)
    );

    jLabel1.setText("Tambah Anggota Kelompok TA");

    jLabel2.setText("Masukkan Topik");

    jLabel3.setText("NIM");

    butCek.setText("Cek");

    butInput.setText("Input");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jLabel1)
        .addGap(119, 119, 119))
      .addGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGap(43, 43, 43)
            .addComponent(jLabel3)
            .addGap(18, 18, 18)
            .addComponent(textNim, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(layout.createSequentialGroup()
            .addGap(31, 31, 31)
            .addComponent(jLabel2)
            .addGap(18, 18, 18)
            .addComponent(textTopik, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addGap(18, 18, 18)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(butCek)
          .addComponent(butInput))
        .addContainerGap(24, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel1)
        .addGap(47, 47, 47)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(textTopik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(butCek)
          .addComponent(jLabel2))
        .addGap(80, 80, 80)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel3)
          .addComponent(textNim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(butInput))
        .addContainerGap(102, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  /**
   * @param args the command line arguments
   */
  public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex) {
      java.util.logging.Logger.getLogger(TambahAnggotaKelompokTA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(TambahAnggotaKelompokTA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(TambahAnggotaKelompokTA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(TambahAnggotaKelompokTA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new TambahAnggotaKelompokTA().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton butCek;
  private javax.swing.JButton butInput;
  private javax.swing.JInternalFrame jInternalFrame1;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JTextField textNim;
  private javax.swing.JTextField textTopik;
  // End of variables declaration//GEN-END:variables
}
