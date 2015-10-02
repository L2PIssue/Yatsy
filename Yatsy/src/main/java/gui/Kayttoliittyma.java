
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
import java.awt.Label;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import peli.Peli;

public class Kayttoliittyma implements Runnable {

    private ArrayList<String> pistekombot;
    private JButton[] noppiennapit;
    private JTextField[] pisteet;
    private ImageIcon[] kuvat;
    private JFrame frame;
    private Scanner lukija;
    private Color tausta;
    private Peli peli;
    private Container container;
    public JButton heittonappi;
    private IlmoitusIkkuna ilmoitus;

    public Kayttoliittyma() {
        frame = new JFrame("Yatsy");
        this.tausta = new Color(55,176,107);
        this.lueTiedosto(new File("pistekombot.txt"));
        this.peli = new Peli();
        this.heittonappi = new JButton("Heitä nopat");
        this.heittonappi.addActionListener(new Nopanheittaja(this, peli));
        this.kuvat = new ImageIcon[12];
        for (int i = 0; i < 12; i++) {
            kuvat[i] = new ImageIcon("Grafiikat/noppa" + (i+1) + ".png");
        }
    }

    @Override
    public void run() {
        frame.setPreferredSize(new Dimension(300, 540));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
    }

    private void luoKomponentit(Container container) {
        container.setBackground(tausta);
        container.add(pisteKombinaatiot(), BorderLayout.WEST);
        container.add(pisteSarake(), BorderLayout.CENTER);
        container.add(noppienNappulat(), BorderLayout.NORTH);
        container.add(heittonappi, BorderLayout.SOUTH);
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
            nappi.addActionListener(new HalutunKombonKuuntelija(this, pistekombot.get(apuluku), nappi));
            apuluku++;
        }
        return kombinaatiot;
    }
    
    private JPanel pisteSarake() {
        JPanel pistesarake = new JPanel(new GridLayout(18, 1));
        pisteet = new JTextField[18];
        pistesarake.setBackground(tausta);
        for (int i = 0; i < 18; i++) {
            pisteet[i] = new JTextField(peli.getPelaajanPisteet(i) + "");
            pisteet[i].setEditable(false);
            pistesarake.add(pisteet[i]);
        }
        return pistesarake;
    }
    
    private JPanel noppienNappulat() {
        JPanel nopat = new JPanel(new GridLayout(1, 5));
        noppiennapit = new JButton[5];
        for (int i = 0; i < 5; i++) {
            noppiennapit[i] = new JButton();
            noppiennapit[i].addActionListener(new Nopankuuntelija(this, i));
        }
        this.asetaNopilleKuvat();
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
        heittonappi.setEnabled(false);
    }
    
    public void vapautaNoppienNapit() {
        for (JButton nappi : noppiennapit) {
            nappi.setEnabled(true);
        }
        heittonappi.setEnabled(true);
    }
    
    public void paivita() {
        if (peli.vuoro == 15) {
            this.ilmoitus = new IlmoitusIkkuna(this, "Lopputuloksesi on " + peli.getPelaajanPisteet(17) + " pistettä.");
        }
        for (int i = 0; i < 5; i++) {
            this.asetaNopilleKuvat();
            if (peli.heittoja == 2) {
                if (peli.nopat[i].onkoLukittu()) {
                    peli.nopat[i].muutaLukitus();
                }
            }
        }
        for (int i = 0; i < 18; i++) {
            this.pisteet[i].setText(peli.getPelaajanPisteet(i) + "");
        }
        frame.repaint();
    }
    
    private void asetaNopilleKuvat() {
        for (int i = 0; i < 5; i++) {
            if (peli.nopat[i].onkoLukittu()) {
                noppiennapit[i].setIcon(kuvat[peli.nopat[i].getSilmaluku() - 1 + 6]);
            } else {
                noppiennapit[i].setIcon(kuvat[peli.nopat[i].getSilmaluku() - 1]);
                noppiennapit[i].setAlignmentX(Label.CENTER);
                noppiennapit[i].setAlignmentY(Label.CENTER);
            }
        }
    }

    public JFrame getFrame() {
        return frame;
    }
    
    public Peli getPeli() {
        return this.peli;
    }
    
    private ArrayList<String> lueTiedosto(File tiedosto) { 
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
