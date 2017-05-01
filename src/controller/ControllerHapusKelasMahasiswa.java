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
import view.HapusKelasMahasiswa;
import view.HomeMahasiswa;

/**
 *
 * @author ASUS
 */
public class ControllerHapusKelasMahasiswa implements ActionListener{
    private Aplikasi app;
    private HapusKelasMahasiswa view;
    
    public ControllerHapusKelasMahasiswa() {
        app = new Aplikasi();
        view = new HapusKelasMahasiswa();
        view.setVisible(true);
        view.addListener(this);
        
        view.inputData(app.getListMahasiswaFromFile().get(getIndex(HomeMahasiswa.getMahasiswa())).getAllKelas());
        
        for (int i = 0; i < HomeMahasiswa.getMahasiswa().getAllKelas().size(); i++) {
            view.setIsiComboBox(HomeMahasiswa.getMahasiswa().getAllKelas().get(i).getNamaKelas());
        }
    }
    
    public int getIndex(Mahasiswa m) {
        for (int i = 0; i < app.getListMahasiswaFromFile().size(); i++) {
            if (app.getListMahasiswaFromFile().get(i).getUsernameMhs().equals(m.getUsernameMhs())) {
                return i;
            }
        }
        return 0;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        
        if(source.equals(view.getBtnCancel())) {
            ControllerHomeMahasiswa home = new ControllerHomeMahasiswa();
            view.dispose();
        } else if(source.equals(view.getBtnDelete())) {
            int index = getIndex(HomeMahasiswa.getMahasiswa());
            if (HomeMahasiswa.getMahasiswa().getAllKelas()!=null) {
                try {
                    ArrayList<Mahasiswa> mhs = app.getListMahasiswaFromFile();
                    mhs.get(index).removeKelas(view.getIsiComboBox());
                    app.saveListMahasiswaToFile(mhs);
                    JOptionPane.showMessageDialog(null, "Kelas Berhasil Dihapus");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Kelas Belum Dipilih");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Kelas Kosong");
            }
        }
    }
    
}
