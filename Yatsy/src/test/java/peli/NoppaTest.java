package peli;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Miia Rämö
 */
public class NoppaTest {
    private Noppa noppa;
    
    @Before
    public void setUp() {
        this.noppa = new Noppa();
    }
    
    @Test
    public void noppaEiAluksiLukossa() {
        assertEquals(false, noppa.onkoLukittu());        
    }
    
    @Test
    public void vaihtaaLukituksenOikein() {
        noppa.muutaLukitus();
        assertEquals(true, noppa.onkoLukittu());
    }
    
    @Test
    public void heittaakoLukujaOikealtaValilta() {
        for (int i = 0; i < 100; i++) {
            noppa.heitaNoppa();
            int luku = noppa.getSilmaluku();
            assertEquals(true, luku > 0 && luku < 7);
        }
    }
    
}
