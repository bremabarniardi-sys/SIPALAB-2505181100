package layanan;

import java.util.ArrayList;
import java.util.List;
import model.Alat;
import model.Kalibrasiable;

public class InventarisLab {

    private final List<Alat> daftarAlat = new ArrayList<>();

    public void tambah(Alat alat) {
        daftarAlat.add(alat);
    }

    public List<Alat> semuaAlat() {
        return daftarAlat;
    }
    
     //polimofik
    public void cetakStatus() {
        for (Alat a : daftarAlat) {
            System.out.println(a.laporanRingkas());
        }
    }
 
    //instanceof
    public void cetakJadwalKalibrasi() {
        for (Alat a : daftarAlat) {
            if (a instanceof Kalibrasiable k) {
                System.out.println(a.getNama() + " -> " + k.statusKalibrasi());
            }
        }
    }
    
    public int hitungSiapDipinjam() {
        int total = 0;
        for (Alat a : daftarAlat) {
            if (a.siapDipinjam()) {
                total++;
            }
        }
        return total;
    }

    // Dibantu AI untuk menyusun implementasi Tugas Mandiri F.2 menyaring koleksi alat tidak siap
    public List<Alat> daftarTidakSiap() {
        List<Alat> tidakSiap = new ArrayList<>();
        for (Alat a : daftarAlat) {
            if (!a.siapDipinjam()) {
                tidakSiap.add(a);
            }
        }
        return tidakSiap;
    }
}


