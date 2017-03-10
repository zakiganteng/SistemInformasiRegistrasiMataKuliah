/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class Aplikasi {
    private Dosen[] daftarDosen = new Dosen[100];
    private Mahasiswa[] daftarMahasiswa = new Mahasiswa[100];
    private Kelas[] daftarKelas = new Kelas[100];
    private MataKuliah[] daftarMataKuliah = new MataKuliah[100];
    private int jumlahDosen=0;
    private int jumlahMahasiswa=0;
    private int jumlahKelas=0;
    private int jumlahMataKuliah=0;
    //end of variable
    public void addDosen(Dosen dosen){
        daftarDosen[jumlahDosen] = dosen;
        jumlahDosen++;
    }
    public Dosen getDosen(int id){
        return daftarDosen[id];
    }
    public void deleteDosen(int id){
        daftarDosen[id] = null;
        for(int i = id; i<jumlahDosen;i++){
            daftarDosen[id] = daftarDosen[id+1];
        }
        daftarDosen[jumlahDosen] = null;
    }
    //end of dosen
    public void addMahasiswa(Mahasiswa mahasiswa){
        daftarMahasiswa[jumlahMahasiswa] = mahasiswa;
        jumlahMahasiswa++;
    }
    public Mahasiswa getMahasiswa(int id){
        return daftarMahasiswa[id];
    }
    public void deleteMahasiswa(int id){
        daftarMahasiswa[id] = null;
        for(int i = id; i<jumlahMahasiswa;i++){
            daftarMahasiswa[id] = daftarMahasiswa[id+1];
        }
        daftarMahasiswa[jumlahMahasiswa] = null;
    }
    //end of Mahasiswa
    public void addKelas(Kelas kelas){
        daftarKelas[jumlahKelas] = kelas;
        jumlahKelas++;
    }
    public Kelas getKelas(int id){
        return daftarKelas[id];
    }
    public void deleteKelas(int id){
        daftarKelas[id] = null;
        for(int i = id; i<jumlahKelas;i++){
            daftarKelas[id] = daftarKelas[id+1];
        }
        daftarKelas[jumlahKelas] = null;
    }
    //end of Kelas
    public void addMataKuliah(MataKuliah mataKuliah){
        daftarMataKuliah[jumlahMataKuliah] = mataKuliah;
        jumlahMataKuliah++;
    }
    public MataKuliah getMataKuliah(int id){
        return daftarMataKuliah[id];
    }
    public void deleteMataKuliah(int id){
        daftarMataKuliah[id] = null;
        for(int i = id; i<jumlahMataKuliah;i++){
            daftarMataKuliah[id] = daftarMataKuliah[id+1];
        }
        daftarMataKuliah[jumlahMataKuliah] = null;
    }
    //end of MataKuliah
}
