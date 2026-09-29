//gemini
package model;

public class Proyektor extends Alat implements Terlacak {
    private int lumens;
    private int jamPakaiLampu;
    private String nomorSeri;
    private String lokasiTerakhir;

    public Proyektor(String kodeAlat, String nama, int tahunPerolehan, int lumens, int jamPakaiLampu, String nomorSeri, String lokasiTerakhir) {
        super(kodeAlat, nama, tahunPerolehan);
        this.lumens = lumens;
        this.jamPakaiLampu = jamPakaiLampu;
        this.nomorSeri = nomorSeri;
        this.lokasiTerakhir = lokasiTerakhir;
    }
    
    public Proyektor(String kodeAlat, String nama, int tahunPerolehan, int lumens, int jamPakaiLampu) {
    this(kodeAlat, nama, tahunPerolehan, lumens, jamPakaiLampu, "SN-PRJ-" + kodeAlat, "Ruang Audio Visual");
    }

    @Override
    public String deskripsi() {
        return super.deskripsi() + " " + lumens + " lumen";
    }

    @Override
    public boolean siapDipinjam() {
        return jamPakaiLampu <= 2000;
    }
    
    @Override
    public String getLokasiTerakhir() {
        return lokasiTerakhir;
    }
    
    @Override
    public String getNomorSeri() {
        return nomorSeri;
    }
    
    @Override
    public String jenis() {
    return "Proyektor";
}
    
}
