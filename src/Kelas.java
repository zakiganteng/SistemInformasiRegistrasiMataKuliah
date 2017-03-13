/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class Kelas {
    private MataKuliah mataKuliah;
    private String namaKelas;
    private Dosen dosen;
    //end of variable

    public Kelas(MataKuliah mataKuliah, String namaKelas, Dosen dosen) {
        this.mataKuliah = mataKuliah;
        this.namaKelas = namaKelas;
        this.dosen = dosen;
    }
    // end of constructor

    public MataKuliah getMataKuliah() {
        return mataKuliah;
    }

    public void setMataKuliah(MataKuliah mataKuliah) {
        this.mataKuliah = mataKuliah;
    }

    public String getNamaKelas() {
        return namaKelas;
    }

    public void setNamaKelas(String namaKelas) {
        this.namaKelas = namaKelas;
    }

    public Dosen getDosen() {
        return dosen;
    }

    public void setDosen(Dosen dosen) {
        this.dosen = dosen;
    }
    //end of setter/getter
    
}
