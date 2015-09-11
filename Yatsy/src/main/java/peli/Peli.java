package peli;

import static peli.NoppaKombinaatiot.*;

/**
 *
 * @author Miia Rämö
 */
public class Peli {
    private Pelaaja pelaaja;
    private Noppa noppa;
    
    public Peli() {
        this.pelaaja = new Pelaaja();
        this.noppa = new Noppa();
    }
    
    public void run() {
        pelaaja.kirjaaPisteet(YKKOSET, 6);
        System.out.println("\n");
        System.out.println(pelaaja.getPistetaulu());
    }
    
}
