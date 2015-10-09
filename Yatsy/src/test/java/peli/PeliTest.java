package peli;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Miia Rämö
 */
public class PeliTest {
    private Peli peli;
    
    @Before
    public void setUp() {
        this.peli = new Peli();
    }
    
    @Test
    public void noppienHeittoKasvattaaHeittojenMaaraa() {
        peli.noppienHeitto();
        assertEquals(1, peli.getHeitot());
    }
    
    @Test
    public void asettaaPisteetPelaajalleOikein() {
        peli.asetaPisteetPelaajalle(2, 0);
        assertEquals(2, peli.getPelaajanPisteet(0));
    }
    
    @Test
    public void eiHeitaNoppiaJosHeittojaOnJoKolme() {
        peli.setHeitot(3);
        peli.noppienHeitto();
        assertEquals(3, peli.getHeitot());
    }
    
    @Test
    public void pisteidenAsetusKasvattaaVuoronNumeroa() {
        peli.setVuoro(1);
        peli.asetaPisteetPelaajalle(1, 0);
        assertEquals(2, peli.getVuoro());
    }
}
