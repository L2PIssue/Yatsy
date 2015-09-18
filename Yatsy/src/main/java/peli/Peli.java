package peli;
/**
 *
 * @author Miia Rämö
 */
public class Peli {
    private Pelaaja pelaaja;
    public Noppa[] nopat;
    private NoppaKombinaatiot kombinaatiot;
    private int heittoja;
    private int kierros;
    
    public Peli() {
        this.alustaNopat();
        this.pelaaja = new Pelaaja();
        this.kombinaatiot = new NoppaKombinaatiot();
        this.heittoja = 0;
        this.kierros = 0;
    }
    
    private void alustaNopat() {
        nopat = new Noppa[5];
        for (int i = 0; i < 5; i++) {
            nopat[i] = new Noppa();
        }   
    }
    
    public void noppienHeitto() {
        if (heittoja < 3 || kierros < 15) {
            for (Noppa noppa : nopat) {
                noppa.heitaNoppa();
            }
            heittoja++;
        }
    }
    
    public void tulostaNopat() {
        for (Noppa noppa : nopat) {
            System.out.print(noppa.toString() + " ");
        }
        System.out.println("");
    }
}
