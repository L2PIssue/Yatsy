package peli;
/**
 *
 * @author Miia Rämö
 */
public class Peli {
    private Pelaaja pelaaja;
    public Noppa[] nopat;
    private NoppaKombinaatiot kombinaatiot;
    public int heittoja;
    
    public Peli() {
        this.alustaNopat();
        this.pelaaja = new Pelaaja();
        this.kombinaatiot = new NoppaKombinaatiot();
        this.heittoja = 0;
    }
    
    private void alustaNopat() {
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
    
    public Noppa[] getNopat() {
        return nopat;
    }
    
    public void asetaPisteetPelaajalle(int paljonko, int mihin) {
        pelaaja.asetaPisteet(paljonko, mihin);
    }
    
    public int getPelaajanPisteet(int index) {
        return pelaaja.getPisteet(index);
    }
    
    public void nollaaHeitot() {
        this.heittoja = 0;
    }
    
    
}
