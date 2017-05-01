/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Aplikasi {
    private ArrayList<Dosen> daftarDosen = new ArrayList<Dosen>();
    private ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<Mahasiswa>();
    private ArrayList<Kelas> daftarKelas = new ArrayList<Kelas>();
    private ArrayList<Matakuliah> daftarMatakuliah = new ArrayList<Matakuliah>();
    
    public void addDosen(Dosen d) {
        daftarDosen.add(d);
    } 
    
    public void addMahasiswa(Mahasiswa m) {
        daftarMahasiswa.add(m);
    } 
    
    public ArrayList<Kelas> addKelas(Kelas k) {
        ArrayList<Kelas> kelas = getListKelasFromFile();
        kelas.add(k);
        return kelas;
    } 
    
    public ArrayList<Matakuliah> addMatakuliah(Matakuliah mk) {
        ArrayList<Matakuliah> matakuliah = getListMatkulFromFile();
        matakuliah.add(mk);
        return matakuliah;
    } 
    
    public Dosen getDosen(int id) {
        return getListDosenFromFile().get(id);
    } 
    
    public Mahasiswa getMahasiswa(int id) {
        return getListMahasiswaFromFile().get(id);
    } 
    
    public Kelas getKelas(int id) {
        return getListKelasFromFile().get(id);
    } 
    
    public Matakuliah getMatakuliah(int id) {
        return getListMatkulFromFile().get(id);
    } 
    
    public void deleteDosen(int id) {
        daftarDosen.remove(id);
    } 
    
    public void deleteMahasiswa(int id) {
        daftarMahasiswa.remove(id);
    } 
    
    public void deleteKelas(int id) {
        daftarKelas.remove(id);
    } 
    
    public void deleteMatakuliah(int id) {
        daftarMatakuliah.remove(id);
    } 
    
    public void addMatkulToKelas(Kelas k, Matakuliah mk) {
        k.setMatakuliah(mk);
    } 
    
    public void addKelasToMahasiswa(Mahasiswa m, Kelas k) {
        m.addKelas(k);
    } 
    
    public void addDosenToKelas(Kelas k, Dosen d) {
        k.setDosen(d);
    } 
    
    public void removeKelasFromMahasiswa(Mahasiswa m, Kelas k) {
        String namaKelas = k.getNamaKelas();
        m.removeKelas(namaKelas);
    } 
    
    public ArrayList<Kelas> viewAllKelasByMahasiswa(Mahasiswa m) {
        return m.getAllKelas();
    } 
    
    public void viewAllNamaKelas() {
        for (int i = 0; i < getListKelasFromFile().size(); i++) {
            try {
                System.out.println((i+1) + ". " + getListKelasFromFile().get(i).getNamaKelas());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    } 
    
    public void viewAllKelas() {
        for (int i = 0; i < getListKelasFromFile().size(); i++) {
            System.out.println((i+1) + ". Nama Kelas : " + getListKelasFromFile().get(i).getNamaKelas());
            if ((getListKelasFromFile().get(i).getDosen()) != null) {
                System.out.println("   Nama Dosen : " + getListKelasFromFile().get(i).getDosen().getNama());
            }
            else {
                System.out.println("   Nama Dosen : ");
            }
            if ((getListKelasFromFile().get(i).getMatakuliah()) != null) {
                System.out.println("   Nama Matakuliah : " + getListKelasFromFile().get(i).getMatakuliah().getnamaMK());
            }
            else {
                System.out.println("   Nama Matakuliah : ");
            }
            System.out.println();
        }
        if (getListKelasFromFile().size() == 0) {
            System.out.println("Kelas Kosong");
        }
    } 
    
    public void viewAllMatkul() {
        for (int i = 0; i < getListMatkulFromFile().size(); i++) {
            System.out.println((i+1) + ". " + getListMatkulFromFile().get(i).getnamaMK());
        }
    } 
    
    public void viewAllDosen() {
        for (int i = 0; i < getListDosenFromFile().size(); i++) {
            System.out.println((i+1) + ". " + getListDosenFromFile().get(i).getNama());
        }
    } 
    
    /* FILE */
    
    public void createFile() {
        try {
            Mahasiswa mhs1 = new Mahasiswa("Zaki","1103130047","zakaria","zakaria",8,"Informatika");
            //Mahasiswa mhs2 = new Mahasiswa("y","130115","yy","passwordayy",4,"x");
            //Mahasiswa mhs3 = new Mahasiswa("x","130115","cc","passwordx",4,"Px");
            daftarMahasiswa.add(mhs1);
            //daftarMahasiswa.add(mhs2);
            //daftarMahasiswa.add(mhs3);
            
            Dosen dsn1 = new Dosen("Nami","6603105577");
            Dosen dsn2 = new Dosen("Zoro","6603107854");
            Dosen dsn3 = new Dosen("Sanji","6603106647");
            Dosen dsn4 = new Dosen("Usop","6603108899");
            Dosen dsn5 = new Dosen("Robin","6603107456");
            Dosen dsn6 = new Dosen("Franky","6603100346");
            Dosen dsn7 = new Dosen("Luffy","6603107645");
            Dosen dsn8 = new Dosen("Brook","66031055599");
            Dosen dsn9 = new Dosen("Chopper","6603105587");
            daftarDosen.add(dsn1);
            daftarDosen.add(dsn2);
            daftarDosen.add(dsn3);
            daftarDosen.add(dsn4);
            daftarDosen.add(dsn5);
            daftarDosen.add(dsn6);
            daftarDosen.add(dsn7);
            daftarDosen.add(dsn8);
            daftarDosen.add(dsn9);
            
            Admin admin = new Admin("Admin","ADM1");
            admin.setusernameAdmin("admin");
            admin.setpasswordAdmin("admin");
            
            FileOutputStream fos1 = new FileOutputStream("mahasiswa.txt");
            ObjectOutputStream obj1 = new ObjectOutputStream(fos1);

            FileOutputStream fos2 = new FileOutputStream("dosen.txt");
            ObjectOutputStream obj2 = new ObjectOutputStream(fos2);
            
            FileOutputStream fos3 = new FileOutputStream("admin.txt");
            ObjectOutputStream obj3 = new ObjectOutputStream(fos3);
            
            FileOutputStream fos4 = new FileOutputStream("kelas.txt");
            ObjectOutputStream obj4 = new ObjectOutputStream(fos4);
            
            FileOutputStream fos5 = new FileOutputStream("matakuliah.txt");
            ObjectOutputStream obj5 = new ObjectOutputStream(fos5);

            obj1.writeObject(daftarMahasiswa);
            obj2.writeObject(daftarDosen);
            obj3.writeObject(admin);
            obj4.writeObject(daftarKelas);
            obj5.writeObject(daftarMatakuliah);

            obj1.flush();
            obj2.flush();
            obj3.flush();
            obj4.flush();
            obj5.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    } 
    
    public Admin getAdminFromFile() {
        try {
            FileInputStream fis = new FileInputStream("admin.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            Admin adm = (Admin)ois.readObject();
            return adm;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    } 
    
    public ArrayList<Mahasiswa> getListMahasiswaFromFile() {
        try {
            FileInputStream fis = new FileInputStream("mahasiswa.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            ArrayList<Mahasiswa> m = (ArrayList<Mahasiswa>)ois.readObject();
            return m;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    } 
    
    public ArrayList<Dosen> getListDosenFromFile() {
        try {
            FileInputStream fis = new FileInputStream("dosen.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            
            ArrayList<Dosen> dosen = (ArrayList<Dosen>)ois.readObject();
            return dosen;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    } 
    
    public ArrayList<Kelas> getListKelasFromFile() {
        try {
            FileInputStream fis = new FileInputStream("kelas.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            
            ArrayList<Kelas> kelas = (ArrayList<Kelas>)ois.readObject();
            return kelas;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    } 
    
    public ArrayList<Matakuliah> getListMatkulFromFile() {
        try {
            FileInputStream fis = new FileInputStream("matakuliah.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            
            ArrayList<Matakuliah> matkul = (ArrayList<Matakuliah>)ois.readObject();
            return matkul;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    } 
    
    public void saveListMahasiswaToFile(ArrayList<Mahasiswa> mahasiswa) {
        try {
            FileOutputStream fos = new FileOutputStream("mahasiswa.txt", false);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(mahasiswa);
            oos.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    } 
    
    public void saveListKelasToFile(ArrayList<Kelas> kelas) {
        try {
            FileOutputStream fos = new FileOutputStream("kelas.txt", false);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(kelas);
            oos.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    } 
    
    public void saveListMatkulToFile(ArrayList<Matakuliah> matakuliah) {
        try {
            FileOutputStream fos = new FileOutputStream("matakuliah.txt", false);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(matakuliah);
            oos.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    } 
    
    public Mahasiswa getTrueMahasiswa (String username, String password) {
        for (int i = 0; i < getListMahasiswaFromFile().size(); i++) {
            if ((getListMahasiswaFromFile().get(i).getUsernameMhs().equals(username)) && 
                    getListMahasiswaFromFile().get(i).getPasswordMhs().equals(password)) {
                return getListMahasiswaFromFile().get(i);
            }
        }
        return null;
    } 
    
    public boolean isMahasiswaTrue(String username, String password) {
        for (int i = 0; i < getListMahasiswaFromFile().size(); i++) {
            if ((getListMahasiswaFromFile().get(i).getUsernameMhs().equals(username)) && 
                    getListMahasiswaFromFile().get(i).getPasswordMhs().equals(password)) {
                return true;
            }
        }
        return false;
    } 
    
    public boolean isDuplikatKelas(String namaKelas) {
        int total = 0;
        for (int i = 0; i < getListKelasFromFile().size(); i++) {
            if (getListKelasFromFile().get(i).getNamaKelas().equals(namaKelas)) {
                total++;
            }
        }
        if (total == 0) {
            return false;
        }
        else {
            return true;
        }
    } 
    
    public boolean isDuplikatMatkul(String namaMatkul) {
        int total = 0;
        for (int i = 0; i < getListMatkulFromFile().size(); i++) {
            if (getListMatkulFromFile().get(i).getnamaMK().equals(namaMatkul)) {
                total++;
            }
        }
        if (total == 0) {
            return false;
        }
        else {
            return true;
        }
    } 
    
    public void cekFile() {
        File file1 = new File("mahasiswa.txt");
        File file2 = new File("dosen.txt");
        File file3 = new File("admin.txt");
        File file4 = new File("kelas.txt");
        File file5 = new File("matakuliah.txt");
        if ((file1.exists()) && (file2.exists()) && (file3.exists()) && (file4.exists())  && (file5.exists())) {
            
        }
        else {
            createFile();
        }
    } 
    
    public void mainMenu() {
        cekFile();
        int pilihan1 = 1;
        while (pilihan1 != 0) {
            Scanner angka = new Scanner(System.in);
            Scanner huruf = new Scanner(System.in);
            
            System.out.println("                    APLIKASI REGISTRASI MATA KULIAH");
            System.out.println();
            System.out.println("1. Login Admin"); 
            System.out.println("2. Login Mahasiswa"); 
            System.out.println("0. Keluar Aplikasi");
            System.out.print("Pilih Menu : ");
            
            try {
                int menuAplikasi = angka.nextInt();
                String username;
                String password;
                switch (menuAplikasi) {
                    case 1 :
                        System.out.print("Masukkan Username Admin : ");
                        username = huruf.nextLine();
                        System.out.print("Masukkan Password Admin : ");
                        password = huruf.nextLine();
                        
                        if ((getAdminFromFile().getUsernameAdmin().equals(username)) &&
                                (getAdminFromFile().getpasswordAdmin().equals(password))) {
                            System.out.println("                    SELAMAT DATANG ADMIN");
                            int pilihan2 = 1;
                            
                            while (pilihan2 != 0) {
                                System.out.println("MENU ADMIN : ");
                                System.out.println("1. Tambah Kelas Baru");
                                System.out.println("2. Tambah Matakuliah Baru"); 
                                System.out.println("3. Tambah Matakuliah ke Kelas"); 
                                System.out.println("4. Tambah Dosen ke Kelas"); 
                                System.out.println("5. View Kelas"); 
                                System.out.println("0. Logout"); 
                                System.out.print("Masukkan Menu : ");
                                
                                try {
                                    int menuAdmin = angka.nextInt();
                                    switch (menuAdmin) {
                                        case 1 :
                                            System.out.print("Masukkan Nama Kelas : ");String namaKelas = huruf.nextLine();
                                            if ((isDuplikatKelas(namaKelas)) == false) {
                                                Kelas k = new Kelas(namaKelas);
                                                saveListKelasToFile(addKelas(k));
                                                System.out.println("Kelas Berhasil Ditambahkan");
                                                System.out.println();
                                            }
                                            else {
                                                System.out.println("Kelas Sudah Tersedia");
                                                System.out.println();
                                            }
                                            break;

                                        case 2 :
                                            System.out.print("Masukkan Nama Matakuliah : ");String namaMatkul = huruf.nextLine();
                                            if ((isDuplikatMatkul(namaMatkul)) == false) {
                                                Matakuliah matkul = new Matakuliah();
                                                matkul.setnamaMK(namaMatkul);
                                                saveListMatkulToFile(addMatakuliah(matkul));
                                                System.out.println("Matakuliah Berhasil Ditambahkan");
                                                System.out.println();
                                            }
                                            else {
                                                System.out.println("Matakuliah Sudah Tersedia");
                                                System.out.println();
                                            }
                                            break;

                                        case 3 :
                                            viewAllNamaKelas();
                                            System.out.print("Pilih Kelas : "); int kelasPilih = angka.nextInt();
                                            viewAllMatkul();
                                            System.out.print("Pilih Matakuliah : "); int matkulPilih = angka.nextInt();
                                            ArrayList<Kelas> kelas = getListKelasFromFile();
                                            kelas.get(kelasPilih-1).setMatakuliah(getMatakuliah(matkulPilih-1));
                                            saveListKelasToFile(kelas);
                                            System.out.println("Matakuliah Telah Berhasil Ditambahkan");
                                            System.out.println();
                                            break;

                                        case 4 :
                                            viewAllNamaKelas();
                                            System.out.print("Pilih Kelas : "); kelasPilih = angka.nextInt();
                                            viewAllDosen();
                                            System.out.print("Pilih Dosen : "); int dosenPilih = angka.nextInt();
                                            kelas = getListKelasFromFile();
                                            kelas.get(kelasPilih-1).setDosen(getDosen(dosenPilih-1));
                                            saveListKelasToFile(kelas);
                                            System.out.println("Dosen Telah Berhasil Ditambahkan");
                                            System.out.println();
                                            break;

                                        case 5 :
                                            viewAllKelas();
                                            System.out.println();
                                            break;
                                            
                                        case 0 :
                                            pilihan2 = 0;
                                            break;
                                            
                                        default :
                                            System.out.println("Menu tidak ada");
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.println("Menu Salah");
                                }
                            }
                        }
                        else {
                            System.out.println("USERNAME ATAU PASSWORD SALAH");
                        }
                        break;
                        
                    case 2 :
                        System.out.print("Masukkan Username Mahasiswa : ");
                        username = huruf.nextLine();
                        System.out.print("Masukkan Password Mahasiswa : ");
                        password = huruf.nextLine();
                        
                        if (isMahasiswaTrue(username, password) == true) {
                            Mahasiswa mahasiswa = getTrueMahasiswa(username, password);
                            System.out.println("                    Selamat Datang " + mahasiswa.getNama());
                            
                            int pilihan3 = 1;
                            
                            while (pilihan3 != 0) {
                                System.out.println("MENU MAHASISWA : ");
                                System.out.println("1. Tambah Kelas");
                                System.out.println("2. Hapus Kelas");
                                System.out.println("3. View Kelas Yang Telah Diambil");
                                System.out.println("0. Logout");
                                System.out.print("Masukkan Pilihan : "); int menu = angka.nextInt();
                                
                                switch (menu) {
                                    case 1 : 
                                        viewAllKelas();
                                        System.out.print("Pilih Kelas : "); int pilihKelas = angka.nextInt();
                                        
                                        int index = 0;
                                        for (int i = 0; i < getListMahasiswaFromFile().size(); i++) {
                                            if ((getListMahasiswaFromFile().get(i).getUsernameMhs().equals(username)) && 
                                                    getListMahasiswaFromFile().get(i).getPasswordMhs().equals(password)) {
                                                index = i;
                                            }
                                        }
                                        ArrayList<Mahasiswa> mhs = getListMahasiswaFromFile();
                                        
                                        String namaKelas = getListKelasFromFile().get(pilihKelas-1).getNamaKelas();
                                        boolean cek = true;
                                        for (int i = 0; i < mhs.get(index).getAllKelas().size(); i++) {
                                            if (mhs.get(index).getAllKelas().get(i).getNamaKelas().equals(namaKelas)) {
                                                cek = false;
                                            }
                                        }
                                        
                                        if (cek == true) {
                                            mhs.get(index).addKelas(getKelas(pilihKelas-1));
                                            saveListMahasiswaToFile(mhs);
                                            System.out.println("Kelas Berhasil Ditambahkan");
                                            System.out.println();
                                            break;
                                        }
                                        else {
                                            System.out.println("Kelas Sudah Diambil");
                                            System.out.println();
                                        }
                                        break;
                                        
                                    case 2 :
                                        ArrayList<Kelas> kelas = viewAllKelasByMahasiswa(getTrueMahasiswa(username, password));
                                        for (int i = 0; i < kelas.size(); i++) {
                                            System.out.println((i+1) + ". Nama Kelas : " + kelas.get(i).getNamaKelas());
                                            if (kelas.get(i).getDosen() != null) {
                                                System.out.println("   Nama Dosen : " + kelas.get(i).getDosen().getNama());
                                            }
                                            else {
                                                System.out.println("   Nama Dosen : ");
                                            }
                                            if (kelas.get(i).getMatakuliah() != null) {
                                                System.out.println("   Nama Matakuliah : " + kelas.get(i).getMatakuliah().getnamaMK());
                                            }
                                            else {
                                                System.out.println("   Nama Matakuliah : ");
                                            }
                                            System.out.println();
                                        }
                                        
                                        System.out.print("Pilih Kelas Yang Akan Dihapus : "); pilihKelas = angka.nextInt();
                                        
                                        index = 0;
                                        for (int i = 0; i < getListMahasiswaFromFile().size(); i++) {
                                            if ((getListMahasiswaFromFile().get(i).getUsernameMhs().equals(username)) && 
                                                    getListMahasiswaFromFile().get(i).getPasswordMhs().equals(password)) {
                                                index = i;
                                            }
                                        }
                                        mhs = getListMahasiswaFromFile();
                                        
                                        namaKelas = getListKelasFromFile().get(pilihKelas-1).getNamaKelas();
                                        
                                        cek = false;
                                        for (int i = 0; i < mhs.get(index).getAllKelas().size(); i++) {
                                            if (mhs.get(index).getAllKelas().get(i).getNamaKelas().equals(namaKelas)) {
                                                cek = true;
                                            }
                                        }
                                        
                                        if (cek == true) {
                                            mhs.get(index).removeKelas(namaKelas);
                                            saveListMahasiswaToFile(mhs);
                                            System.out.println("Kelas Berhasil Dihapus");
                                            break;
                                        }
                                        else {
                                            System.out.println("Kelas Tidak Ada");
                                        }
                                        System.out.println();
                                        break;
                                        
                                    case 3 : 
                                        ArrayList<Kelas> k = viewAllKelasByMahasiswa(getTrueMahasiswa(username, password));
                                        for (int i = 0; i < k.size(); i++) {
                                            System.out.println((i+1) + ". Nama Kelas : " + k.get(i).getNamaKelas());
                                            if (k.get(i).getDosen() != null) {
                                                System.out.println("   Nama Dosen : " + k.get(i).getDosen().getNama());
                                            }
                                            else {
                                                System.out.println("   Nama Dosen : ");
                                            }
                                            if (k.get(i).getMatakuliah() != null) {
                                                System.out.println("   Nama Matakuliah : " + k.get(i).getMatakuliah().getnamaMK());
                                            }
                                            else {
                                                System.out.println("   Nama Matakuliah : ");
                                            }
                                            System.out.println();
                                        }
                                        if (k.size() == 0) {
                                            System.out.println("Kelas Kosong");
                                        }
                                        System.out.println();
                                        break;
                                        
                                    case 0 :
                                        pilihan3 = 0;
                                        break;
                                }
                            }
                        }
                        else {
                            System.out.println("USERNAME ATAU PASSWORD SALAH");
                        }
                        break;
                        
                    case 0 :
                        System.out.println("TERIMA KASIH");
                        pilihan1 = 0;
                        break;
                        
                    default :
                        System.out.println("Menu tidak ada");
                }
            } catch (InputMismatchException e) {
                System.out.println("Menu Salah");
            }
        }
    }    
}