package gui;
/**
 *
 * @author Miia Rämö
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import peli.Kasi;
import peli.Noppa;
import peli.Peli;

public class Nopanheittaja implements ActionListener {
    private Peli peli = new Peli();

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        peli.noppienHeitto();
        peli.tulostaNopat();
    }
}
