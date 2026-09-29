package model;

public class Laptop extends Alat implements Terlacak {
    private int ramGB;
    private boolean chargerLengkap;
    private String nomorSeri;
    private String lokasiTerakhir;

    public Laptop(String kodeAlat, String nama, int tahunPerolehan, int ramGB, boolean chargerLengkap, String nomorSeri, String lokasiTerakhir) {
        super(kodeAlat, nama, tahunPerolehan);
        this.ramGB = ramGB;
        this.chargerLengkap = chargerLengkap;
        this.nomorSeri = nomorSeri;
        this.lokasiTerakhir = lokasiTerakhir;
    }

    public Laptop(String kodeAlat, String nama, int tahunPerolehan, int ramGB, boolean chargerLengkap) {
        this(kodeAlat, nama, tahunPerolehan, ramGB, chargerLengkap, "SN-LAP-"+ kodeAlat, "Lab TRPL");
    }

    @Override
    public String deskripsi() {
        return super.deskripsi() + " RAM " + ramGB + " GB";
    }

    @Override
    public boolean siapDipinjam() {
        return chargerLengkap;
    }
    
    @Override
    public String getNomorSeri() {
        return nomorSeri;
             
    }
    
    @Override
    public String getLokasiTerakhir() {
        return lokasiTerakhir;
    }
    
    @Override
    public String jenis() {
    return "Laptop";
    }
    
}