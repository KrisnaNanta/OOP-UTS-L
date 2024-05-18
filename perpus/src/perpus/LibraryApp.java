/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package perpus;

import java.util.Scanner;

/**
 *
 * @author I Kadek Krisna Nanta Dipayana
 * tgl : 18 mei 2024
 */

public class LibraryApp {
    private static final int MAX_PEMINJAM = 100;
    private static BookBorrower[] peminjam = new BookBorrower[MAX_PEMINJAM];
    private static int jumlahPeminjam = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int pilihan;
        do {
            System.out.println("Menu:");
            System.out.println("1. Catat peminjam");
            System.out.println("2. Tampilkan jumlah peminjam");
            System.out.println("3. Ubah data peminjam");
            System.out.println("4. Hapus data peminjam");
            System.out.println("5. Keluar");
            System.out.print("Pilihan: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan newline dari buffer

            switch (pilihan) {
                case 1:
                    catatPeminjam();
                    break;
                case 2:
                    tampilkanJumlahPeminjam();
                    break;
                case 3:
                    ubahDataPeminjam();
                    break;
                case 4:
                    hapusDataPeminjam();
                    break;
                case 5:
                    System.out.println("Terima kasih telah menggunakan aplikasi!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 5);
    }

    private static void catatPeminjam() {
        if (jumlahPeminjam < MAX_PEMINJAM) {
            System.out.print("Masukkan nama peminjam: ");
            String nama = scanner.nextLine();
            peminjam[jumlahPeminjam] = new BookBorrower(nama);
            jumlahPeminjam++;
            System.out.println("Peminjam berhasil dicatat.");
        } else {
            System.out.println("Kapasitas peminjam penuh.");
        }
    }

    private static void tampilkanJumlahPeminjam() {
        System.out.println("Jumlah peminjam: " + jumlahPeminjam);
        System.out.println("Daftar peminjam:");
        for (int i = 0; i < jumlahPeminjam; i++) {
            System.out.println((i + 1) + ". " + peminjam[i].getNama());
        }
    }

    private static void ubahDataPeminjam() {
        System.out.print("Masukkan nomor peminjam yang ingin diubah: ");
        int nomor = scanner.nextInt();
        scanner.nextLine(); // Membersihkan newline dari buffer

        if (nomor > 0 && nomor <= jumlahPeminjam) {
            System.out.print("Masukkan nama baru: ");
            String namaBaru = scanner.nextLine();
            peminjam[nomor - 1].setNama(namaBaru);
            System.out.println("Data peminjam berhasil diubah.");
        } else {
            System.out.println("Nomor peminjam tidak valid.");
        }
    }

    private static void hapusDataPeminjam() {
        System.out.print("Masukkan nomor peminjam yang ingin dihapus: ");
        int nomor = scanner.nextInt();
        scanner.nextLine(); // Membersihkan newline dari buffer

        if (nomor > 0 && nomor <= jumlahPeminjam) {
            for (int i = nomor - 1; i < jumlahPeminjam - 1; i++) {
                peminjam[i] = peminjam[i + 1];
            }
            peminjam[--jumlahPeminjam] = null;
            System.out.println("Data peminjam berhasil dihapus.");
        } else {
            System.out.println("Nomor peminjam tidak valid.");
        }
    }
}
