/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.BuatTA;
import view.DashboardMahasiswa;
import view.RevisiJudulTA;

/**
 *
 * @author BagusThanatos (github.com/BagusThanatos)
 */
public class DashboardMahasiswaController implements ActionListener{
  DashboardMahasiswa b;
  BuatTA bta;
  RevisiJudulTA rj;
  public DashboardMahasiswaController(DashboardMahasiswa b) {
    this.b = b;
    bta = new BuatTA(b.getM(), b.getHdb());
    rj = new RevisiJudulTA();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Object s = e.getSource();
    if(s.equals(b.getButBuatTA())) bta.setVisible(true);
    if(s.equals(b.getButRevisiJudulTA())) rj.setVisible(true);
  }
  
}
