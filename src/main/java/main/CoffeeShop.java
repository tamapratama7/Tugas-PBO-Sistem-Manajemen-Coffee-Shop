/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package main;
import java.util.Scanner;
import java.util.ArrayList;
import model.Menu;
import model.Makanan;
import model.Minuman;
import model.Pelanggan;
import service.MenuService;
import service.PelangganService;

/**
 *
 * @author ASUS
 */
public class CoffeeShop {
    static Scanner input = new Scanner(System.in);
    static MenuService menuService = new MenuService();
    static PelangganService pelangganService = new PelangganService();
        
    public static void main(String[] args){
        int pilihan;
        do{
            System.out.println("\n===== SISTEM MANAJEMEN COFFEE SHOP =====");
            System.out.println("1. Kelola Menu");
            System.out.println("2. Kelola Pelanggan");
            System.out.println("0. Keluar");
            System.out.print("Pilih Menu: ");
            pilihan = bacaAngka();
                
            switch (pilihan){
                case 1:
                    menuMenu();
                    break;
                case 2:
                    menuPelanggan();
                    break;
                case 0:
                    System.out.println("Terima Kasih!!!");
                    break;
                default:
                    System.out.println("Pilihan Tidak Valid!!!!!");
                    break;
            }
        }while (pilihan != 0);
    }
        
    static void menuMenu(){
        int pilihan;
        do{
            System.out.println("\n --- Kelola Menu (Makanan & Minuman) ---");
            System.out.println("1. Tambah Menu");
            System.out.println("2. Lihat Semua Menu");
            System.out.println("3. Update Menu");
            System.out.println("4. Hapus Menu");
            System.out.println("0. Kembali");
            System.out.println("pilih: ");
            pilihan = bacaAngka();
                
            switch (pilihan){
                case 1:
                    tambahMenu();
                    break;
                case 2:
                    tampilkanMenu();
                    break;
                case 3:
                    updateMenu();
                    break;
                case 4:
                    hapusMenu();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
                    break;    
            }
        }while (pilihan != 0);
    }
        
    static void tambahMenu() {
        System.out.println("\nPilih kategori menu:");
        System.out.println("1. Makanan");
        System.out.println("2. Minuman");
        System.out.print("Pilih: ");
        int kategori = bacaAngka();

        if (kategori != 1 && kategori != 2) {
            System.out.println("Kategori tidak valid, menu batal ditambahkan.");
            return;
        }

        System.out.print("ID menu: ");
        int id = bacaAngka();
        if (menuService.cariMenu(id) != null) {
            System.out.println("ID " + id + " sudah dipakai menu lain, menu batal ditambahkan.");
            return;
        }
        
        
        System.out.print("Nama menu: ");
        String nama = input.nextLine();
        System.out.print("Harga: ");
        int harga = bacaAngka();

        if (kategori == 1){
            System.out.print("Jenis makanan (Berat/Ringan/Snack, dsb): ");
            String jenis = input.nextLine();
            menuService.tambahMakanan(id, nama, harga, jenis);
            System.out.println("Makanan Berhasil Ditambahkan!!");
        } else {
            System.out.print("Ukuran (Small/Medium/Large): ");
            String ukuran = input.nextLine();
            menuService.tambahMinuman(id, nama, harga, ukuran);
            System.out.println("Minuman Berhasil Ditambahkan!!");
        }

    }
        
    static void tampilkanMenu(){
        System.out.println("\n --- Daftar Menu ---");
        ArrayList<Menu> daftarMenu = menuService.getDaftarMenu();
        if (daftarMenu.size() == 0){
            System.out.println("Belum Ada Menu.");
            return;
        }

        for (Menu m : daftarMenu){
            System.out.println(m.getInfo());
        }
    }
        
    static void updateMenu(){
        tampilkanMenu();

        System.out.print("\nMasukkan ID menu yang ingin diupdate: ");
        int id = bacaAngka();
        Menu menuDicari = menuService.cariMenu(id);

        if(menuDicari == null){
            System.out.println("Menu dengan ID tersebut tidak ditemukan!!");
            return;
        }

        System.out.print("Nama Baru (" + menuDicari.getNamaMenu() + "): ");
        String nama = input.nextLine();
        if (!nama.isBlank()) menuDicari.setNamaMenu(nama);

        System.out.print("Harga baru (" + menuDicari.getHarga() + "): ");
        String hargaStr = input.nextLine();
        if (!hargaStr.isBlank()) menuDicari.setHarga(Integer.parseInt(hargaStr));

        if (menuDicari instanceof Makanan makanan) {
            System.out.print("Jenis makanan baru (" + makanan.getJenisMakanan() + "): ");
            String jenis = input.nextLine();
            if (!jenis.isBlank()) makanan.setJenisMakanan(jenis);
        } else if (menuDicari instanceof Minuman minuman) {
            System.out.print("Ukuran baru (" + minuman.getUkuran() + "): ");
            String ukuran = input.nextLine();
            if (!ukuran.isBlank()) minuman.setUkuran(ukuran);
        }

        System.out.println("Menu berhasil diupdate!");
    }
        
        
    static void hapusMenu() {
        tampilkanMenu();

        System.out.print("\nMasukkan ID menu yang ingin dihapus: ");
        int id = bacaAngka();
        Menu menuDicari = menuService.cariMenu(id);

        if (menuDicari == null) {
            System.out.println("Menu dengan ID tersebut tidak ditemukan!");
        } else {
            menuService.hapusMenu(menuDicari);
            System.out.println("Menu berhasil dihapus!");
        }
    }
        
    static void menuPelanggan() {
        int pilihan;
        do {
            System.out.println("\n--- KELOLA PELANGGAN ---");
            System.out.println("1. Tambah Pelanggan");
            System.out.println("2. Lihat Semua Pelanggan");
            System.out.println("3. Update Pelanggan");
            System.out.println("4. Hapus Pelanggan");
            System.out.println("0. Kembali");
            System.out.print("Pilih: ");
            pilihan = bacaAngka();

            switch (pilihan) {
                case 1:
                    tambahPelanggan();
                    break;
                case 2:
                    tampilkanPelanggan();
                    break;
                case 3:
                    updatePelanggan();
                    break;
                case 4:
                    hapusPelanggan();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
                    break;
            }
        } while (pilihan != 0);
    }

    static void tambahPelanggan() {
        System.out.print("ID pelanggan: ");
        int id = bacaAngka();
        if (pelangganService.cariPelanggan(id) != null) {
            System.out.println("ID " + id + " sudah dipakai pelanggan lain, batal ditambahkan.");
            return;
        }

        System.out.print("Nama pelanggan: ");
        String nama = input.nextLine();
        pelangganService.tambahPelanggan(id, nama);
        System.out.println("Pelanggan berhasil ditambahkan!");
    }

    static void tampilkanPelanggan() {
        System.out.println("\n--- DAFTAR PELANGGAN ---");
        ArrayList<Pelanggan> daftarPelanggan = pelangganService.getDaftarPelanggan();
        if (daftarPelanggan.isEmpty()) {
            System.out.println("Belum ada pelanggan.");
            return;
        }
        for (Pelanggan p : daftarPelanggan) {
            System.out.println(p.getInfo());
        }
    }

    static void updatePelanggan() {
        tampilkanPelanggan();

        System.out.print("\nMasukkan ID pelanggan yang ingin diupdate: ");
        int id = bacaAngka();
        Pelanggan pelangganDicari = pelangganService.cariPelanggan(id);

        if (pelangganDicari == null) {
            System.out.println("Pelanggan dengan ID tersebut tidak ditemukan!");
            return;
        }

        System.out.print("Nama baru (" + pelangganDicari.getNamaPelanggan() + "): ");
        String nama = input.nextLine();
        if (!nama.isBlank()) pelangganDicari.setNamaPelanggan(nama);

        System.out.println("Data pelanggan berhasil diupdate!");
    }
        
    static void hapusPelanggan() {
        tampilkanPelanggan();

        System.out.print("\nMasukkan ID pelanggan yang ingin dihapus: ");
        int id = bacaAngka();
        Pelanggan pelangganDicari = pelangganService.cariPelanggan(id);

        if (pelangganDicari == null) {
            System.out.println("Pelanggan dengan ID tersebut tidak ditemukan!");
        } else {
            pelangganService.hapusPelanggan(pelangganDicari);
            System.out.println("Pelanggan berhasil dihapus!");
        }
    }
        
    static int bacaAngka(){
        while (true){
            try {
                return Integer.parseInt(input.nextLine().trim());
            } catch (NumberFormatException e){
                System.out.print("Masukkan angka yang valid: ");
            }
        }
    }  
}
