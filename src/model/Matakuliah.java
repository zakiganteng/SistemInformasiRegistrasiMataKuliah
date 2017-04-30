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
public class Matakuliah implements Serializable {
    	private String namaMK;
	
	public void setnamaMK (String namaMK) {
		this.namaMK = namaMK;
	}
	
	public String getnamaMK() {
		return namaMK;
	}
    
}
