package model;

import java.util.ArrayList;
import java.util.List;

public class Laboratorium {
    private final String kodeLab;
    private final String nama;

    // AGREGASI: alat dibuat di luar, laboratorium hanya menampung
    private final List<Alat> koleksiAlat = new ArrayList<>();

    public Laboratorium(String kodeLab, String nama) {
        this.kodeLab = kodeLab;
        this.nama = nama;
    }

    public void tambahAlat(Alat alat) {
        koleksiAlat.add(alat);
    }

    public int jumlahAlat() {
        return koleksiAlat.size();
    }
}