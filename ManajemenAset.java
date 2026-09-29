/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TugasPraktikum5;

/**
 *
 * @author Noer Afdila
 */
import java.util.ArrayList;
import java.util.Iterator;

public class ManajemenAset {

    // ArrayList untuk menyimpan data aset
    ArrayList<AsetIT> daftarAset;

    // Constructor
    public ManajemenAset() {
        daftarAset = new ArrayList<>();
    }

    // Method untuk menambahkan aset
    public void tambahAset(AsetIT asetbaru) {
        daftarAset.add(asetbaru);
        System.out.println("Aset berhasil ditambahkan.");
    }

    // Method untuk menampilkan semua aset
    public void tampilkanSemuaAset() {

        if (daftarAset.isEmpty()) {
            System.out.println("Belum ada data aset.");
            return;
        }

        System.out.println("\n===== DAFTAR SEMUA ASET IT =====");

        for (AsetIT aset : daftarAset) {
            aset.tampilkanInfoAset();
        }
    }

    // Method untuk menghapus aset berdasarkan ID
    public void hapusAset(String idAset) {

        Iterator<AsetIT> iterator = daftarAset.iterator();

        while (iterator.hasNext()) {

            AsetIT aset = iterator.next();

            if (aset.idAset.equals(idAset)) {
                iterator.remove();

                System.out.println(
                    "Aset dengan ID " + idAset + " berhasil dihapus."
                );

                return;
            }
        }

        System.out.println(
            "Peringatan: Aset dengan ID " + idAset + " tidak ditemukan."
        );
    }
}