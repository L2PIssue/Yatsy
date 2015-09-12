package peli;

/**
 *
 * @author Miia Rämö
 */
public enum NoppaKombinaatiot {
    YKKOSET(1), KAKKOSET(2), KOLMOSET(3), NELOSET(4), VITOSET(5), KUTOSET(6), VALISUMMA(7), BONUS(8),
    YKSI_PARI(9), KAKSI_PARIA(10), KOLMOISLUKU(11), NELOISLUKU(12), PIENI_SUORA(13), SUURI_SUORA(14),
    MOKKI(15), SATTUMA(16), YATSY(17), LOPPUSUMMA(18);
    
    private final int index;
    
    private NoppaKombinaatiot(int index) {
        this.index = index;
    }
    
    public int getIndex() {
        return this.index;
    }
    
}
