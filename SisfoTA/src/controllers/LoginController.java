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
import models.User;
import view.DashboardDosen;
import view.DashboardMahasiswa;
import view.Login;

/**
 *
 * @author BagusThanatos (github.com/BagusThanatos)
 */
public class LoginController implements ActionListener{
  Login b ;

  public LoginController(Login b) {
    this.b = b;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if(e.getSource().equals(b.getButLogin())){
      HubungDB hdb = b.getHdb();
      User u = hdb.getUser(b.getUsername(), b.getPassword());
      if(u==null){
        JOptionPane.showMessageDialog(b, "Username atau Password Salah!");
        return;
      }
      ArrayList<Mahasiswa> listMahasiswa = hdb.getAllMahasiswa();
      ArrayList<Dosen> listDosen = hdb.getAllDosen();
      if(u.isIsDosen()){
        Dosen dosen = getDosen(listDosen, u.getKode());
        for(int i=0; i< listMahasiswa.size();i++){
          hdb.getTugasAkhir(listDosen, listMahasiswa.get(i));
        }
        hdb.getAllKelompokTA(dosen, listMahasiswa);
        DashboardDosen d = new DashboardDosen(dosen,hdb,listMahasiswa);
        d.setVisible(true);
      }
      else {
        Mahasiswa m =getMahasiswa(listMahasiswa, u.getKode());
        hdb.getTugasAkhir(listDosen, m);
        DashboardMahasiswa dm = new DashboardMahasiswa(m,hdb);
        dm.setVisible(true);
      }
      b.dispose();
    }
  }
  private Dosen getDosen(ArrayList<Dosen> listDosen,String nip){
    for(Dosen d: listDosen){
      if(d.getNip().equals(nip)) return d;
    }
    return null;
  }
  private Mahasiswa getMahasiswa(ArrayList<Mahasiswa> list, String nim){
    for(Mahasiswa m :list)
      if(m.getNim().equals(nim)) return m;
    return null;
  }
  
  
}
