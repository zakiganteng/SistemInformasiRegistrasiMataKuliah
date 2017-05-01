/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Aplikasi;
import model.Mahasiswa;
import view.HomeMahasiswa;
import view.LoginMahasiswa;
import view.TambahKelasMahasiswa;

/**
 *
 * @author ASUS
 */
public class ControllerLoginMahasiswa implements ActionListener {
    private Aplikasi app;
    private LoginMahasiswa view;

    public ControllerLoginMahasiswa() {
        app = new Aplikasi();
        view = new LoginMahasiswa();
        view.setVisible(true);
        view.addListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source.equals(view.getBtnLogin())) {
            if (app.isMahasiswaTrue(view.getUsername(), view.getPassword()) == true) {
                Mahasiswa m = app.getTrueMahasiswa(view.getUsername(), view.getPassword());
                HomeMahasiswa.addMahasiswa(m);
                ControllerHomeMahasiswa home = new ControllerHomeMahasiswa();
                view.dispose();
            }
            else {
                JOptionPane.showMessageDialog(null, "Username atau Password salah");
            }
        }
        
        else if (source.equals(view.getBtnBack())) {
            JOptionPane.showMessageDialog(null, "Thank you");
            System.exit(0);
        }
    }
}
