package model;

import java.time.LocalDate;
import layanan.InventarisLab;
import transaksi.DetailPeminjaman;
import transaksi.Peminjaman;

public class Main {
    public static void main(String[] args) {
        InventarisLab lab = new InventarisLab();

        // Data awal praktikum
        Alat lap = new Laptop("LP-002", "Lenovo ThinkPad", 2023, 16, true);
        Alat pro = new Proyektor("PJ-003", "Epson EB-X51", 2022, 3300, 1200);

        lab.tambah(lap);
        lab.tambah(pro);
        lab.tambah(new AlatUkur("AU-001", "Multimeter Fluke", 2020, "Volt", LocalDate.now().minusMonths(6)));
        lab.tambah(new Komponen("KP-001", "Kabel Jumper", 2024, 50, 10));
        lab.tambah(new Komponen("KP-002", "Breadboard", 2023, 5, 10));

        System.out.println("DAFTAR STATUS ALAT");
        lab.cetakStatus();

        System.out.println("\nJADWAL KALIBRASI ALAT");
        lab.cetakJadwalKalibrasi();

        System.out.println("\n=== PENGUJIAN TUGAS MANDIRI JOB SHEET 3 ===");
        System.out.println("Jumlah alat siap dipinjam: " + lab.hitungSiapDipinjam());

        System.out.println("\nDaftar alat yang TIDAK siap:");
        for (Alat a : lab.daftarTidakSiap()) {
            System.out.println("- " + a.getKodeAlat() + " " + a.getNama());
        }

        // ==========================================
        // PENGUJIAN RELASI JOB SHEET 4 (Langkah E.6)
        // ==========================================
        System.out.println("\n=== PENGUJIAN RELASI JOB SHEET 4 ===");
        Mahasiswa mhs = new Mahasiswa("2205062001", "Rani Simatupang", "TRPL");
        Petugas ptg = new Petugas("198701012015041002", "Bapak Sutrisno");

        // Agregasi: Laboratorium menampung alat
        Laboratorium labRpl = new Laboratorium("LAB-RPL", "Laboratorium Rekayasa PL");
        labRpl.tambahAlat(lap);
        labRpl.tambahAlat(pro);
        System.out.println("Jumlah alat di lab: " + labRpl.jumlahAlat());

        // Asosiasi (Mahasiswa & Petugas) dan Komposisi (DetailPeminjaman)
        Peminjaman pinjam = new Peminjaman("PJM-0001", mhs, ptg);
        pinjam.tambahDetail(lap, 1);
        pinjam.tambahDetail(pro, 2);
        System.out.println("Total item dipinjam: " + pinjam.totalItem());
        for (DetailPeminjaman d : pinjam.getDetail()) {
            System.out.println(" - " + d.baris());
        }

        // ==========================================
        // PENGUJIAN TUGAS MANDIRI JOB SHEET 4 (F.1 & F.2)
        // ==========================================
        System.out.println("\n=== PENGUJIAN TUGAS MANDIRI JOB SHEET 4 ===");
        pinjam.kembalikan();
        System.out.println("Status Pengembalian: Berhasil dikembalikan");
        System.out.println("Tanggal Pinjam    : " + pinjam.getTanggalPinjam());
        System.out.println("Tanggal Kembali   : " + pinjam.getTanggalKembali());
        System.out.println("Jumlah Hari Lewat : " + pinjam.hitungHariTerlambat() + " hari");
    }
}