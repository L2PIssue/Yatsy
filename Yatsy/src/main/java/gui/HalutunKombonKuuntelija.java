package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
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
    private JButton nappi;
    
    public HalutunKombonKuuntelija (Kayttoliittyma kali, Peli peli, String kombo, JButton nappi) {
        this.peli = peli;
        this.kali = kali;
        this.kombot = new NoppaKombinaatiot();
        this.kombo = kombo;
        this.nappi = nappi;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (kombo) {
            case "Ykköset":
                peli.asetaPisteetPelaajalle(kombot.kombotYkkosistaKutosiin(peli.nopat, 1), 0);
                break;
            case "Kakkoset":
                peli.asetaPisteetPelaajalle(kombot.kombotYkkosistaKutosiin(peli.nopat, 2), 1);
                break;
            case "Kolmoset":
                peli.asetaPisteetPelaajalle(kombot.kombotYkkosistaKutosiin(peli.nopat, 3), 2);
                break;
            case "Neloset":
                peli.asetaPisteetPelaajalle(kombot.kombotYkkosistaKutosiin(peli.nopat, 4), 3);
                break;
            case "Vitoset":
                peli.asetaPisteetPelaajalle(kombot.kombotYkkosistaKutosiin(peli.nopat, 5), 4);
                break;
            case "Kutoset":
                peli.asetaPisteetPelaajalle(kombot.kombotYkkosistaKutosiin(peli.nopat, 6), 5);
                break;
            case "Yksi pari":
                peli.asetaPisteetPelaajalle(kombot.yksiPari(peli.nopat), 8);
                break;
            case "Kaksi paria":
                peli.asetaPisteetPelaajalle(kombot.kaksiParia(peli.nopat), 9);
                break;
            case "Kolme samaa":
                peli.asetaPisteetPelaajalle(kombot.kolmeSamanlaista(peli.nopat), 10);
                break;
            case "Neljä samaa":
                peli.asetaPisteetPelaajalle(kombot.neljaSamanlaista(peli.nopat), 11);
                break;
            case "Pieni suora":
                peli.asetaPisteetPelaajalle(kombot.pieniSuora(peli.nopat), 12);
                break;
            case "Suuri suora":
                peli.asetaPisteetPelaajalle(kombot.suuriSuora(peli.nopat), 13);
                break;
            case "Täyskäsi":
                peli.asetaPisteetPelaajalle(kombot.taysikasi(peli.nopat), 14);
                break;
            case "Yatsy":
                peli.asetaPisteetPelaajalle(kombot.yatsy(peli.nopat), 15);
                break;
            case "Sattuma":
                peli.asetaPisteetPelaajalle(kombot.sattuma(peli.nopat), 16);
                break;
        }
        peli.alustaNopat();
        nappi.setEnabled(false);
        kali.vapautaNoppienNapit();
        kali.paivita();
    }
} 
