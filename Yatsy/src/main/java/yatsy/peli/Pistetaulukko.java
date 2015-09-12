package peli;

import java.util.HashMap;
import static peli.NoppaKombinaatiot.*;

/**
 *
 * @author Miia Rämö
 */
public class Pistetaulukko {
    NoppaKombinaatiot kombinaatiot;
    HashMap<Enum, Integer> pistetaulu;
    
    public Pistetaulukko() {
     this.pistetaulu = new HashMap();
     alustaPistetaulu();
    }
    
    private void alustaPistetaulu() {
        for (Enum kombinaatio : NoppaKombinaatiot.values()) {
            pistetaulu.put(kombinaatio, 0);
        }
    }
    
    public void asetaPisteet(Enum mihin, int pisteet) {
        pistetaulu.replace(mihin, pisteet);
    }
    
    public void laskeValisumma() {
        int valisumma = 0;
        for (Enum kombinaatio : NoppaKombinaatiot.values()) {
            if (kombinaatiot.getIndex() < 7) {
                valisumma =+ pistetaulu.get(kombinaatio);
            }
        }
    }
    
    public void saakoBonuksen() {
        if (pistetaulu.get(VALISUMMA) >= 63) {
            pistetaulu.replace(BONUS, 60);
        }
    }
    
    public void laskeLoppusumma() {
        int loppusumma = 0;
        for (Enum kombinaatio : NoppaKombinaatiot.values()) {
            if (kombinaatiot.getIndex() >= 7 | kombinaatiot.getIndex() <= 17) {
                loppusumma += pistetaulu.get(kombinaatio);
            }
        }
    }
    
    public String tulostaRivi(Enum kombinaatio) {
        String rivi = "";
        rivi += kombinaatio + " " + pistetaulu.get(kombinaatio);
        return rivi;
    }
    
    @Override
    public String toString() {
        String yolo = "";
        for (Enum kombinaatio : NoppaKombinaatiot.values()) {
            yolo += kombinaatio + " " + pistetaulu.get(kombinaatio) + "\n";
        }
        return yolo;
    }
    
}
