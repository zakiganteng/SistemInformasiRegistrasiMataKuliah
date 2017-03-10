/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class Dosen extends Orang{
    private String noInduk;
    // end of variable
    public Dosen(String nama, String jenisKelamin, String noInduk){
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
    
    //end of setter/getter
}
