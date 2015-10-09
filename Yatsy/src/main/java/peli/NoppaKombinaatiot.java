
package peli;

import java.util.ArrayList;

/**
 * luokka, jolla tutkitaan sopiiko noppakombinaatio valittuun pistetaulukon ruutuun
 * @author Miia Rämö
 */

public class NoppaKombinaatiot {
    
    /**
     * tutkii ovatko noppien silmäluvut 1, 2, 3, 4 ja 5
     * @param nopat tutkittavat nopat
     * @return 15, jos kombinaatio sopii ruutuun,  muutoin 0
     */
    public int pieniSuora(Noppa[] nopat) {
        ArrayList<Integer> luvut = new ArrayList();
        for (int i = 0; i < 5; i++) {
            luvut.add(nopat[i].getSilmaluku());
        }
        if (luvut.contains(1) && luvut.contains(2) && luvut.contains(3)
                && luvut.contains(4) && luvut.contains(5)) {
            return 15;
        }
        return 0;
    }

    /**
     * tutkii ovatko noppien silmäluvut 2, 3, 4, 5 ja 6
     * @param nopat tutkittavat nopat
     * @return 20, jos kombinaatio sopii ruutuun, muutoin 0
     */
    public int suuriSuora(Noppa[] nopat) {
        ArrayList<Integer> luvut = new ArrayList();
        for (int i = 0; i < 5; i++) {
            luvut.add(nopat[i].getSilmaluku());
        }
        if (luvut.contains(2) && luvut.contains(3) && luvut.contains(4)
                && luvut.contains(5) && luvut.contains(6)) {
            return 20;
        }
        return 0;
    }

    /**
     * tutkii montako kappaletta annettua silmälukua on noppien joukossa
     * @param nopat tutkittavat nopat
     * @param numero tutkittava silmäluku
     * @return sijoitettavat pisteet
     */
    public int kombotYkkosistaKutosiin(Noppa[] nopat, int numero) {
        int summa = 0;
        for (Noppa noppa : nopat) {
            if (noppa.getSilmaluku() == numero) {
                summa += numero;
            }
        }
        return summa;
    }
    
    /**
     * käytetään apuna muita kombinaatioita tutkittaessa,
     * jotta nähdään montako jotain lukua on noppien joukossa
     * @param nopat tutkittavat nopat
     * @param numero tutkittava silmäluku
     * @return löydettyjen samojen silmälukujen määrä
     */
    private int montakoSamaaNumeroa(Noppa[] nopat, int numero) {
        int maara = 0;
        for (Noppa noppa : nopat) {
            if (noppa.getSilmaluku() == numero) {
                maara++;
            }
        }
        return maara;
    }

    /**
     * tutkii suurimmasta pienimpään, löytyykö noppien joukosta kolme samaa silmälukua
     * @param nopat tutkittavat nopat
     * @return nolla jos ei löydy kolmea tai enemmän, muuten silmälukujen summa
     */
    public int kolmeSamanlaista(Noppa[] nopat) {
        int summa = 0;
        for (int i = 6; i > 0; i--) {
            if (montakoSamaaNumeroa(nopat, i) >= 3) {
                summa = 3 * i;
                return summa;
            }
        }
        return summa;
    }
    
    /**
     * tutkii suurimmasta pienimpään, löytyykö noppien joukosta neljä samaa silmälukua
     * @param nopat tutkittavat nopat
     * @return nolla jos ei löydy neljää tai enemmän, muuten silmälukujen summa
     */
    public int neljaSamanlaista(Noppa[] nopat) {
        int summa = 0;
        for (int i = 6; i > 0; i--) {
            if (montakoSamaaNumeroa(nopat, i) >= 4) {
                summa = 4 * i;
                return summa;
            }
        }
        return summa;
    }
    
    /**
     * tutkii suurimmasta pienimpään, löytyykö noppien joukosta pari
     * @param nopat tutkittavat nopat
     * @return nolla jos ei löydy kahta tai useampaa, muuten parin silmälukujen summa
     */
    public int yksiPari(Noppa[] nopat) {
        for (int i = 6; i >= 1; i--) {
            if (montakoSamaaNumeroa(nopat, i) >= 2) {
                return i * 2;
            }
        }
        return 0;
    }
    
    /**
     * tutkii suurimmasta pienimpään, löytyykö noppien joukosta kaksi eri silmälukujen paria
     * @param nopat tutkittavat nopat
     * @return nolla jos ei löydy pareja, muuten parien silmälukujen summa
     */
    public int kaksiParia(Noppa[] nopat) {
        int parienMaara = 0;
        int summa = 0;
        for (int i = 6; i >= 1; i--) {
            if (montakoSamaaNumeroa(nopat, i) >= 2) {
                if (parienMaara == 1) {
                    summa += 2 * i;
                    return summa;
                }
                summa += i * 2;
                parienMaara = 1;
            }
        }
        return 0;
    }
    
    /**
     * tutkii suurimmasta pienimpään, löytyykö noppien joukosta kolme samaa silmälukua
     * sekä jonkin toisen silmäluvun muodostama pari
     * @param nopat tutkittavat nopat
     * @return nolla jos ei löydy paria sekä kolmea, muuten silmälukujen summa
     */
    public int tayskasi(Noppa[] nopat) {
        int montakoLoydetty = 0;
        int summa = 0;
        for (int i = 6; i >= 1; i--) {
            if (montakoSamaaNumeroa(nopat, i) == 3) {
                if (montakoLoydetty == 2) {
                    summa += 3 * i;
                    return summa;
                }
                montakoLoydetty += 3;
                summa += 3 * i;
            } else if (montakoSamaaNumeroa(nopat, i) == 2) {
                if (montakoLoydetty == 3) {
                    summa += 2 * i;
                    return summa;
                }
                montakoLoydetty += 2;
                summa += 2 * i;
            }
        }
        return 0;
    }

    /**
     * tutkii ovatko kaikki nopat samaa silmälukua
     * @param nopat tutkittavat nopat
     * @return nolla jos kaikki eivät ole samoja, muuten 50 pistettä
     */
    public int yatsy(Noppa[] nopat) {
        int ekaNoppa = nopat[0].getSilmaluku();
        for (Noppa noppa : nopat) {
            if (noppa.getSilmaluku() != ekaNoppa) {
                return 0;
            }
        }
        return 50;
    }

    /**
     * laskee kaikkien viiden nopan silmälukujen summan sattumaa varten
     * @param nopat tutkittavat nopat
     * @return tutkittavien noppien silmälukujen summa
     */
    public int sattuma(Noppa[] nopat) {
        int summa = 0;
        for (Noppa noppa : nopat) {
            summa += noppa.getSilmaluku();
        }
        return summa;
    }
}
