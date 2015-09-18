
package gui;
/**
 *
 * @author Miia Rämö
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class Kayttoliittyma implements Runnable {

    private ArrayList<String> pistekombot;
    private JFrame frame;
    private Scanner lukija;
    private Color tausta;

    public Kayttoliittyma() {
        this.tausta = new Color(55,176,107);
        this.lueTiedosto(new File("pistekombot.txt"));
    }

    @Override
    public void run() {
        frame = new JFrame("Yatsy");
        frame.setPreferredSize(new Dimension(300, 500));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        container.setBackground(tausta);
        container.add(pisteKombinaatiot(), BorderLayout.WEST);
        container.add(pisteSarake(), BorderLayout.CENTER);
        container.add(noppienNappulat(), BorderLayout.NORTH);
        container.add(noppienHeittoNappi(), BorderLayout.SOUTH);
    }
    
    private JPanel pisteKombinaatiot() {
        JPanel kombinaatiot = new JPanel(new GridLayout(18, 1));
        kombinaatiot.setBackground(tausta);
        for (String kombo : pistekombot) {
            kombinaatiot.add(new JButton(kombo));
//            if (kombo.equals("Välisumma") || kombo.equals("Bonus") || kombo.equals("Loppusumma")) {
//                
//            }
        }
        return kombinaatiot;
    }
    
    private JPanel pisteSarake() {
        JPanel pistesarake = new JPanel(new GridLayout(18, 1));
        pistesarake.setBackground(tausta);
        for (int i = 0; i < 18; i++) {
            
            pistesarake.add(new JTextArea("0"));
        }
        
        return pistesarake;
    }
    
    private JPanel noppienNappulat() {
        JPanel nopat = new JPanel(new GridLayout(1, 5));
        nopat.setBackground(tausta);
        for (int i = 0; i < 5; i++) {
            nopat.add(new JButton());
        }
        
        return nopat;
    }
    
    private JButton noppienHeittoNappi() {
        JButton nappi = new JButton("Heitä nopat");
        nappi.addActionListener(new Nopanheittaja());
        return nappi;
    }

    public JFrame getFrame() {
        return frame;
    }
    
    public ArrayList<String> lueTiedosto(File tiedosto) { 
        this.pistekombot = new ArrayList();
        try {
            lukija = new Scanner(tiedosto);
        } catch (Exception e) {
            System.out.println("Tiedoston lukeminen epäonnistui. Virhe: " + e.getMessage());
            return pistekombot; 
        }
        while (lukija.hasNextLine()) {
            String rivi = lukija.nextLine();
            this.pistekombot.add(rivi);
        }
        lukija.close();
        return pistekombot;
    }
    
}
