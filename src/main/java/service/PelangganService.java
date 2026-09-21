/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import java.util.ArrayList;
import model.Pelanggan;

/**
 *
 * @author ASUS
 */
public class PelangganService {
    private ArrayList<Pelanggan> daftarPelanggan = new ArrayList<>();
    
    public void tambahPelanggan (int id, String nama){
        daftarPelanggan.add(new Pelanggan(id, nama));
    }
    
    public ArrayList<Pelanggan> getDaftarPelanggan() {
        return daftarPelanggan;
    }
 
    public Pelanggan cariPelanggan(int id) {
        for (Pelanggan p : daftarPelanggan) {
            if (p.getIdPelanggan() == id) return p;
        }
        return null;
    }
 
    public void hapusPelanggan(Pelanggan p) {
        daftarPelanggan.remove(p);
    }
}
