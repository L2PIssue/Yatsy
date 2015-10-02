
package peli;

import java.util.Random;

/**
 * Luokka joka toteuttaa nopan ominaisuudet
 * @author Miia Rämö
 */
public class Noppa {
    private final Random random;
    private int silmaluku;
    private boolean lukossa;
    
    public Noppa() {
        this.random = new Random();
        this.silmaluku = random.nextInt(6) + 1;
        this.lukossa = false;
    }
    
    /**
     * Metodi nopan testaamisen apuvälineeksi
     * @param luku Nopalle asetettava silmäluku
     */
    public void setSilmaluku(int luku) {
        this.silmaluku = luku;
    }
    
    /**
     * @return Palauttaa nopan silmäluvun
     */
    public int getSilmaluku() {
        return this.silmaluku;
    }
    
    /**
     * @return Kertoo onko noppa lukossa
     */
    public boolean onkoLukittu() {
        return this.lukossa;
    }
    
    /**
     * Lukitsee vapaan, tai vapauttaa jo lukitun, nopan
     */
    public void muutaLukitus() {
        this.lukossa = !this.lukossa;
    }
    
    /**
     * Jos noppa ei ole lukossa, sille arvotaan uusi silmäluku
     * @return Palauttaa silmäluvun
     */
    public int heitaNoppa() {
        if (!this.lukossa) {
            this.silmaluku = random.nextInt(6) + 1;
        }
        return silmaluku;
    }
}
