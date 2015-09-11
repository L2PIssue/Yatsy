
package peli;

import java.util.Scanner;

/**
 *
 * @author Miia Rämö
 */
public class Pelaaja {
    Scanner lukija;
    Pistetaulukko pisteet;
    
    public Pelaaja() {
        this.lukija = new Scanner(System.in);
        this.pisteet = new Pistetaulukko();
    }
    
    public String getPistetaulu() {
        return pisteet.toString();
    }
    
    public void kirjaaPisteet(Enum kombinaatio, int paljonko) {
        pisteet.asetaPisteet(kombinaatio, paljonko);
    }
    
}
