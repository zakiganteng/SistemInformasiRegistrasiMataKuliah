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
public class Kelas implements Serializable {
    private Matakuliah matakuliah;
    private Dosen dosen;
    private String namaKelas;

    public Kelas(String namaKelas, Dosen dosen, Matakuliah matakuliah) {
        this.namaKelas = namaKelas;
        this.dosen = dosen;
        this.matakuliah = matakuliah;
    }

    public Kelas(String namaKelas) {
        this.namaKelas = namaKelas;
    }
    
    public Matakuliah getMatakuliah() {
        return matakuliah;
    }

    public void setMatakuliah(Matakuliah matakuliah) {
        this.matakuliah = matakuliah;
    }

    public Dosen getDosen() {
        return dosen;
    }

    public void setDosen(Dosen dosen) {
        this.dosen = dosen;
    }

    public String getNamaKelas() {
        return namaKelas;
    }

    public void setNamaKelas(String namaKelas) {
        this.namaKelas = namaKelas;
    }
}
