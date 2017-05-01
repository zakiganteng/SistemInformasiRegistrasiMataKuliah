/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Aplikasi;
import model.Kelas;
import view.HomeAdmin;
import view.TambahKelasAdmin;

/**
 *
 * @author ASUS
 */
public class ControllerTambahKelasAdmin implements ActionListener{
    private Aplikasi app;
    private TambahKelasAdmin view;
    
    public ControllerTambahKelasAdmin() {
        app = new Aplikasi();
        view = new TambahKelasAdmin();
        view.setVisible(true);
        view.addListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        
        if (source.equals(view.getBtnSave())) {
            if (app.isDuplikatKelas(view.getKelas()) == false) {
                Kelas kls = new Kelas(view.getKelas());
                app.saveListKelasToFile(app.addKelas(kls));
                JOptionPane.showMessageDialog(null, "Kelas berhasil ditambahkan");
            }
            else {
                JOptionPane.showMessageDialog(null, "Kelas sudah ada");
            }
        }
        
        else if (source.equals(view.getBtnCancel())) {
            ControllerHomeAdmin home = new ControllerHomeAdmin();
            view.dispose();
        }
    }
}
