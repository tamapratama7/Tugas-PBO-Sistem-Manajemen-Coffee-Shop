# Sistem Manajemen Coffee Shop

**Nama:** Noor Hamsyah Pratama  
**NIM:** 2509116046  
**Mata Kuliah:** Pemograman Berorientasi Objek  

---

## 1. Deskripsi Studi Kasus  

Program ini adalah aplikasi **CLI (Command Line Interface)** berbasis Java untuk mengelola data **menu** (makanan dan minuman) dan **pelanggan** pada sebuah coffee shop. Program menerapkan prinsip-prinsip OOP: **inheritance**, **encapsulation**, dan **polymorphism**, serta mendukung operasi **CRUD** (Create, Read, Update, Delete) untuk kedua entitas.

**Fitur utama:**
- Kelola Menu: tambah, lihat, update, hapus (Makanan dan Minuman)
- Kelola Pelanggan: tambah, lihat, update, hapus
- Validasi ID agar tidak ada data duplikat
- ID menu dan ID pelanggan diinput manual oleh pengguna

---

## 2. Diagram Kelas / Hierarki

```mermaid
classDiagram
    class Menu {
        #int idMenu
        #String namaMenu
        #int harga
        +getIdMenu() int
        +getNamaMenu() String
        +setNamaMenu(String)
        +getHarga() int
        +setHarga(int)
        +getInfo() String
    }

    class Makanan {
        -String jenisMakanan
        +getJenisMakanan() String
        +setJenisMakanan(String)
        +getInfo() String
    }

    class Minuman {
        -String ukuran
        +getUkuran() String
        +setUkuran(String)
        +getInfo() String
    }

    class Pelanggan {
        -int idPelanggan
        -String namaPelanggan
        +getIdPelanggan() int
        +getNamaPelanggan() String
        +setNamaPelanggan(String)
        +getInfo() String
    }

    class MenuService {
        -ArrayList~Menu~ daftarMenu
        +tambahMakanan(...)
        +tambahMinuman(...)
        +getDaftarMenu() ArrayList~Menu~
        +cariMenu(int) Menu
        +hapusMenu(Menu)
    }

    class PelangganService {
        -ArrayList~Pelanggan~ daftarPelanggan
        +tambahPelanggan(int, String)
        +getDaftarPelanggan() ArrayList~Pelanggan~
        +cariPelanggan(int) Pelanggan
        +hapusPelanggan(Pelanggan)
    }

    class CoffeeShop {
        +main(String[])
    }

    Menu <|-- Makanan : extends
    Menu <|-- Minuman : extends
    MenuService --> Menu : mengelola
    PelangganService --> Pelanggan : mengelola
    CoffeeShop --> MenuService : menggunakan
    CoffeeShop --> PelangganService : menggunakan
```

**Struktur package:**

coffeeshop/  
├── model/  
│   ├── Menu.java          (superclass)  
│   ├── Makanan.java       (subclass dari Menu)  
│   ├── Minuman.java       (subclass dari Menu)  
│   └── Pelanggan.java  
├── service/  
│   ├── MenuService.java       (CRUD data Menu)  
│   └── PelangganService.java  (CRUD data Pelanggan)  
└── main/  
    └── CoffeeShop.java        (main() + tampilan CLI)  

---

## 3. Penjelasan Inheritance

Relasi inheritance ada pada `Menu` sebagai **superclass**, dengan dua **subclass**: `Makanan` dan `Minuman`.

```java
// Superclass
public class Menu {
    protected int idMenu;
    protected String namaMenu;
    protected int harga;

    public Menu(int idMenu, String namaMenu, int harga) {
        this.idMenu = idMenu;
        this.namaMenu = namaMenu;
        this.harga = harga;
    }

    public String getInfo() {
        return "[" + idMenu + "] " + namaMenu + " - Rp" + harga;
    }
}

// Subclass 1
public class Makanan extends Menu {
    private String jenisMakanan;

    public Makanan(int idMenu, String namaMenu, int harga, String jenisMakanan) {
        super(idMenu, namaMenu, harga); // memanggil constructor superclass
        this.jenisMakanan = jenisMakanan;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + " | Kategori: Makanan | Jenis: " + jenisMakanan;
    }
}

// Subclass 2
public class Minuman extends Menu {
    private String ukuran;

    public Minuman(int idMenu, String namaMenu, int harga, String ukuran) {
        super(idMenu, namaMenu, harga); // memanggil constructor superclass
        this.ukuran = ukuran;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + " | Kategori: Minuman | Ukuran: " + ukuran;
    }
}
```

`Makanan` dan `Minuman` **mewarisi** field `idMenu`, `namaMenu`, `harga` beserta getter/setter-nya dari `Menu` melalui `super(...)`, sekaligus menambahkan field unik masing-masing (`jenisMakanan` dan `ukuran`). Method `getInfo()` di-**override** oleh kedua subclass (contoh **polymorphism**): saat dipanggil lewat referensi bertipe `Menu`, Java otomatis menjalankan versi method sesuai objek aslinya.

---
## 4. Demo Program  
- Menu Utama Tampilan
<img width="385" height="110" alt="image" src="https://github.com/user-attachments/assets/78bf0784-b5f2-4f56-8643-087cc274e7c4" />

awal program CLI yang menampilkan opsi navigasi utama: Kelola Menu (1), Kelola Pelanggan (2), dan Keluar (0).  

___

a) Menu  
- Kelola Menu Submenu
<img width="400" height="197" alt="image" src="https://github.com/user-attachments/assets/1b3a65b3-9ac4-4e5f-b029-958395a6f708" />

yang muncul setelah memilih "Kelola Menu", berisi 5 opsi CRUD: Tambah Menu, Lihat Semua Menu, Update Menu, Hapus Menu, dan Kembali.  

- Tambah Menu - Makanan
<img width="288" height="150" alt="image" src="https://github.com/user-attachments/assets/30c73230-29e7-4b98-92b3-24f7394252d7" />
<img width="452" height="121" alt="image" src="https://github.com/user-attachments/assets/5f44242c-8fbb-4d65-a20e-78c1bb914d46" />

Makanan: ID 101, Nama Nasi Goreng Spesial, Harga 25000, Jenis Berat. Program memanggil menuService.tambahMakanan(...) yang membuat objek Makanan baru lewat constructor super(idMenu, namaMenu, harga) ke superclass Menu.  

- Lihat Semua Menu
<img width="665" height="120" alt="image" src="https://github.com/user-attachments/assets/be232fc6-7a43-4098-90a7-62d0f8c77f85" />

Daftar menu ditampilkan: [101] Nasi Goreng Spesial - Rp25000 | Kategori: Makanan | Jenis: Berat. Baris ini dihasilkan dari method getInfo() yang di-override pada class Makanan.

- Update Menu Data Menu
<img width="672" height="240" alt="image" src="https://github.com/user-attachments/assets/1f7cc935-1a8d-41f4-b566-e9daadd00aff" />  

dengan ID 101 diubah: nama menjadi Kentang Goreng, harga menjadi 12000, jenis menjadi Snack. Program menemukan objeknya lewat cariMenu(id), lalu mengubah nilainya langsung menggunakan setter.  

- Hapus Menu
<img width="617" height="178" alt="image" src="https://github.com/user-attachments/assets/fc458bdb-fba1-4e55-94b6-227abd01098a" />  

dengan ID 101 dihapus dari daftar lewat menuService.hapusMenu(menuDicari), program mencetak konfirmasi "Menu berhasil dihapus!".  

- Tambah Menu - Minuman
<img width="565" height="518" alt="image" src="https://github.com/user-attachments/assets/b3738ecb-3d05-4245-9815-9d48036e9296" />

Minuman: ID 201, Nama Espresso, Harga 18000, Ukuran Small. Kali ini objek yang dibuat adalah Minuman (subclass kedua dari Menu). Saat ditampilkan, field yang muncul otomatis berbeda dari Makanan (Ukuran, bukan Jenis), walau method yang dipanggil sama persis (m.getInfo()).

- Kembali Ke Menu Utama  
<img width="422" height="171" alt="image" src="https://github.com/user-attachments/assets/a5e3cc59-c26d-4e7e-900b-f03c0e1e38a7" />

Kelola Menu untuk kembali ke tampilan menu utama. Ini menunjukkan navigasi do-while loop bekerja dengan benar. Program tidak berhenti/keluar, hanya kembali ke level menu sebelumnya sampai pengguna memilih 0 di menu paling atas untuk benar-benar keluar.  

___

b) pelanggan   
- Kelola Pelanggan
<img width="307" height="192" alt="image" src="https://github.com/user-attachments/assets/1c247ca0-dff5-4fa8-be0f-19af03909ac8" />


Submenu yang muncul setelah memilih "Kelola Pelanggan" dari menu utama, berisi 5 opsi CRUD: Tambah Pelanggan, Lihat Semua Pelanggan, Update Pelanggan, Hapus Pelanggan, dan Kembali.  

- Tambah Pengguna
<img width="327" height="90" alt="image" src="https://github.com/user-attachments/assets/bb374b7b-7221-4290-bab9-70282bc9b266" />  

Input data pelanggan baru: ID 301, Nama Budi Santoso. Program memanggil pelangganService.tambahPelanggan(301, "Budi Santoso") yang membuat objek Pelanggan baru, setelah lebih dulu divalidasi lewat cariPelanggan(id) untuk memastikan ID belum dipakai.  

- Lihat Semua Pelanggan
<img width="251" height="103" alt="image" src="https://github.com/user-attachments/assets/9e479f88-4843-4b55-a960-04269cd16eeb" />

Daftar pelanggan ditampilkan: [301] Budi Santoso, hasil dari method getInfo() pada class Pelanggan.  

- Update Pelanggan
<img width="457" height="187" alt="image" src="https://github.com/user-attachments/assets/93b3f891-faa0-4c9b-84b3-e7fea6b29f3e" />

pelanggan dengan ID 301 diubah namanya dari Budi Santoso menjadi Andi Wijaya. Program menemukan objeknya lewat cariPelanggan(id), lalu mengubah nilainya langsung menggunakan setNamaPelanggan(...).  

- Hapus Pelanggan
<img width="450" height="157" alt="image" src="https://github.com/user-attachments/assets/6ba1e804-4a51-489a-8fae-957b89e2a8ea" />
Pelanggan dengan ID 301 (Andi Wijaya) dihapus dari daftar lewat pelangganService.hapusPelanggan(pelangganDicari), program mencetak konfirmasi "Pelanggan berhasil dihapus!".

- Kembali Ke Menu Utama  
<img width="402" height="277" alt="image" src="https://github.com/user-attachments/assets/f6acdc30-1c8f-453f-b907-1264d7fb9e7f" />  

Kelola Pelanggan untuk kembali ke tampilan menu utama, menunjukkan navigasi antar submenu bekerja dengan benar untuk kedua entitas (Menu dan Pelanggan).  

___

-  Keluar Dari Program
<img width="387" height="141" alt="image" src="https://github.com/user-attachments/assets/ade320e9-b21c-49a6-8645-03edb9a34614" />

Dari menu utama, memilih 0 untuk keluar dari program. Program mencetak pesan penutup "Terima Kasih!!!" dan do-while loop di main() berhenti karena kondisi pilihan != 0 sudah tidak terpenuhi.

---
## 5. Validasi Input & Error Handling  
Program menangani beberapa jenis kesalahan input supaya tidak crash dan tetap memberi pesan yang jelas ke pengguna.  

a. Input bukan angka
Method bacaAngka() membungkus Integer.parseInt() dengan try-catch, sehingga kalau pengguna mengetik huruf atau simbol (bukan angka) saat program minta angka, program tidak berhenti paksa — cukup minta input ulang. 
```
static int bacaAngka() {
    while (true) {
        try {
            return Integer.parseInt(input.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.print("Masukkan angka yang valid: ");
        }
    }
}
```
<img width="382" height="140" alt="image" src="https://github.com/user-attachments/assets/204cf8d8-a222-47d0-85b1-7d9783cf849e" />  

Di menu utama, pengguna mengetik abc (bukan angka) pada prompt "Pilih Menu:". Alih-alih program berhenti dengan error, bacaAngka() menangkap NumberFormatException lewat try-catch, mencetak "Masukkan angka yang valid:", dan otomatis meminta input ulang sampai pengguna memasukkan angka yang benar.

b. ID duplikat saat menambah data  
Sebelum data baru disimpan, program mengecek dulu apakah ID sudah dipakai lewat cariMenu(id) / cariPelanggan(id). Kalau hasilnya bukan null (berarti sudah ada), data batal ditambahkan.  
```
System.out.print("ID menu: ");
int id = bacaAngka();
if (menuService.cariMenu(id) != null) {
    System.out.println("ID " + id + " sudah dipakai menu lain, menu batal ditambahkan.");
    return;
}
```
<img width="520" height="545" alt="image" src="https://github.com/user-attachments/assets/37e651a0-4f7b-4a89-b37f-f4636030167b" />  

Menu "Nasi Goreng Spesial" ditambahkan dengan ID 101. Saat mencoba menambah menu baru dengan ID 101 lagi, cariMenu(101) menemukan objek yang sudah ada (bukan null), sehingga program menolak dan mencetak "ID 101 sudah dipakai menu lain, menu batal ditambahkan." data baru tidak jadi disimpan.

c. ID tidak ditemukan saat update/hapus  
Untuk update dan hapus, program mencari objeknya lebih dulu. Kalau cariMenu(id) / cariPelanggan(id) mengembalikan null (ID tidak ada di daftar), program memberi tahu pengguna alih-alih memproses data kosong. 
```
Menu menuDicari = menuService.cariMenu(id);
if (menuDicari == null) {
    System.out.println("Menu dengan ID tersebut tidak ditemukan!!");
    return;
}
```
<img width="673" height="122" alt="image" src="https://github.com/user-attachments/assets/de9df9c5-78d0-4c0e-b1d7-9c564a01fe0f" />  

Pada fitur Update Menu, pengguna memasukkan ID 999 yang tidak ada di daftar (yang tersedia hanya ID 101). cariMenu(999) mengembalikan null, sehingga program mencetak "Menu dengan ID tersebut tidak ditemukan!!" dan proses update langsung dihentikan (return), tanpa mencoba mengubah objek yang tidak ada.  

d. Kategori menu tidak valid  
Saat menambah menu, kategori yang dipilih harus 1 (Makanan) atau 2 (Minuman). Selain itu, proses tambah menu langsung dibatalkan.  
```
if (kategori != 1 && kategori != 2) {
    System.out.println("Kategori tidak valid, menu batal ditambahkan.");
    return;
}
```
<img width="433" height="125" alt="image" src="https://github.com/user-attachments/assets/0bcb7f1d-db4d-4c25-8236-cda2d65dea13" />  

Saat menambah menu, pengguna memilih kategori 5, padahal pilihan yang valid cuma 1 (Makanan) atau 2 (Minuman). Program mendeteksi ini lewat kondisi kategori != 1 && kategori != 2, mencetak "Kategori tidak valid, menu batal ditambahkan.", dan langsung return.  

e. Update dengan input kosong
Saat update, jika pengguna menekan Enter tanpa mengetik apa pun (ingin membiarkan nilai lama), program mengecek dengan isBlank() supaya data lama tidak tertimpa nilai kosong.  
```
System.out.print("Nama baru (" + menuDicari.getNamaMenu() + "): ");
String nama = input.nextLine();
if (!nama.isBlank()) menuDicari.setNamaMenu(nama);
```
<img width="683" height="237" alt="image" src="https://github.com/user-attachments/assets/3eef6603-aa76-4340-a4f3-f749bb0f8e96" />  

Saat update menu ID 101, pengguna menekan Enter tanpa mengetik apa pun di semua prompt (nama, harga, jenis). Karena nama.isBlank() bernilai true untuk input kosong, kondisi if (!nama.isBlank()) tidak terpenuhi, sehingga setNamaMenu(...) tidak dipanggil, nilai lama tetap dipertahankan. Program tetap mencetak "Menu berhasil diupdate!" karena secara teknis proses update selesai dijalankan, walau tidak ada nilai yang benar-benar berubah.








