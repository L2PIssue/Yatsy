package gui;
/**
 * noppien heiton suorittavan napin kuuntelija
 * @author Miia Rämö
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Nopanheittaja implements ActionListener {
    private final Kayttoliittyma kali;
    
    public Nopanheittaja(Kayttoliittyma kali) {
        this.kali = kali;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        kali.getPeli().noppienHeitto();
        if (kali.getPeli().getHeitot() == 2) {
            kali.lukitseNoppienNapit();
        }
        kali.paivita();
    }
}
