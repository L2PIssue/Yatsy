package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import peli.Peli;

/**
 *
 * @author Miia Rämö
 */
public class HalutunKombonKuuntelija  implements ActionListener {
    private Peli peli;
    private Kayttoliittyma kali;
    
    public HalutunKombonKuuntelija (Kayttoliittyma kali, Peli peli) {
        this.peli = peli;
        this.kali = kali;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        peli.noppienHeitto();
        kali.paivita();
    }
} 
