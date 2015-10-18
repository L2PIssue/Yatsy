
package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;

/**
 * aloitusikkunan napin kuuntelija
 * @author Miia Rämö
 */
public class IlmoitusIkkunanKuuntelija implements ActionListener {
    private final IlmoitusIkkuna ikkuna;
    
    public IlmoitusIkkunanKuuntelija(IlmoitusIkkuna ikkuna) {
        this.ikkuna = ikkuna;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ikkuna.getKali() != null) {
            ikkuna.getKali().getFrame().dispose();
        }
        
        Kayttoliittyma kali = new Kayttoliittyma();
        SwingUtilities.invokeLater(kali);
        
        this.ikkuna.getFrame().dispose();
        
    }
}