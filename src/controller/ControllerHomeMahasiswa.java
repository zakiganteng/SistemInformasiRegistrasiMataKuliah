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

/**
 *
 * @author ASUS
 */
public class ControllerHomeMahasiswa implements ActionListener {
    private Aplikasi app;
    private HomeMahasiswa view;
    
    public ControllerHomeMahasiswa() {
        app = new Aplikasi();
        view = new HomeMahasiswa();
        view.setVisible(true);
        view.addListener(this);
        
        view.inputData(getMahasiswaNow(HomeMahasiswa.getMahasiswa()).getAllKelas());
        
        String semester = Integer.toString(view.getMahasiswa().getSemester());
        view.setTxFieldNim(view.getMahasiswa().getID());
        view.setTxFieldNama(view.getMahasiswa().getNama());
        view.setTxFieldJurusan(view.getMahasiswa().getJurusan());
        view.setTxFieldSemester(semester);
    }
    
    public Mahasiswa getMahasiswaNow(Mahasiswa m) {
        for (int i = 0; i < app.getListMahasiswaFromFile().size(); i++) {
            if (app.getListMahasiswaFromFile().get(i).getUsernameMhs().equals(m.getUsernameMhs())) {
                return app.getListMahasiswaFromFile().get(i);
            }
        }
        return null;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        
        if (source.equals(view.getBtnAdd())) {
            ControllerTambahKelasMahasiswa tambah = new ControllerTambahKelasMahasiswa();
            view.dispose();
        }
        else if (source.equals(view.getBtnDelete())) {
            ControllerHapusKelasMahasiswa hapus = new ControllerHapusKelasMahasiswa();
            view.dispose();
        }
        else if (source.equals(view.getBtnLogout())) {
            ControllerLoginMahasiswa login = new ControllerLoginMahasiswa();
            view.dispose();
        }
    }
}
