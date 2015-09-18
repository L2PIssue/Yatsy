
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
        for (int i = 0; i < 18; i++) {
            this.onkoLisatty[i] = false;
        }
    }

    public int getPisteet(int index) {
        return pisteet[index];
    }
    
    public void setPisteet(int maara){
        pisteet[17] = maara;
    }

    public boolean getOnkoLisatty(int index) {
        return this.onkoLisatty[index];
    }

 boolean asetaPisteet(int paljonko, int mihin) {
        if (paljonko >= 0 && onkoLisatty[mihin] == false) {
            pisteet[mihin] += paljonko;
            onkoLisatty[mihin] = true;
            pisteet[17] += paljonko;
            onkoLisatty[17] = true;

            if (mihin < 6) {
                pisteet[6] += paljonko;
                onkoLisatty[6] = true;
                
                if (pisteet[6] >= 63) {
                    pisteet[7] += 25;
                    onkoLisatty[7] = true;
                }
            }
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
//    pisteet[6] score;
//    pisteet[7] bonus;
//    pisteet[8] yksiPari;
//    pisteet[9] kaksiParia;
//    pisteet[10] kolmeSamaa;
//    pisteet[11] neljaSamaa;
//    pisteet[12] pieniSuora;
//    pisteet[13] suuriSuora;
//    pisteet[14] taysiKasi;
//    pisteet[15] yatzy;
//    pisteet[16] sattuma;
//    pisteet[17] total;
}
