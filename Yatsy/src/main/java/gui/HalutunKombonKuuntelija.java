package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import peli.NoppaKombinaatiot;

/**
 *
 * @author Miia Rämö
 */
public class HalutunKombonKuuntelija  implements ActionListener {
    private final Kayttoliittyma kali;
    private final NoppaKombinaatiot kombot;
    private final String kombo;
    private final JButton nappi;
    
    public HalutunKombonKuuntelija (Kayttoliittyma kali, String kombo, JButton nappi) {
        this.kali = kali;
        this.kombot = new NoppaKombinaatiot();
        this.kombo = kombo;
        this.nappi = nappi;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (kombo) {
            case "Ykköset":
                kali.getPeli().asetaPisteetPelaajalle(kombot.kombotYkkosistaKutosiin(kali.getPeli().getNopat, 1), 0);
                break;
            case "Kakkoset":
                kali.getPeli().asetaPisteetPelaajalle(kombot.kombotYkkosistaKutosiin(kali.getPeli().getNopat, 2), 1);
                break;
            case "Kolmoset":
                kali.getPeli().asetaPisteetPelaajalle(kombot.kombotYkkosistaKutosiin(kali.getPeli().getNopat, 3), 2);
                break;
            case "Neloset":
                kali.getPeli().asetaPisteetPelaajalle(kombot.kombotYkkosistaKutosiin(kali.getPeli().getNopat, 4), 3);
                break;
            case "Vitoset":
                kali.getPeli().asetaPisteetPelaajalle(kombot.kombotYkkosistaKutosiin(kali.getPeli().getNopat, 5), 4);
                break;
            case "Kutoset":
                kali.getPeli().asetaPisteetPelaajalle(kombot.kombotYkkosistaKutosiin(kali.getPeli().getNopat, 6), 5);
                break;
            case "Yksi pari":
                kali.getPeli().asetaPisteetPelaajalle(kombot.yksiPari(kali.getPeli().getNopat), 8);
                break;
            case "Kaksi paria":
                kali.getPeli().asetaPisteetPelaajalle(kombot.kaksiParia(kali.getPeli().getNopat), 9);
                break;
            case "Kolme samaa":
                kali.getPeli().asetaPisteetPelaajalle(kombot.kolmeSamanlaista(kali.getPeli().getNopat), 10);
                break;
            case "Neljä samaa":
                kali.getPeli().asetaPisteetPelaajalle(kombot.neljaSamanlaista(kali.getPeli().getNopat), 11);
                break;
            case "Pieni suora":
                kali.getPeli().asetaPisteetPelaajalle(kombot.pieniSuora(kali.getPeli().getNopat), 12);
                break;
            case "Suuri suora":
                kali.getPeli().asetaPisteetPelaajalle(kombot.suuriSuora(kali.getPeli().getNopat), 13);
                break;
            case "Täyskäsi":
                kali.getPeli().asetaPisteetPelaajalle(kombot.tayskasi(kali.getPeli().getNopat), 14);
                break;
            case "Yatsy":
                kali.getPeli().asetaPisteetPelaajalle(kombot.yatsy(kali.getPeli().getNopat), 15);
                break;
            case "Sattuma":
                kali.getPeli().asetaPisteetPelaajalle(kombot.sattuma(kali.getPeli().getNopat), 16);
                break;
        }
        kali.getPeli().alustaNopat();
        nappi.setEnabled(false);
        kali.vapautaNoppienNapit();
        kali.paivita();
    }
} 
