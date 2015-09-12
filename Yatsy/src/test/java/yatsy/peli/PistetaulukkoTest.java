package peli;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static peli.NoppaKombinaatiot.*;

/**
 *
 * @author Miia Rämö
 */
public class PistetaulukkoTest {
    
    public PistetaulukkoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void alustaaTaulunOikein() {
        Pistetaulukko taulu = new Pistetaulukko();
        assertEquals("LOPPUSUMMA 0", taulu.tulostaRivi(LOPPUSUMMA));
    }
    
    @Test
    public void tulostaaRivinOikein() {
        Pistetaulukko taulu = new Pistetaulukko();
        assertEquals("YKKOSET 0", taulu.tulostaRivi(YKKOSET));
    }

    @Test
    public void asettaakoPisteetOikein() {
        Pistetaulukko taulu = new Pistetaulukko();
        Enum sarake = YKKOSET;
        taulu.asetaPisteet(sarake, 6);
        assertEquals("YKKOSET 6", taulu.tulostaRivi(YKKOSET));
    }
   
}
