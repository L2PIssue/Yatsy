package gui;
/**
 *
 * @author Miia Rämö
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Nopanheittaja implements ActionListener {
    private Kayttoliittyma kali;
    
    public Nopanheittaja(Kayttoliittyma kali) {
        this.kali = kali;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        kali.getPeli().noppienHeitto();
        if (kali.getPeli().heittoja == 2) {
            kali.lukitseNoppienNapit();
        }
        kali.paivita();
    }
}
