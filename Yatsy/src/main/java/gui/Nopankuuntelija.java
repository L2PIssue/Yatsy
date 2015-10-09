package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * kuuntelee noppien painalluksia ja muuttaa niiden lukituksen
 * @author Miia Rämö
 */
public class Nopankuuntelija implements ActionListener {
    private final int numero;
    private final Kayttoliittyma kali;
    
    public Nopankuuntelija(Kayttoliittyma kali, int numero) {
        this.numero = numero;
        this.kali = kali;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        kali.getPeli().getNopat()[numero].muutaLukitus();
        kali.paivita();
    }
}
