
package main;

import gui.IlmoitusIkkuna;
import javax.swing.SwingUtilities;
/**
 *
 * @author Miia Rämö
 */
public class Main {

    public static void main(String[] args) {
        IlmoitusIkkuna ikkuna = new IlmoitusIkkuna(null, "Tervetuloa pelaamaan yatsya");
        SwingUtilities.invokeLater(ikkuna);
    }

}
