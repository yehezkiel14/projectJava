package Tugas1;

import java.util.*;

//Interface untuk kelas yang dapat dicetak (printable)
interface Printable {
 void print();
}

//Kelas abstrak untuk Tamu
abstract class Tamu implements Printable {
 protected String nama;
 protected String nomorKamar;
 protected double biaya;

 // Constructor
 public Tamu(String nama, String nomorKamar) {
     this.nama = nama;
     this.nomorKamar = nomorKamar;
 }

 // Encapsulation - Getter dan Setter
 public String getNama() {
     return nama;
 }

 public void setNama(String nama) {
     this.nama = nama;
 }

 public String getNomorKamar() {
     return nomorKamar;
 }

 public void setNomorKamar(String nomorKamar) {
     this.nomorKamar = nomorKamar;
 }

 public double getBiaya() {
     return biaya;
 }

 // Abstract method yang harus diimplementasi oleh kelas turunan
 public abstract void hitungBiaya();

 // Method dari interface Printable
 @Override
 public void print() {
     System.out.println("Nama: " + nama);
     System.out.println("Nomor Kamar: " + nomorKamar);
     System.out.println("Biaya: $" + biaya);
 }
}

//Kelas dasar untuk TamuHotel
class TamuHotel extends Tamu {
 // Constructor
 public TamuHotel(String nama, String nomorKamar) {
     super(nama, nomorKamar);
     this.biaya = 100.0; // Harga default untuk tamu biasa
     hitungBiaya(); // Menghitung biaya sesuai dengan jenis tamu
 }

 // Implementasi dari abstract method hitungBiaya untuk TamuHotel
 @Override
 public void hitungBiaya() {
     // Biaya untuk tamu biasa
     // Tidak perlu diimplementasikan karena sudah di-set pada constructor
 }
}

//Kelas turunan untuk TamuVIP yang merupakan turunan dari Tamu
class TamuVIP extends Tamu {
 private boolean statusVIP;

 // Constructor
 public TamuVIP(String nama, String nomorKamar, boolean statusVIP) {
     super(nama, nomorKamar);
     this.statusVIP = statusVIP;
     this.biaya = 200.0; // Harga untuk tamu VIP
     hitungBiaya(); // Menghitung biaya sesuai dengan jenis tamu
 }

 // Implementasi dari abstract method hitungBiaya untuk TamuVIP
 @Override
 public void hitungBiaya() {
     // Biaya untuk tamu VIP
     // Tidak perlu diimplementasikan karena sudah di-set pada constructor
 }

 // Access Modifier - Override method dari kelas dasar
 @Override
 public void print() {
     super.print();
     System.out.println("Status VIP: " + (statusVIP ? "Ya" : "Tidak"));
 }
}

//Kelas Transaksi untuk mengelola transaksi tamu
class Transaksi {
 private List<Tamu> daftarTransaksi;

 // Constructor
 public Transaksi() {
     this.daftarTransaksi = new ArrayList<>();
 }

 // Menambahkan transaksi
 public void tambahTransaksi(Tamu tamu) {
     daftarTransaksi.add(tamu);
 }

 // Menampilkan semua transaksi
 public void tampilkanTransaksi() {
     System.out.println("Daftar Transaksi:");
     for (Tamu tamu : daftarTransaksi) {
         System.out.println("---------------");
         tamu.print();
     }
     System.out.println("---------------");
 }
}

//Kelas utama sebagai driver program
public class AplikasiPengelolaanTamuHotel {
 public static void main(String[] args) {
     // Membuat objek Scanner
     Scanner scanner = new Scanner(System.in);

     // Meminta pengguna memasukkan jumlah tamu
     System.out.print("Masukkan jumlah tamu yang akan dimasukkan: ");
     int jumlahTamu = scanner.nextInt();

     // Membuat objek Transaksi
     Transaksi transaksi = new Transaksi();

     // Loop untuk memasukkan data tamu sesuai dengan jumlah yang diminta
     for (int i = 1; i <= jumlahTamu; i++) {
         // Meminta pengguna memilih jenis tamu
         System.out.println("Pilih jenis tamu ke-" + i + ":");
         System.out.println("1. Tamu Biasa");
         System.out.println("2. Tamu VIP");
         System.out.print("Masukkan pilihan (1/2): ");
         int pilihan = scanner.nextInt();

         // Deklarasi variabel untuk nama dan nomor kamar
         String nama, nomorKamar;

         // Meminta pengguna memasukkan nama tamu
         System.out.print("Masukkan nama tamu ke-" + i + ": ");
         scanner.nextLine(); // Membersihkan buffer
         nama = scanner.nextLine();

         // Meminta pengguna memasukkan nomor kamar tamu
         System.out.print("Masukkan nomor kamar tamu ke-" + i + ": ");
         nomorKamar = scanner.nextLine();

         // Membuat objek Tamu berdasarkan pilihan pengguna
         Tamu tamu = null;
         switch (pilihan) {
             case 1:
                 // Membuat objek TamuHotel (tamu biasa) dengan data yang diinput
                 tamu = new TamuHotel(nama, nomorKamar);
                 break;

             case 2:
                 // Membuat objek TamuVIP dengan data yang diinput
                 tamu = new TamuVIP(nama, nomorKamar, true);
                 break;

             default:
                 System.out.println("Pilihan tidak valid.");
                 break;
         }

         // Menambahkan transaksi tamu ke daftar transaksi
         if (tamu != null) {
             transaksi.tambahTransaksi(tamu);
         }
     }

     // Menampilkan semua transaksi
     transaksi.tampilkanTransaksi();

     // Menutup scanner
     scanner.close();
 }
}
