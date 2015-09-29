
package peli;
/**
 *
 * @author Miia Rämö
 */
public class Pelaaja {

    private int[] pisteet;
    private boolean[] onkoLisatty;

    public Pelaaja() {
        this.pisteet = new int[18];
        this.onkoLisatty = new boolean[18];
    }
    
    public int getPisteet(int index) {
        return pisteet[index];
    }
    
    private void laskeValisumma() {
        pisteet[6] = 0;
        for (int i = 0; i < 6; i++) {
            pisteet[6] += pisteet[i];
        }
        if (pisteet[6] >= 63) {
            pisteet[7] = 50;
        }
    }
    
    public void laskeLoppusumma(){
        this.laskeValisumma();
        for (int i = 6; i < 17; i++) {
            pisteet[17] += pisteet[i];
        }
    }
    
    public int getLoppusumma() {
        return this.getPisteet(17);
    }
    
    public int getValisumma() {
        return this.getPisteet(6);
    }

    public boolean getOnkoLisatty(int index) {
        return this.onkoLisatty[index];
    }

    public boolean asetaPisteet(int paljonko, int mihin) {
        if (paljonko >= 0 && onkoLisatty[mihin] == false) {
            pisteet[mihin] += paljonko;
            onkoLisatty[mihin] = true;
            pisteet[17] += paljonko;
            onkoLisatty[17] = true;

            this.laskeValisumma();
            
            return true;
        }
        return false;
    }

//    pistetaulun indexien selitteet
//    pisteet[0] ykkoset;
//    pisteet[1] kakkoset;
//    pisteet[2] kolmoset;
//    pisteet[3] neloset;
//    pisteet[4] vitoset;
//    pisteet[5] kutoset;
//    pisteet[6] välisumma;
//    pisteet[7] bonus;
//    pisteet[8] yksiPari;
//    pisteet[9] kaksiParia;
//    pisteet[10] kolmeSamaa;
//    pisteet[11] neljaSamaa;
//    pisteet[12] pieniSuora;
//    pisteet[13] suuriSuora;
//    pisteet[14] taysiKasi;
//    pisteet[15] yatsy;
//    pisteet[16] sattuma;
//    pisteet[17] loppusumma;
}
