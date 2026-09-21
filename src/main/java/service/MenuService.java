/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import java.util.ArrayList;
import model.Makanan;
import model.Menu;
import model.Minuman;

/**
 *
 * @author ASUS
 */
public class MenuService {
    private ArrayList<Menu> daftarMenu = new ArrayList<>();
    
    public void tambahMakanan(int id, String nama, int harga, String jenis){
        daftarMenu.add(new Makanan(id, nama, harga, jenis));
    }
    
    public void tambahMinuman(int id, String nama, int harga, String ukuran){
        daftarMenu.add(new Minuman(id, nama, harga, ukuran));
    }
    
    public ArrayList<Menu> getDaftarMenu() {
        return daftarMenu;
    }
 
    public Menu cariMenu(int id) {
        for (Menu m : daftarMenu) {
            if (m.getIdMenu() == id) return m;
        }
        return null;
    }
    
    public void hapusMenu(Menu m) {
        daftarMenu.remove(m);
    }
}
