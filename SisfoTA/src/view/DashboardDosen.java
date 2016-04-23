/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controllers.DashboardDosenController;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import models.Dosen;
import models.HubungDB;
import models.Mahasiswa;

/**
 *
 * @author YAYAN
 */
public class DashboardDosen extends javax.swing.JFrame {

  /**
   * Creates new form DashboardDosen
   */
  private Dosen d;
  private HubungDB hdb;
  private ArrayList<Mahasiswa> listMahasiswa;
  public DashboardDosen() {
    initComponents();
  }

  public DashboardDosen(Dosen d, HubungDB hdb, ArrayList<Mahasiswa> l) {
    initComponents();
    this.d = d;
    this.hdb = hdb;
    this.listMahasiswa= l;
    DashboardDosenController dd = new DashboardDosenController(this);
    butBuatKelompokTA.addActionListener(dd);
    butHapusAnggotaKelompokTA.addActionListener(dd);
    butLihatMahasiswaDibimbing.addActionListener(dd);
    butLihatSemuaKelompokTA.addActionListener(dd);
    butTambahAnggotaKelompokTA.addActionListener(dd);
    butUbahStatusPembimbingTA.addActionListener(dd);
  }
  

  public Dosen getD() {
    return d;
  }

  public HubungDB getHdb() {
    return hdb;
  }

  public JButton getButBuatKelompokTA() {
    return butBuatKelompokTA;
  }

  public JButton getButHapusAnggotaKelompokTA() {
    return butHapusAnggotaKelompokTA;
  }

  public JToggleButton getButLihatMahasiswaDibimbing() {
    return butLihatMahasiswaDibimbing;
  }

  public JButton getButLihatSemuaKelompokTA() {
    return butLihatSemuaKelompokTA;
  }

  public JButton getButTambahAnggotaKelompokTA() {
    return butTambahAnggotaKelompokTA;
  }

  public JButton getButUbahStatusPembimbingTA() {
    return butUbahStatusPembimbingTA;
  }

  public ArrayList<Mahasiswa> getListMahasiswa() {
    return listMahasiswa;
  }
  
  
  
  

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jPanel1 = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    butBuatKelompokTA = new javax.swing.JButton();
    butTambahAnggotaKelompokTA = new javax.swing.JButton();
    butHapusAnggotaKelompokTA = new javax.swing.JButton();
    butLihatSemuaKelompokTA = new javax.swing.JButton();
    butUbahStatusPembimbingTA = new javax.swing.JButton();
    butLihatMahasiswaDibimbing = new javax.swing.JToggleButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jLabel1.setText("Dashboard Dosen");

    butBuatKelompokTA.setText("Buat Kelompok TA");

    butTambahAnggotaKelompokTA.setText("Tambah Anggota Kelompok TA");

    butHapusAnggotaKelompokTA.setText("Hapus Anggota Kelompk TA");

    butLihatSemuaKelompokTA.setText("Lihat Semua Kelompok TA");

    butUbahStatusPembimbingTA.setText("Ubah Status Pembimbing TA");

    butLihatMahasiswaDibimbing.setText("Lihat Mahasiswa Dimbimbing");

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(141, 141, 141)
            .addComponent(jLabel1))
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(95, 95, 95)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addComponent(butBuatKelompokTA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(butTambahAnggotaKelompokTA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(butHapusAnggotaKelompokTA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(butLihatSemuaKelompokTA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(butUbahStatusPembimbingTA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(butLihatMahasiswaDibimbing, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        .addContainerGap(106, Short.MAX_VALUE))
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel1)
        .addGap(18, 18, 18)
        .addComponent(butBuatKelompokTA)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(butTambahAnggotaKelompokTA)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(butHapusAnggotaKelompokTA)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(butLihatSemuaKelompokTA)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(butUbahStatusPembimbingTA)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(butLihatMahasiswaDibimbing)
        .addContainerGap(67, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addContainerGap())
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
      java.util.logging.Logger.getLogger(DashboardDosen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(DashboardDosen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(DashboardDosen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(DashboardDosen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new DashboardDosen().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton butBuatKelompokTA;
  private javax.swing.JButton butHapusAnggotaKelompokTA;
  private javax.swing.JToggleButton butLihatMahasiswaDibimbing;
  private javax.swing.JButton butLihatSemuaKelompokTA;
  private javax.swing.JButton butTambahAnggotaKelompokTA;
  private javax.swing.JButton butUbahStatusPembimbingTA;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JPanel jPanel1;
  // End of variables declaration//GEN-END:variables
}
