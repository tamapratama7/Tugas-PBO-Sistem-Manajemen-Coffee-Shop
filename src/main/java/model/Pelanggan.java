/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS
 */
public class Pelanggan {
    private int idPelanggan;
    private String namaPelanggan;
 
    public Pelanggan(int idPelanggan, String namaPelanggan) {
        this.idPelanggan = idPelanggan;
        this.namaPelanggan = namaPelanggan;
    }
 
    public int getIdPelanggan() {
        return idPelanggan;
    }
 
    public String getNamaPelanggan() {
        return namaPelanggan;
    }
 
    public void setNamaPelanggan(String namaPelanggan) {
        this.namaPelanggan = namaPelanggan;
    }
    
    public String getInfo() {
        return "[" + idPelanggan + "] " + namaPelanggan;
    }
}
