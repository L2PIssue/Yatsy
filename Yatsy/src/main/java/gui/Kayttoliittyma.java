
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
import peli.Peli;

public class Kayttoliittyma implements Runnable {

    private ArrayList<String> pistekombot;
    private JButton[] noppiennapit;
    private JTextArea[] pisteet;
    private JFrame frame;
    private Scanner lukija;
    private Color tausta;
    private Peli peli;

    public Kayttoliittyma() {
        frame = new JFrame("Yatsy");
        this.tausta = new Color(55,176,107);
        this.lueTiedosto(new File("pistekombot.txt"));
        this.peli = new Peli();
    }

    @Override
    public void run() {
        frame.setPreferredSize(new Dimension(300, 500));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

    }

    private void luoKomponentit(Container container) {
        container.setBackground(tausta);
        container.add(pisteKombinaatiot(), BorderLayout.WEST);
        container.add(pisteSarake(), BorderLayout.CENTER);
        container.add(noppienNappulat(), BorderLayout.NORTH);
        container.add(noppienHeittoNappi(), BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
    }
    
    private JPanel pisteKombinaatiot() {
        JButton[] napit = new JButton[18];
        int apuluku = 0;
        JPanel kombinaatiot = new JPanel(new GridLayout(18, 1));
        kombinaatiot.setBackground(tausta);
        for (String kombo : pistekombot) {
            napit[apuluku] = new JButton(kombo);
            if (kombo.equals("Loppusumma") || kombo.equals("Välisumma") || kombo.equals("Bonus")) {
                napit[apuluku].setEnabled(false);
            }
            kombinaatiot.add(napit[apuluku]);
            apuluku++;
        }
        apuluku = 0;
        for (JButton nappi : napit) {
            nappi.addActionListener(new HalutunKombonKuuntelija(this, peli, pistekombot.get(apuluku)));
            apuluku++;
        }
        return kombinaatiot;
    }
    
    private JPanel pisteSarake() {
        JPanel pistesarake = new JPanel(new GridLayout(18, 1));
        pisteet = new JTextArea[17];
        pistesarake.setBackground(tausta);
        for (int i = 0; i < 18; i++) {
            pistesarake.add(new JTextArea(peli.getPelaajanPisteet(i) + ""));
        }
        
        
        return pistesarake;
    }
    
    private JPanel noppienNappulat() {
        JPanel nopat = new JPanel(new GridLayout(1, 5));
        noppiennapit = new JButton[5];
        for (int i = 0; i < 5; i++) {
            noppiennapit[i] = new JButton(peli.nopat[i] + "");
        }
        nopat.setBackground(tausta);
        for (int i = 0; i < 5; i++) {
            nopat.add(noppiennapit[i]);
        }
        
        return nopat;
    }
    
    public void lukitseNoppienNapit() {
        for (JButton nappi : noppiennapit) {
            nappi.setEnabled(false);
        }
    }
    
    public void vapautaNoppienNapit() {
        for (JButton nappi : noppiennapit) {
            nappi.setEnabled(true);
        }
    }
    
    public void paivita() {
        for (int i = 0; i < 5; i++) {
            this.noppiennapit[i].setText(peli.nopat[i] + "");
        }
        frame.repaint();
    }
    
    private JButton noppienHeittoNappi() {
        JButton nappi = new JButton("Heitä nopat");
        nappi.addActionListener(new Nopanheittaja(this, peli));
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
