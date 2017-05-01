/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class Mahasiswa extends Orang implements Serializable {
    private ArrayList<Kelas> pilihan = new ArrayList<Kelas>();
    private String usernameMhs;
    private String passwordMhs;
    private int semester;
    private String jurusan;
    private static final long serialVersionUID = -70729030451812352L;
    
    public Mahasiswa(String nama, String id, String usernameMhs, String passwordMhs, int semester, String jurusan) {
        super(nama,id);
        this.usernameMhs = usernameMhs;
        this.passwordMhs = passwordMhs;
        this.semester = semester;
        this.jurusan = jurusan;
    }
    
    public void setUsernameMhs(String usernameMhs) {
        this.usernameMhs = usernameMhs;
    }
    
    public String getUsernameMhs() {
        return usernameMhs;
    }
    
    public void setPasswordMhs(String passwordMhs) {
        this.passwordMhs = passwordMhs;
    }
    
    public String getPasswordMhs() {
        return passwordMhs;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }
    
    public void addKelas(Kelas k) {
        pilihan.add(k);
    }
    
    public void removeKelas(String namaKelas) {
        for (int i = 0; i < pilihan.size(); i++) {
            if ( pilihan.get(i).getNamaKelas().equals(namaKelas) ) {
                pilihan.remove(i);
            }
        }
    }
    
    public Kelas getKelas(String namaKelas) {
        Kelas kelas = null;
        for (int i = 0; i < pilihan.size(); i++) {
            if ( pilihan.get(i).getNamaKelas().equals(namaKelas) ) {
                kelas = pilihan.get(i);
            }
        }
        return kelas;
    }
    
    public Kelas getKelas(int index) {
        return pilihan.get(index);
    }
    
    public ArrayList<Kelas> getAllKelas() {
        return pilihan;
    }
    
    public int getTotalKelas() {
        return pilihan.size();
    }
    
    @Override
    public String display() {
        return ("Nama Mahasiswa : " + getNama() + "\n" + "ID Mahasiswa : " + getID());
    }
}