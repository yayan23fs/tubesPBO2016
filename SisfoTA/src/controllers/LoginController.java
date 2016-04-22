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
      if(u.isIsDosen()){
        DashboardDosen d = new DashboardDosen(hdb.getDosenOnly(u.getKode()),hdb,hdb.getAllMahasiswa());
        d.setVisible(true);
      }
      else {
        DashboardMahasiswa dm = new DashboardMahasiswa(hdb.getMahasiswa(u.getKode()),hdb);
        dm.setVisible(true);
      }
      b.dispose();
    }
  }
  
  
}
