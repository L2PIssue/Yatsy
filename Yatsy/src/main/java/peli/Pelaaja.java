
package peli;
/**
 * luokka, joka ottaa ylös pelaajan pisteet
 * @author Miia Rämö
 */
public class Pelaaja {

    private final int[] pisteet;
    private final boolean[] onkoLisatty;

    public Pelaaja() {
        this.pisteet = new int[18];
        this.onkoLisatty = new boolean[18];
    }
    
    /**
     * @param index haluttu lokaatio pistetaulukossa
     * @return pisteet annetusta lokaatiosta
     */
    public int getPisteet(int index) {
        return pisteet[index];
    }
    
    /**
     * laskee välisumman taulukon alkupään pisteistä
     */
    private void laskeValisumma() {
        pisteet[6] = 0;
        for (int i = 0; i < 6; i++) {
            pisteet[6] += pisteet[i];
        }
        if (pisteet[6] >= 63) {
            pisteet[7] = 50;
        }
    }
    
    /**
     * laskee loppusumman välisummasta sekä taulukon loppupään pisteistä
     */
    public void laskeLoppusumma(){
        this.laskeValisumma();
        for (int i = 6; i < 17; i++) {
            pisteet[17] += pisteet[i];
        }
    }
    
    /**
     * @return loppusumma
     */
    public int getLoppusumma() {
        return this.getPisteet(17);
    }
    
    /**
     * @return välisumma
     */
    public int getValisumma() {
        return this.getPisteet(6);
    }

    /**
     * @param index haluttu lokaatio pistetaulukossa
     * @return totuusarvo siitä, onko annetussa lokaatiossa jo pisteet
     */
    public boolean getOnkoLisatty(int index) {
        return this.onkoLisatty[index];
    }

    /**
     * asettaa pisteet pelaajalle
     * @param paljonko sijoitettava pistemäärä
     * @param mihin haluttu lokaatio pistetaulussa
     */
    public void asetaPisteet(int paljonko, int mihin) {
        if (paljonko >= 0 && onkoLisatty[mihin] == false) {
            pisteet[mihin] += paljonko;
            onkoLisatty[mihin] = true;
            pisteet[17] += paljonko;
            onkoLisatty[17] = true;
            this.laskeValisumma();
        }
    }
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
