package peli;
/**
 *
 * @author Miia Rämö
 */
public class Peli {
    private final Pelaaja pelaaja;
    public Noppa[] nopat;
    private final NoppaKombinaatiot kombinaatiot;
    public int heittoja;
    public int vuoro;
    
    public Peli() {
        this.alustaNopat();
        this.pelaaja = new Pelaaja();
        this.kombinaatiot = new NoppaKombinaatiot();
        this.vuoro = 0;
    }
    
    public final void alustaNopat() {
        this.heittoja = 0;
        nopat = new Noppa[5];
        for (int i = 0; i < 5; i++) {
            nopat[i] = new Noppa();
        }   
    }
    
    public void noppienHeitto() {
        if (heittoja < 3) {
            for (Noppa noppa : nopat) {
                noppa.heitaNoppa();
            }
            heittoja++;
        }
    }
    
    public void asetaPisteetPelaajalle(int paljonko, int mihin) {
        pelaaja.asetaPisteet(paljonko, mihin);
        vuoro++;
    }
    
    public int getPelaajanPisteet(int index) {
        return pelaaja.getPisteet(index);
    }
    
    public void nollaaHeitot() {
        this.heittoja = 0;
    }
}
