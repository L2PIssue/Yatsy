package peli;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Miia Rämö
 */
public class NoppaTest {
    
    public NoppaTest() {
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
    public void noppaEiAluksiLukossa() {
        Noppa noppa = new Noppa();
        assertEquals(false, noppa.onkoLukittu());        
    }
    
    @Test
    public void vaihtaaLukituksenOikein() {
        Noppa noppa = new Noppa();
        noppa.muutaLukitus();
        assertEquals(true, noppa.onkoLukittu());
    }
    
}
