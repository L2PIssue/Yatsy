package peli;
/**
 * luokka, joka sisältää pelilogiikan
 * @author Miia Rämö
 */
public class Peli {
    private final Pelaaja pelaaja;
    public Noppa[] getNopat;
    private final NoppaKombinaatiot kombinaatiot;
    /**
     * heittojen määrä, nollataan vuorojen välissä
     */
    public int heittoja;
    /**
     * tällä voidaan seurata, missä vaiheessa peliä ollaan
     */
    public int vuoro;
    
    public Peli() {
        this.alustaNopat();
        this.pelaaja = new Pelaaja();
        this.kombinaatiot = new NoppaKombinaatiot();
        this.vuoro = 0;
    }
    
    public Noppa[] getNopat() {
        return this.getNopat;
    }
    
    /**
     * 
     */
    public final void alustaNopat() {
        this.heittoja = 0;
        getNopat = new Noppa[5];
        for (int i = 0; i < 5; i++) {
            getNopat[i] = new Noppa();
        }   
    }
    
    /**
     * kutsuu Noppa-olioiden heittometodia
     */
    public void noppienHeitto() {
        if (heittoja < 3) {
            for (Noppa noppa : getNopat) {
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
