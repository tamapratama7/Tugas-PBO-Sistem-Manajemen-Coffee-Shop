/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS
 */
public class Minuman extends Menu {
    private String ukuran;
 
    public Minuman(int idMenu, String namaMenu, int harga, String ukuran) {
        super(idMenu, namaMenu, harga);
        this.ukuran = ukuran;
    }
 
    public String getUkuran() {
        return ukuran;
    }
 
    public void setUkuran(String ukuran) {
        this.ukuran = ukuran;
    }
    
    @Override
    public String getInfo() {
        return super.getInfo() + " | Kategori: Minuman | Ukuran: " + ukuran;
    }
}
