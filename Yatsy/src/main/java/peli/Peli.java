package peli;
/**
 * luokka, joka sisältää pelilogiikan
 * @author Miia Rämö
 */
public class Peli {
    private final Pelaaja pelaaja;
    private Noppa[] nopat;
    private int heittoja;
    private int vuoro;
    
    public Peli() {
        this.alustaNopat();
        this.pelaaja = new Pelaaja();
        this.vuoro = 0;
    }
    
    public Noppa[] getNopat() {
        return this.nopat;
    }
    
    public int getHeitot() {
        return this.heittoja;
    }
    
    public void setHeitot(int luku) {
        this.heittoja = luku;
    }
    
    public int getVuoro() {
        return this.vuoro;
    }
    
    public void setVuoro(int luku) {
        this.vuoro = luku;
    }
    
    public final void alustaNopat() {
        this.heittoja = 0;
        this.nopat = new Noppa[5];
        for (int i = 0; i < 5; i++) {
            nopat[i] = new Noppa();
        }   
    }
    
    /**
     * kutsuu Noppa-olioiden heittometodia
     */
    public void noppienHeitto() {
        if (heittoja < 3) {
            for (Noppa noppa : nopat) {
                noppa.heitaNoppa();
            }
            heittoja++;
        }
    }
    
    /**
     * kutsuu Pelaaja-olion pisteiden asetus -metosia
     * @param paljonko lisättävä määrä
     * @param mihin haluttu lokaatio pelaajan pistetaulukossa
     */
    public void asetaPisteetPelaajalle(int paljonko, int mihin) {
        pelaaja.asetaPisteet(paljonko, mihin);
        vuoro++;
    }
    
    /**
     * @param index tutkittava lokaatio
     * @return pisteet valitussa lokaatiossa
     */
    public int getPelaajanPisteet(int index) {
        return pelaaja.getPisteet(index);
    }
}
