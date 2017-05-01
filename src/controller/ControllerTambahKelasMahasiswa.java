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
import model.Mahasiswa;
import view.HomeMahasiswa;
import view.TambahKelasMahasiswa;

/**
 *
 * @author ASUS
 */
public class ControllerTambahKelasMahasiswa implements ActionListener {
    private Aplikasi app;
    private TambahKelasMahasiswa view;
    
    public ControllerTambahKelasMahasiswa() {
        app = new Aplikasi();
        view = new TambahKelasMahasiswa();
        view.setVisible(true);
        view.addListener(this);
        
        view.inputData(app.getListKelasFromFile());
        
        for (int i = 0; i < app.getListKelasFromFile().size(); i++) {
            view.setIsiComboBox(app.getListKelasFromFile().get(i).getNamaKelas());
        }
    }
    
    public boolean cekKelas(String namaKelas) {
        for (int i = 0; i < HomeMahasiswa.getMahasiswa().getAllKelas().size(); i++) {
            if (HomeMahasiswa.getMahasiswa().getAllKelas().get(i).getNamaKelas().equals(namaKelas)) {
                return false;
            }
        }
        return true;
    }
    
    public int getIndexMahasiswa(Mahasiswa m) {
        for (int i = 0; i < app.getListMahasiswaFromFile().size(); i++) {
            if (app.getListMahasiswaFromFile().get(i).getUsernameMhs().equals(m.getUsernameMhs())) {
                return i;
            }
        }
        return 0;
    }
    
    public Kelas getKelas(String namaKelas) {
        for (int i = 0; i < app.getListKelasFromFile().size(); i++) {
            if (app.getListKelasFromFile().get(i).getNamaKelas().equals(namaKelas)) {
                return app.getListKelasFromFile().get(i);
            }
        }
        return null;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        
        if (source.equals(view.getBtnSave())) {
            try {
                if (cekKelas(view.getIsiComboBox()) == true) {
                    ArrayList<Mahasiswa> mhs = app.getListMahasiswaFromFile();
                    mhs.get(getIndexMahasiswa(HomeMahasiswa.getMahasiswa())).addKelas(getKelas(view.getIsiComboBox()));
                    app.saveListMahasiswaToFile(mhs);
                    Mahasiswa m = app.getListMahasiswaFromFile().get(getIndexMahasiswa(HomeMahasiswa.getMahasiswa()));
                    HomeMahasiswa.addMahasiswa(m);
                    HomeMahasiswa home = new HomeMahasiswa();
                    home.inputData(HomeMahasiswa.getMahasiswa().getAllKelas());
                    JOptionPane.showMessageDialog(null, "Kelas Berhasil Ditambahkan");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Kelas Sudah Diambil");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Kelas Belum Dipilih");
            }
        }
        else if (source.equals(view.getBtnCancel())) {
            ControllerHomeMahasiswa home = new ControllerHomeMahasiswa();
            view.dispose();
        }
    }
}
