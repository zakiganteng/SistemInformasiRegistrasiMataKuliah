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
import model.Matakuliah;
import view.HomeAdmin;
import view.TambahMatkulAdmin;

/**
 *
 * @author ASUS
 */
public class ControllerTambahMatkulAdmin implements ActionListener {
    private Aplikasi app;
    private TambahMatkulAdmin view;

    public ControllerTambahMatkulAdmin() {
        app = new Aplikasi();
        view = new TambahMatkulAdmin();
        view.setVisible(true);
        view.addListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        
        if (source.equals(view.getBtnSave())) {
            if (app.isDuplikatMatkul(view.getMatkul()) == false) {
                Matakuliah matkul = new Matakuliah();
                matkul.setnamaMK(view.getMatkul());
                app.saveListMatkulToFile(app.addMatakuliah(matkul));
                JOptionPane.showMessageDialog(null, "Matakuliah berhasil ditambahkan");
            }
            else {
                JOptionPane.showMessageDialog(null, "Matakuliah sudah ada");
            }
        }
        
        else if (source.equals(view.getBtnCancel())) {
            ControllerHomeAdmin home = new ControllerHomeAdmin();
            view.dispose();
        }
    }
}
