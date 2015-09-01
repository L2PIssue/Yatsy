
package peli;

import java.util.ArrayList;

/**
 *
 * @author Miia Rämö
 */
public class Heitto {
    private Noppa noppa;
    
    public Heitto() {
        this.noppa = new Noppa();
    }
    
    public void heitaNopat(int maara) {
        ArrayList<Integer> nopat = new ArrayList<>();
        for (int i = 0; i < maara; i++) {
            nopat.add(noppa.heitaNoppa());
        }
        for (Integer n : nopat) {
            System.out.println(n);
        }
    }
}
