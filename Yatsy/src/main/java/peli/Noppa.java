
package peli;

import java.util.Random;

/**
 *
 * @author Miia Rämö
 */

public class Noppa {
    private Random random;
    private int silmaluku;
    private boolean lukossa;
    
    public Noppa() {
        this.random = new Random();
        this.silmaluku = random.nextInt(6) + 1;
        this.lukossa = false;
    }
    
    public int getSilmaluku() {
        return this.silmaluku;
    }
    
    public boolean onkoLukittu() {
        return this.lukossa;
    }
    
    public void muutaLukitus() {
        this.lukossa = !this.lukossa;
    }
    
    public int heitaNoppa() {
        if (!this.lukossa) {
            this.silmaluku = random.nextInt(6) + 1;
        }
        return silmaluku;
    }
    
    @Override
    public String toString() {
        return Integer.toString(silmaluku);
    }
    
}
