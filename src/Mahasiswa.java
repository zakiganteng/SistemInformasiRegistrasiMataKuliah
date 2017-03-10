/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class Mahasiswa extends Orang{
    private String noInduk;
    private Kelas[] pilihan = new Kelas[10];
    private int jumlahKelas = 0;
    //end of variable
    public Mahasiswa(String nama, String jenisKelamin, String noInduk){
        super(nama, jenisKelamin);
        this.noInduk = noInduk;
    }
    //end of Constructors

    public String getNoInduk() {
        return noInduk;
    }

    public void setNoInduk(String noInduk) {
        this.noInduk = noInduk;
    }

    public int getJumlahKelas() {
        return jumlahKelas;
    }
    
    //end of setter/getter
    
    public void addPilihan(Kelas pilihan) {
        if (jumlahKelas == 10){
            System.out.println("Jumlah kelas telah mencapai batas");
        }else{
            this.pilihan[jumlahKelas] = pilihan;
            jumlahKelas++;
        }
    }
    public void removePilihan(int id){
        pilihan[id]=null;
        for (int i=id; i < jumlahKelas; i++){
            pilihan[i]=pilihan[i+1];
        } 
        pilihan[jumlahKelas]=null;
    }
}
