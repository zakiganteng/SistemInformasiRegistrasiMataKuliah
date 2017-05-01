/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Aplikasi;
import view.HomeAdmin;
import view.LoginAdmin;

/**
 *
 * @author ASUS
 */
public class ControllerLoginAdmin implements ActionListener{
    private LoginAdmin view;
    private Aplikasi app;

    public ControllerLoginAdmin() { 
        view = new LoginAdmin();
        app = new Aplikasi();
        view.setVisible(true);
        view.addListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        
        if (source.equals(view.getBtnLogin())) {
            if ((app.getAdminFromFile().getUsernameAdmin().equals(view.getUsername())) && 
                    (app.getAdminFromFile().getpasswordAdmin().equals(view.getPassword())) == true) {
                ControllerHomeAdmin cha = new ControllerHomeAdmin();
                view.dispose();
            }
            else {
                JOptionPane.showMessageDialog(null, "Username atau Password salah");
            }
        }
        
        else if (source.equals(view.getBtnBack())) {
            JOptionPane.showMessageDialog(null, "Thank you");
            System.exit(0);
        }
    }
}
