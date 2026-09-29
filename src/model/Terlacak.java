package model;

public interface Terlacak {
    String getNomorSeri();
    String getLokasiTerakhir();
    
    default String ringkasanLacak() {
        return "Nomor Seri: " + getNomorSeri() + " | Lokasi: " + getLokasiTerakhir();
    }
    
}