/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import model.Aplikasi;
import view.HomeAdmin;

/**
 *
 * @author ASUS
 */
public class ControllerHomeAdmin implements ActionListener{
    private HomeAdmin view;
    private Aplikasi app;

    public ControllerHomeAdmin() {
        view = new HomeAdmin();
        app = new Aplikasi();
        view.setVisible(true);
        view.addListener(this);
        
        view.inputData(app.getListKelasFromFile());
        
        view.setTxFieldNIP(app.getAdminFromFile().getID());
        view.setTxFieldNama(app.getAdminFromFile().getNama());
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        
        if(source.equals(view.getBtnTambahKelas())) {
            ControllerTambahKelasAdmin tka = new ControllerTambahKelasAdmin();
            view.dispose();
        } else if(source.equals(view.getBtnTambahMatkul())) {
            ControllerTambahMatkulAdmin tma = new ControllerTambahMatkulAdmin();
            view.dispose();
        } else if(source.equals(view.getBtnTambahDsnKls())) {
            ControllerTambahDosenkeKelasAdmin tdka = new ControllerTambahDosenkeKelasAdmin();
            view.dispose();
        } else if(source.equals(view.getBtnTambahMatkulKls())) {
            ControllerTambahMatkulkeKelasAdmin tmka = new ControllerTambahMatkulkeKelasAdmin();
            view.dispose();
        } else if(source.equals(view.getBtnLogout())) {
            ControllerLoginAdmin cla = new ControllerLoginAdmin();
            view.dispose();
        }
    }
    
    
}
