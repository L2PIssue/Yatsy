
package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;

/**
 *
 * @author Miia Rämö
 */
public class IlmoitusIkkunanKuuntelija implements ActionListener {
    private Kayttoliittyma vanha;
    private IlmoitusIkkuna ikkuna;
    
    public IlmoitusIkkunanKuuntelija(Kayttoliittyma vanha, IlmoitusIkkuna ikkuna) {
        this.vanha = vanha;
        this.ikkuna = ikkuna;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (vanha != null) {
            vanha.getFrame().dispose();
        }
        
        Kayttoliittyma kali = new Kayttoliittyma();
        SwingUtilities.invokeLater(kali);
        
        this.ikkuna.getFrame().dispose();
        
    }
}