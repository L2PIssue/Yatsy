package gui;
/**
 *
 * @author Miia Rämö
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import peli.Peli;

public class Nopanheittaja implements ActionListener {
    private Peli peli;
    private Kayttoliittyma kali;
    
    public Nopanheittaja(Kayttoliittyma kali, Peli peli) {
        this.peli = peli;
        this.kali = kali;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        peli.noppienHeitto();
        if (peli.heittoja == 3) {
            kali.lukitseNoppienNapit();
        }
        kali.paivita();
    }
}
