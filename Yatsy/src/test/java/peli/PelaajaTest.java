package peli;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Miia Rämö
 */
public class PelaajaTest {
    private Pelaaja pelaaja;
    
    @Before
    public void setUp() {
        this.pelaaja = new Pelaaja();
    }
    
    @Test
    public void pisteetAsetetaanOikeinTaulukkoon() {
        pelaaja.asetaPisteet(2, 0);
        assertEquals(2, pelaaja.getPisteet(0));
    }
    
    @Test
    public void laskeeLoppusummanOikein() {
        for (int i = 0; i < 6; i++) {
            pelaaja.asetaPisteet(1, i);
        }
        for (int i = 8; i < 17; i++) {
            pelaaja.asetaPisteet(1, i);
        }
        assertEquals(15, pelaaja.getLoppusumma());
    }
    
    @Test
    public void laskeeValisummanOikein() {
        for (int i = 0; i < 6; i++) {
            pelaaja.asetaPisteet(1, i);
        }
        assertEquals(6, pelaaja.getValisumma());
    }
    
    @Test
    public void asettaaPelaajalleBonuksenJosTarpeeksiPisteita() {
        pelaaja.asetaPisteet(63, 0);
        assertEquals(50, pelaaja.getPisteet(7));
    }
    
    @Test
    public void eiAsetaBonustaTurhaan() {
        pelaaja.asetaPisteet(61, 0);
        assertEquals(0, pelaaja.getPisteet(7));
    }
    
    @Test
    public void eiAsetaNegatiivisiaPisteita() {
        pelaaja.asetaPisteet(-2, 0);
        assertEquals(false, pelaaja.getOnkoLisatty(0));
    }
}
