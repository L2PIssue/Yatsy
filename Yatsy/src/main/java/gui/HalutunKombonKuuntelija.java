package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import peli.NoppaKombinaatiot;
import peli.Peli;

/**
 *
 * @author Miia Rämö
 */
public class HalutunKombonKuuntelija  implements ActionListener {
    private Peli peli;
    private Kayttoliittyma kali;
    private NoppaKombinaatiot kombot;
    private String kombo;
    
    public HalutunKombonKuuntelija (Kayttoliittyma kali, Peli peli, String kombo) {
        this.peli = peli;
        this.kali = kali;
        this.kombot = new NoppaKombinaatiot();
        this.kombo = kombo;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (kombo) {
            case "Ykköset":
                peli.asetaPisteetPelaajalle(kombot.kombotYkkosistaKutosiin(peli.getNopat(), 1), 0);
                break;
            case "Kakkoset":
                peli.asetaPisteetPelaajalle(kombot.kombotYkkosistaKutosiin(peli.getNopat(), 2), 1);
                break;
            case "Kolmoset":
                peli.asetaPisteetPelaajalle(kombot.kombotYkkosistaKutosiin(peli.getNopat(), 3), 2);
                break;
            case "Neloset":
                peli.asetaPisteetPelaajalle(kombot.kombotYkkosistaKutosiin(peli.getNopat(), 4), 3);
                break;
            case "Vitoset":
                peli.asetaPisteetPelaajalle(kombot.kombotYkkosistaKutosiin(peli.getNopat(), 5), 4);
                break;
            case "Kutoset":
                peli.asetaPisteetPelaajalle(kombot.kombotYkkosistaKutosiin(peli.getNopat(), 6), 5);
                break;
            case "Yksi pari":
                peli.asetaPisteetPelaajalle(kombot.yksiPari(peli.getNopat()), 8);
                break;
            case "Kaksi paria":
                peli.asetaPisteetPelaajalle(kombot.kaksiParia(peli.getNopat()), 9);
                break;
            case "Kolme samaa":
                peli.asetaPisteetPelaajalle(kombot.kolmeSamanlaista(peli.getNopat()), 10);
                break;
            case "Neljä samaa":
                peli.asetaPisteetPelaajalle(kombot.neljaSamanlaista(peli.getNopat()), 11);
                break;
            case "Pieni suora":
                peli.asetaPisteetPelaajalle(kombot.pieniSuora(peli.getNopat()), 12);
                break;
            case "Suuri suora":
                peli.asetaPisteetPelaajalle(kombot.suuriSuora(peli.getNopat()), 13);
                break;
            case "Täyskäsi":
                peli.asetaPisteetPelaajalle(kombot.taysikasi(peli.getNopat()), 14);
                break;
            case "Yatsy":
                peli.asetaPisteetPelaajalle(kombot.yatsy(peli.getNopat()), 15);
                break;
            case "Sattuma":
                peli.asetaPisteetPelaajalle(kombot.sattuma(peli.getNopat()), 16);
                break;
        }
        peli.nollaaHeitot();
        kali.vapautaNoppienNapit();
        kali.paivita();
    }
} 
