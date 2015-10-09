
package main;

import gui.IlmoitusIkkuna;
import javax.swing.SwingUtilities;
/**
 * käynnistää ikkunan, josta pelin pääsee käynnistämään
 * @author Miia Rämö
 */
public class Main {

    public static void main(String[] args) {
        IlmoitusIkkuna ikkuna = new IlmoitusIkkuna(null, "Tervetuloa pelaamaan yatsya");
        SwingUtilities.invokeLater(ikkuna);
    }

}
