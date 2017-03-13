
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class Aplikasi {
    Scanner angka = new Scanner(System.in);
    Scanner sc = new Scanner(System.in);
    //scanner
    private Dosen[] daftarDosen = new Dosen[100];
    private Mahasiswa[] daftarMahasiswa = new Mahasiswa[100];
    private Kelas[] daftarKelas = new Kelas[100];
    private MataKuliah[] daftarMataKuliah = new MataKuliah[100];
    private int jumlahDosen=0;
    private int jumlahMahasiswa=0;
    private int jumlahKelas=0;
    private int jumlahMataKuliah=0;
    private int idMahasiswa=0;
    //end of variable
    public void addDosen(Dosen dosen){
        daftarDosen[jumlahDosen] = dosen;
        jumlahDosen++;
    }
    public Dosen getDosen(int id){
        return daftarDosen[id];
    }
    public void deleteDosen(int id){
        daftarDosen[id] = null;
        for(int i = id; i<jumlahDosen;i++){
            daftarDosen[id] = daftarDosen[id+1];
        }
        daftarDosen[jumlahDosen] = null;
        jumlahMahasiswa = jumlahMahasiswa - 1;
    }
    //end of dosen
    public void addMahasiswa(Mahasiswa mahasiswa){
        daftarMahasiswa[jumlahMahasiswa] = mahasiswa;
        jumlahMahasiswa++;
    }
    public Mahasiswa getMahasiswa(int id){
        return daftarMahasiswa[id];
    }
    public void deleteMahasiswa(int id){
        daftarMahasiswa[id] = null;
        for(int i = id; i<jumlahMahasiswa;i++){
            daftarMahasiswa[id] = daftarMahasiswa[id+1];
        }
        daftarMahasiswa[jumlahMahasiswa] = null;
        jumlahMahasiswa = jumlahMahasiswa - 1;
    }

    public int getIdMahasiswa() {
        return idMahasiswa;
    }

    public void setIdMahasiswa(int idMahasiswa) {
        this.idMahasiswa = idMahasiswa;
    }
    //end of Mahasiswa
    public void addKelas(Kelas kelas){
        daftarKelas[jumlahKelas] = kelas;
        jumlahKelas++;
    }
    public Kelas getKelas(int id){
        return daftarKelas[id];
    }
    public void deleteKelas(int id){
        daftarKelas[id] = null;
        for(int i = id; i<jumlahKelas;i++){
            daftarKelas[id] = daftarKelas[id+1];
        }
        daftarKelas[jumlahKelas] = null;
        jumlahMahasiswa = jumlahMahasiswa - 1;
    }
    //end of Kelas
    public void addMataKuliah(MataKuliah mataKuliah){
        daftarMataKuliah[jumlahMataKuliah] = mataKuliah;
        jumlahMataKuliah++;
    }
    public MataKuliah getMataKuliah(int id){
        return daftarMataKuliah[id];
    }
    public void deleteMataKuliah(int id){
        daftarMataKuliah[id] = null;
        for(int i = id; i<jumlahMataKuliah;i++){
            daftarMataKuliah[id] = daftarMataKuliah[id+1];
        }
        daftarMataKuliah[jumlahMataKuliah] = null;
        jumlahMahasiswa = jumlahMahasiswa - 1;
    }
    //end of MataKuliah
    public void menuTambahMahasiswa(){
        System.out.println("==================================================");
        System.out.print("Masukkan Nama Mahasiswa: ");
        String nama = sc.nextLine();
        System.out.print("Masukkan Jenis Kelamin Mahasiswa: ");
        String jenisKelamin = sc.nextLine();
        System.out.print("Masukkan NIM: ");
        String NIM = sc.nextLine();
        Mahasiswa m = new Mahasiswa(nama,jenisKelamin,NIM);
        addMahasiswa(m);
        System.out.println("Data Mahasiswa Berhasil Direkam.");
        menuTambahAdmin();
    }
    public void menuHapusMahasiswa(){
        System.out.println("==================================================");
        System.out.println("List Mahasiswa:");
        for(int i = 0; i < jumlahMahasiswa;i++){
            System.out.println("No."+i+" "+daftarMahasiswa[i].getNama());
        }
        int id = angka.nextInt();
        System.out.print("Masukkan no Mahasiswa: ");
        deleteMahasiswa(id);
        System.out.println("Data Mahasiswa Berhasil Dihapus.");
        menuHapusAdmin();
    }
    public void menuTambahKelasMahasiswa(){
        System.out.println("==================================================");
        System.out.println("Tambah Kelas Mahasiswa:");
        System.out.println("List Kelas:");
        for(int i = 0; i < jumlahKelas;i++){
            System.out.println("No."+i+" "+daftarKelas[i].getNamaKelas());
        }
        System.out.print("Masukkan No Kelas: ");
        int no = sc.nextInt();
        daftarMahasiswa[getIdMahasiswa()].addPilihan(daftarKelas[no]);
        
        System.out.println("Data Kelas Mahasiswa Berhasil Direkam.");
        menuMahasiswa();
    }
    public void menuHapusKelasMahasiswa(){
        System.out.println("==================================================");
        System.out.println("Hapus Kelas Mahasiswa");
        System.out.println("List Kelas:");
        for(int i = 0; i < daftarMahasiswa[getIdMahasiswa()].getJumlahKelas();i++){
            System.out.println("No."+i+" "+daftarMahasiswa[getIdMahasiswa()].getKelas(i).getNamaKelas());
        }
        System.out.print("Masukkan No Kelas: ");
        int no = sc.nextInt();
        daftarMahasiswa[getIdMahasiswa()].removePilihan(no);
        
        System.out.println("Data Kelas Mahasiswa Berhasil Dihapus.");
        menuMahasiswa();
    }
    public void loginMahasiswa(){
        System.out.println("==================================================");
        System.out.println("Login Mahasiswa");
        System.out.println("Masuk Sebagai");
        System.out.println("List Mahasiswa:");
        for(int i = 0; i < jumlahMahasiswa;i++){
            System.out.println("No."+i+" "+daftarMahasiswa[i]);
        }
        System.out.print("Masukkan No Mahasiswa: ");
        int no = sc.nextInt();
        setIdMahasiswa(no);
        menuMahasiswa();
    }
    public void menuMahasiswa(){
        System.out.println("==================================================");
        System.out.println("Menu Mahasiswa: ");
        System.out.println("    1. Tambah Kelas");
        System.out.println("    2. Hapus Kelas");
        System.out.println("    3. Exit");
        System.out.print("Masukkan no: ");
        int id = angka.nextInt();
        if (id == 1){
            menuTambahKelasMahasiswa();
        }
        else if(id == 2){
            menuHapusKelasMahasiswa();
        }else if(id ==3){
            mainMenu();
        }
        else{
            System.out.println("Maaf angka yang dimasukkan salah");
            loginAdmin();
        }
    }
    //end of Menu Mahasiswa
    public void menuTambahDosen(){
        System.out.println("==================================================");
        System.out.print("Masukkan Nama Dosen: ");
        String nama = sc.nextLine();
        System.out.print("Masukkan Jenis Kelamin Dosen: ");
        String jenisKelamin = sc.nextLine();
        System.out.print("Masukkan NIP: ");
        String NIP = sc.nextLine();
        Dosen d = new Dosen(nama,jenisKelamin,NIP);
        addDosen(d) ;
        System.out.println("Data Dosen Berhasil Direkam.");
        menuTambahAdmin();
    }
    public void menuHapusDosen(){
        System.out.println("==================================================");
        System.out.println("List Dosen:");
        for(int i = 0; i < jumlahDosen;i++){
            System.out.println("No."+i+" "+daftarDosen[i].getNama());
        }
        int id = angka.nextInt();
        System.out.print("Masukkan no Dosen: ");
        deleteDosen(id);
        System.out.println("Data Dosen Berhasil Dihapus.");
        menuHapusAdmin();
    }
    //end of Menu Dosen
    
    public void menuTambahKelas(){
        System.out.println("==================================================");
        MataKuliah mataKuliah;
        Dosen dosen;
        System.out.print("Masukkan Nama Kelas: ");
        String nama = sc.nextLine();
        System.out.println("List Mata Kuliah:");
        for(int i=0;i<jumlahMataKuliah;i++){
            System.out.println("No."+i+" "+daftarMataKuliah[i].getNamaMatakuliah());
        }
        System.out.print("Masukkan no Mata Kuliah: ");
        int mataKuliahNo = sc.nextInt();
        System.out.println("List Dosen:");
        for(int i=0;i <jumlahDosen;i++){
            System.out.println("No."+i+" "+daftarDosen[i].getNama());
        }
        System.out.print("Masukkan No: ");
        int dosenNo = sc.nextInt();
        Kelas k = new Kelas(daftarMataKuliah[mataKuliahNo],nama,daftarDosen[dosenNo]);
        addKelas(k);
        System.out.println("Data Kelas Berhasil Direkam.");
        menuTambahAdmin();
    }
    public void menuHapusKelas(){
        System.out.println("==================================================");
        System.out.println("List Kelas:");
        for(int i = 0; i< jumlahKelas;i++){
            System.out.println("No."+i+" "+daftarKelas[i].getNamaKelas());
        }
        int id = angka.nextInt();
        System.out.print("Masukkan no Kelas: ");
        deleteKelas(id);
        System.out.println("Data Kelas Berhasil Dihapus.");
        menuHapusAdmin();
    }
    //end of Kelas
    public void menuTambahMataKuliah(){
        System.out.println("==================================================");
        System.out.print("Masukkan Nama MataKuliah: ");
        String nama = sc.nextLine();
        MataKuliah m = new MataKuliah(nama);
        addMataKuliah(m);
        System.out.println("Data MataKuliah Berhasil Direkam.");
        menuTambahAdmin();
    }
    public void menuHapusMataKuliah(){
        System.out.println("==================================================");
        System.out.println("List MataKuliah:");
        for(int i = 0; i< jumlahMataKuliah;i++){
            System.out.println("No."+i+" "+daftarMataKuliah[i]);
        }
        int id = angka.nextInt();
        System.out.print("Masukkan no MataKuliah: ");
        deleteMataKuliah(id);
        System.out.println("Data MataKuliah Berhasil Dihapus.");
        menuHapusAdmin();
    }
    //end of Menu Mata Kuliah
    public void loginAdmin(){
        System.out.println("==================================================");
        System.out.println("Menu: ");
        System.out.println("    1. Tambah");
        System.out.println("    2. Hapus");
        System.out.println("    3. Exit");
        System.out.print("Masukkan no: ");
        int id = angka.nextInt();
        if (id == 1){
            menuTambahAdmin();
        }
        else if(id == 2){
            menuHapusAdmin();
        }else if(id ==3){
            mainMenu();
        }
        else{
            System.out.println("Maaf angka yang dimasukkan salah");
            loginAdmin();
        }
    }
    public void menuTambahAdmin(){
        System.out.println("==================================================");
        System.out.println("Menu Tambah: ");
        System.out.println("    1. Mahasiswa");
        System.out.println("    2. Dosen");
        System.out.println("    3. Kelas");
        System.out.println("    4. Mata Kuliah");
        System.out.println("    5. Exit");
        System.out.print("Masukkan no: ");
        int id = angka.nextInt();
        switch(id){
            case 1:
                menuTambahMahasiswa();
                break;
            case 2:
                menuTambahDosen();
                break;
            case 3:
                menuTambahKelas();
                break;
            case 4:
                menuTambahMataKuliah();
                break;
            case 5:
                loginAdmin();
                break;
            default:
                System.out.println("Masukkan Salah");
                menuTambahAdmin();
                break;
        }
    }
    public void menuHapusAdmin(){
        System.out.println("==================================================");
        System.out.println("Menu Hapus: ");
        System.out.println("    1. Mahasiswa");
        System.out.println("    2. Dosen");
        System.out.println("    3. Kelas");
        System.out.println("    4. Mata Kuliah");
        System.out.println("    5. Exit");
        System.out.print("Masukkan no: ");
        int id = angka.nextInt();
        switch(id){
            case 1:
                menuHapusMahasiswa();
                break;
            case 2:
                menuHapusDosen();
                break;
            case 3:
                menuHapusKelas();
                break;
            case 4:
                menuHapusMataKuliah();
                break;
            case 5:
                loginAdmin();
                break;
            default:
                System.out.println("Masukkan Salah");
                menuHapusAdmin();
                break;
        }
    }
    //end of Menu Admin
    public void mainMenu(){
        System.out.println("==================================================");
        System.out.println("Main Menu: ");
        System.out.println("Masuk Sebagai: ");
        System.out.println("    1. Admin");
        System.out.println("    2. Mahasiswa");
        System.out.println("    3. Exit");
        System.out.print("Masukkan no: ");
        int id = angka.nextInt();
        if (id == 1){
            loginAdmin();
        }
        else if(id == 2){
            loginMahasiswa();
        }
        else if(id == 3){
            return;
        }
        else{
            System.out.println("Maaf angka yang dimasukkan salah");
            mainMenu();
        }
    }
    //end of main menu
}
