package controller;


import controller.ControllerHomeAdmin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Aplikasi;
import model.Dosen;
import model.Kelas;
import view.HomeAdmin;
import view.TambahDosenkeKelasAdmin;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class ControllerTambahDosenkeKelasAdmin implements ActionListener{
    private Aplikasi app;
    private TambahDosenkeKelasAdmin view;
    
    public ControllerTambahDosenkeKelasAdmin(){
        view = new TambahDosenkeKelasAdmin();
        app = new Aplikasi();
        view.setVisible(true);
        view.addListener(this);
        for (int i = 0; i < app.getListDosenFromFile().size(); i++) {
            view.setIsiDosen(app.getListDosenFromFile().get(i).getNama());
        }
        
        for (int i = 0; i < app.getListKelasFromFile().size(); i++) {
            if (app.getListKelasFromFile().get(i).getDosen()==null){
                view.setIsiKelas(app.getListKelasFromFile().get(i).getNamaKelas());
            }
        }
    }
    
    public Dosen getDosen(String nama){
        for (int i = 0; i < app.getListDosenFromFile().size(); i++) {
            if (app.getListDosenFromFile().get(i).getNama().equals(nama)) {
                return app.getListDosenFromFile().get(i);
            }
        }
        return null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        ArrayList<Kelas> ak = app.getListKelasFromFile();

        if (source.equals(view.getBtnCancel())){
            ControllerHomeAdmin home = new ControllerHomeAdmin();
            view.dispose();
        }
        if (source.equals(view.getBtnAdd())) {
            for (int i = 0; i < ak.size(); i++) {
                if (ak.get(i).getNamaKelas().equals(view.getIsiKelas())){
                    ak.get(i).setDosen(getDosen(view.getIsiDosen()));
                    app.saveListKelasToFile(ak);
                    JOptionPane.showMessageDialog(null, "Dosen Berhasil Ditambahkan!");
                }
                
            }
        }
    }
    
    
}
