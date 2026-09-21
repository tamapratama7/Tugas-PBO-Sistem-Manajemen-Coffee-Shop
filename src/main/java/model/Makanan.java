/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS
 */
public class Makanan extends Menu{
    private String jenisMakanan;
    
    public Makanan (int idMenu, String namaMenu, int harga, String jenisMakanan){
        super(idMenu, namaMenu, harga);
        this.jenisMakanan = jenisMakanan;
    }
    
    public String getJenisMakanan(){
        return jenisMakanan;
    }
    
    public void setJenisMakanan(String jenisMakanan){
        this.jenisMakanan = jenisMakanan;
    }
    
    @Override
    public String getInfo() {
        return super.getInfo() + " | Kategori: Makanan | Jenis: " + jenisMakanan;
    }
}
