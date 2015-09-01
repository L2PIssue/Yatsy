
package peli;

/**
 *
 * @author Miia Rämö
 */

public class Noppa {
    private int luku;
    
    public Noppa() {
        luku = (int) (Math.random()*6) + 1;
    }
    
    public int heitaNoppa() {
        this.luku = (int) (Math.random()*6) + 1;
        return luku;
    }
    
    
}
