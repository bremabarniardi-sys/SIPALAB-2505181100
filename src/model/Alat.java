package model;
import java.io.Serializable;

public abstract class Alat implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    protected String kodeAlat;
    protected String nama;
    protected int tahunPerolehan;
    protected StatusAlat status = StatusAlat.TERSEDIA;
    
    protected Alat() { }
    
    public Alat(String kodeAlat, String nama, int tahunPerolehan) {
        this.kodeAlat = kodeAlat;
        this.nama = nama;
        this.tahunPerolehan = tahunPerolehan;
    }
    
    public String deskripsi() {
        return kodeAlat + " - " + nama + " (" + tahunPerolehan + ")";
    }
    
    public abstract boolean siapDipinjam() ;
        
    public abstract String jenis();
    
    
    public String laporanRingkas() {
        String status = siapDipinjam() ? "SIAP" : "TIDAK SIAP";
        return String.format("%-8s %-22s %s", kodeAlat, nama, status);
    }
    
    public String getKodeAlat() { return kodeAlat; }
    public String getNama() { return nama; }
    public int getTahunPerolehan() { return tahunPerolehan; }
    public StatusAlat getStatus() { return status; }
    public void setStatus(StatusAlat status) { this.status = status; }
    public void setNama(String nama) {this.nama = nama; }
    public void setTahunPerolehan(int t) { this.tahunPerolehan = t; }
}