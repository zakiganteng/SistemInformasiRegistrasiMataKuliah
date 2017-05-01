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
public class Admin extends Orang implements Serializable {
    private String usernameAdmin;
    private String passwordAdmin;
	
	public Admin (String nama, String id) {
		super(nama,id);
	}
	
	public void setusernameAdmin (String usernameAdmin) {
		this.usernameAdmin = usernameAdmin;
	}
	
	public void setpasswordAdmin (String passwordAdmin) {
		this.passwordAdmin = passwordAdmin;
	}
	
	public String getpasswordAdmin () {
		return passwordAdmin;
	}

        public String getUsernameAdmin() {
            return usernameAdmin;
        }
        
        
        
    @Override
        public String display() {
            return ("Selamat datang Admin");
        }
	
}
