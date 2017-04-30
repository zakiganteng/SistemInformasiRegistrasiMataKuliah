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
public abstract class Orang implements Serializable {
    private String nama;
    private String id;
    
    public Orang(String nama, String id) {
        this.nama = nama;
        this.id = id;
    }
    
    public void setNama(String nama) {
        this.nama = nama;
    }
    public String getNama() {
        return nama;
    }
    public void setID(String id){
        this.id = id;
    }
    public String getID() {
        return id;
    }
    public abstract String display();
} 
