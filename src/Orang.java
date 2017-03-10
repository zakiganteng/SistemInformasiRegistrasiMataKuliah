/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class Orang {
    private String nama;
    private String jenisKelamin;
    //end of variable
    Orang(String nama, String jenisKelamin){
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
    }
    //end of construcktor

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }
    //end of setter/getter
}
