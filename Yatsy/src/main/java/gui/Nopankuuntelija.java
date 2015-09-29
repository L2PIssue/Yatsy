package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import peli.Peli;
/**
 *
 * @author Miia Rämö
 */
public class Nopankuuntelija implements ActionListener {
    private final Peli peli;
    private int numero;
    
    public Nopankuuntelija(Peli peli, int numero) {
        this.peli = peli;
        this.numero = numero;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        peli.nopat[numero].muutaLukitus();
    }
}
