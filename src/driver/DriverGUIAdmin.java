/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package driver;
import controller.ControllerLoginAdmin;
import java.io.IOException;
import model.Aplikasi;

/**
 *
 * @author ASUS
 */
public class DriverGUIAdmin {
    public static void main(String[] args) throws IOException {
        Aplikasi apps = new Aplikasi();
        ControllerLoginAdmin login = new ControllerLoginAdmin();
        apps.cekFile();
    }
}
