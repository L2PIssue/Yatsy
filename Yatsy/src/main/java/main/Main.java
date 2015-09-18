
package main;

import gui.Kayttoliittyma;
import javax.swing.SwingUtilities;
/**
 *
 * @author Miia Rämö
 */
public class Main {

    public static void main(String[] args) {
        Kayttoliittyma kali = new Kayttoliittyma();
        SwingUtilities.invokeLater(kali);
       
    }

}
