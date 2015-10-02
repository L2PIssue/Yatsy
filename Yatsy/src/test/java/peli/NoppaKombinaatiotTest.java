package peli;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Miia Rämö
 */
public class NoppaKombinaatiotTest {
    private Noppa[] nopat;
    private NoppaKombinaatiot kombot;
    
    @Before
    public void setUp() {
        this.kombot = new NoppaKombinaatiot();
        this.nopat = new Noppa[5];
        for (int i = 0; i < nopat.length; i++) {
            nopat[i] = new Noppa();
        }
    }
    
    @Test
    public void pieniSuoraOikein() {
        for (int i = 0; i < 5; i++) {
            nopat[i].setSilmaluku(i + 1);
        }
        assertEquals(15, kombot.pieniSuora(nopat));
    }
}