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
    public void pieniSuoraOikeillaLuvuilla() {
        nopatYhdestaViiteen();
        assertEquals(15, kombot.pieniSuora(nopat));
    }
    
    @Test
    public void pieniSuoraVaarillaLuvuillaAntaaNollan() {
        for (int i = 0; i < 5; i++) {
            nopat[i].setSilmaluku(1);
        }
        assertEquals(0, kombot.pieniSuora(nopat));
    }
    
    @Test
    public void suuriSuoraOikeillaLuvuilla() {
        for (int i = 0; i < 5; i++) {
            nopat[i].setSilmaluku(i + 2);
        }
        assertEquals(20, kombot.suuriSuora(nopat));
    }
    
    @Test
    public void suuriSuoraVaarillaLuvuillaAntaaNollan() {
        for (int i = 0; i < 5; i++) {
            nopat[i].setSilmaluku(1);
        }
        assertEquals(0, kombot.suuriSuora(nopat));
    }
    
    @Test
    public void kombotYkkosistaKutosiin() {
        for (int i = 0; i < 5; i++) {
            nopat[i].setSilmaluku(1);
        }
        assertEquals(5, kombot.kombotYkkosistaKutosiin(nopat, 1));
    }
    
    @Test
    public void kolmeSamaaLukuaAntavatOikeatPisteet() {
        for (int i = 0; i < 3; i++) {
            nopat[i].setSilmaluku(5);
        }
        for (int i = 4; i < 5; i++) {
            nopat[i].setSilmaluku(2);
        }
        assertEquals(15, kombot.kolmeSamanlaista(nopat));
    }
    
    @Test
    public void antaaNollanJosEiLöydyKolmeaSamaa() {
        nopatYhdestaViiteen();
        assertEquals(0, kombot.kolmeSamanlaista(nopat));
    }
    
    @Test
    public void neljaSamaaLukuaAntavatOikeatPisteet() {
        for (int i = 0; i < 5; i++) {
            nopat[i].setSilmaluku(5);
        }
        assertEquals(20, kombot.neljaSamanlaista(nopat));
    }
    
    @Test
    public void antaaNollanJosEiLöydyNeljaaSamaa() {
        nopatYhdestaViiteen();
        assertEquals(0, kombot.neljaSamanlaista(nopat));
    }
    
    @Test
    public void yksiPariAntaaOikeatPisteet() {
        for (int i = 0; i < 2; i++) {
            nopat[i].setSilmaluku(5);
        }
        for (int i = 2; i < 5; i++) {
            nopat[i].setSilmaluku(3);
        }
        assertEquals(10, kombot.yksiPari(nopat));
    }
    
    @Test
    public void antaaNollanJosEiOleParia() {
        nopatYhdestaViiteen();
        assertEquals(0, kombot.yksiPari(nopat));
    }
    
    @Test
    public void kaksiPariaAntavatOikeatPisteet() {
        for (int i = 0; i < 2; i++) {
            nopat[i].setSilmaluku(4);
        }
        for (int i = 2; i < 4; i++) {
            nopat[i].setSilmaluku(5);
        }
        assertEquals(18, kombot.kaksiParia(nopat));
    }
    
    @Test
    public void antaaNollanJosEiLoydyKahtaParia() {
        nopatYhdestaViiteen();
        assertEquals(0, kombot.kaksiParia(nopat));
    }
    
    @Test
    public void taysKasiAntaaOikeatPisteet() {
        for (int i = 0; i < 2; i++) {
            nopat[i].setSilmaluku(1);
        }
        for (int i = 2; i < 5; i++) {
            nopat[i].setSilmaluku(2);
        }
        assertEquals(8, kombot.tayskasi(nopat));
    }
    
    @Test
    public void taysKasiAntaaNollanVaarillaLuvuilla() {
        nopatYhdestaViiteen();
        assertEquals(0, kombot.tayskasi(nopat));
    }
    
    @Test
    public void yatsyAntaaOikeatPisteet() {
        for (int i = 0; i < 5; i++) {
            nopat[i].setSilmaluku(1);
        }
        assertEquals(50, kombot.yatsy(nopat));
    }
    
    @Test
    public void yatsyVaarillaLuvuillaAntaaNollan() {
        nopatYhdestaViiteen();
        assertEquals(0, kombot.yatsy(nopat));
    }
    
    @Test
    public void sattumaAntaaOikeatPisteet() {
        nopatYhdestaViiteen();
        assertEquals(15, kombot.sattuma(nopat));
    }

    private void nopatYhdestaViiteen() {
        for (int i = 0; i < 5; i++) {
            nopat[i].setSilmaluku(i + 1);
        }
    }
}