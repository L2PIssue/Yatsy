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
    
}
