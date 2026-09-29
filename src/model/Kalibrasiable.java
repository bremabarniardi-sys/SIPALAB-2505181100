package model;

import java.time.LocalDate;

public interface Kalibrasiable {
    
    boolean perluKalibrasi();
    
    LocalDate jatuhTempoKalibrasi();
    
    default String statusKalibrasi() {
        if (perluKalibrasi()) {
            return "Perlu Kalibrasi sejak " + jatuhTempoKalibrasi();   
        }
        return "Layak Pakai sampai " + jatuhTempoKalibrasi();
    }
    
}
