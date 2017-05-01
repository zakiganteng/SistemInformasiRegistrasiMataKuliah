/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package driver;

import controller.ControllerLoginMahasiswa;
import java.io.IOException;
import model.Aplikasi;

/**
 *
 * @author ASUS
 */
public class DriverGUIMahasiswa {
    public static void main(String[] args) throws IOException {
        Aplikasi apps = new Aplikasi();
        ControllerLoginMahasiswa login = new ControllerLoginMahasiswa();
        apps.cekFile();
    }
}
