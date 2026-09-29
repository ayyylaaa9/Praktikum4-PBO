/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TugasPraktikum5;

/**
 *
 * @author Noer Afdila
 */
public class MainAset {
    public static void main(String[] args) {

        // Membuat objek ManajemenAset
        ManajemenAset manajemen = new ManajemenAset();

        // Menambahkan data aset IT
        manajemen.tambahAset(
            new AsetIT("A001", "Server", "Ruang Server", "Baik")
        );
        manajemen.tambahAset(
            new AsetIT("A002", "Router", "Ruang Jaringan", "Baik")
        );
        manajemen.tambahAset(
            new AsetIT("A003", "Switch", "Ruang Jaringan", "Rusak")
        );
        manajemen.tambahAset(
            new AsetIT("A004", "PC", "Laboratorium", "Baik")
        );

        // Menampilkan semua aset
        System.out.println("\n--- DATA AWAL ASET ---");
        manajemen.tampilkanSemuaAset();

        // Menghapus aset berdasarkan ID
        System.out.println("\n--- PROSES PENGHAPUSAN ---");
        manajemen.hapusAset("A003");

        // Menampilkan kembali semua aset
        System.out.println("\n--- DATA SETELAH PENGHAPUSAN ---");
        manajemen.tampilkanSemuaAset();
    }
}