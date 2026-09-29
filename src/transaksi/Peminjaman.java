package transaksi;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import model.Alat;
import model.Mahasiswa;
import model.Petugas;

public class Peminjaman {
    private final String nomorPeminjaman;
    private final LocalDate tanggalPinjam;
    private LocalDate tanggalKembali;

    // ASOSIASI: mahasiswa dan petugas hidup mandiri, hanya dirujuk
    private final Mahasiswa peminjam;
    private final Petugas penyetuju;

    // KOMPOSISI: detail dibuat di dalam kelas ini dan ikut lenyap bersamanya
    private final List<DetailPeminjaman> detail = new ArrayList<>();

    public Peminjaman(String nomorPeminjaman, Mahasiswa peminjam, Petugas penyetuju) {
        this.nomorPeminjaman = nomorPeminjaman;
        this.peminjam = peminjam;
        this.penyetuju = penyetuju;
        this.tanggalPinjam = LocalDate.now();
    }

    public void tambahDetail(Alat alat, int jumlah) {
        detail.add(new DetailPeminjaman(alat, jumlah));
    }

    public List<DetailPeminjaman> getDetail() {
        return Collections.unmodifiableList(detail);
    }

    public int totalItem() {
        int total = 0;
        for (DetailPeminjaman d : detail) {
            total += d.getJumlah();
        }
        return total;
    }

    // TUGAS MANDIRI F.1: Mengisi tanggal pengembalian hari ini
    public void kembalikan() {
        this.tanggalKembali = LocalDate.now();
    }

    // TUGAS MANDIRI F.2: Menghitung selisih hari jika lewat dari 7 hari
    public long hitungHariTerlambat() {
        if (tanggalKembali == null) {
            return 0;
        }
        long durasiPinjam = ChronoUnit.DAYS.between(tanggalPinjam, tanggalKembali);
        if (durasiPinjam > 7) {
            return durasiPinjam - 7;
        }
        return 0;
    }

    public LocalDate getTanggalPinjam() {
        return tanggalPinjam;
    }

    public LocalDate getTanggalKembali() {
        return tanggalKembali;
    }
}

//transaksi.java