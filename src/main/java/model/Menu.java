/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS
 */
public class Menu {
    protected int idMenu;
    protected String namaMenu;
    protected int harga;
    
    public Menu (int idMenu, String namaMenu, int harga){
        this.idMenu = idMenu;
        this.namaMenu = namaMenu;
        this.harga = harga;
    }
    
    public int getIdMenu(){
        return idMenu;
    }
    
    public String getNamaMenu(){
        return namaMenu;
    }
    
    public void setNamaMenu(String namaMenu){
        this.namaMenu = namaMenu;
    }
    
    public int getHarga(){
        return harga;
    } 
    
    public void setHarga(int harga){
        this.harga = harga;
    }
    
    public String getInfo() {
        return "[" + idMenu + "] " + namaMenu + " - Rp" + harga;
    }
}
