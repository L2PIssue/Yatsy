package gui;

import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
/**
 * toimii ikkunana, josta uusi peli käynnistetään, pelin jälkeen ilmoittaa lopputuloksen
 * @author Miia Rämö
 */
public class IlmoitusIkkuna implements Runnable {
    private final Kayttoliittyma kali;
    private final JFrame frame = new JFrame("Yatsy");
    private final JPanel panel = new JPanel();
    private final JButton aloituspainike;

    public IlmoitusIkkuna(Kayttoliittyma kali, String ilmoitus) {
        this.kali = kali;
        aloituspainike = new JButton("Aloita uusi peli");
        aloituspainike.addActionListener(new IlmoitusIkkunanKuuntelija(this));
        panel.setLayout(new BorderLayout());
        panel.add(new JLabel(ilmoitus), BorderLayout.CENTER);
        panel.add(aloituspainike, BorderLayout.SOUTH);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setSize(300, 100);
        frame.setVisible(true);
    }

    @Override
    public void run() {
        
    }
    
    public JFrame getFrame() {
        return this.frame;
    }
    
    public Kayttoliittyma getKali() {
        return this.kali;
    }
    
}
   