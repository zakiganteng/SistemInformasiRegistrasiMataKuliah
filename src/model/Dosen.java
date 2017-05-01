/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author ASUS
 */
public class Dosen extends Orang implements Serializable {
    public Dosen(String nama, String id) {
        super(nama,id);
    }
    @Override
    public String display() {
        return("Nama: "+getNama()+"\n"+"ID Dosen: "+getID());
    }
}
