
package peli;

import java.util.ArrayList;
/**
 *
 * @author Miia Rämö
 */
public class NoppaKombinaatiot {

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

    public int montakoSamaaNumeroa(Noppa[] nopat, int numero) {
        int maara = 0;
        for (Noppa noppa : nopat) {
            if (noppa.getSilmaluku() == numero) {
                maara++;
            }
        }
        return maara;
    }

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

    public int neljaSamanlaista(Noppa[] nopat) {
        int summa = 0;
        for (int i = 6; i > 0; i--) {
            if (montakoSamaaNumeroa(nopat, i) == 4) {
                summa = 4 * i;
                return summa;
            }
        }
        return summa;
    }

    public int yksiPari(Noppa[] nopat) {
        for (int i = 6; i >= 1; i--) {
            if (montakoSamaaNumeroa(nopat, i) >= 2) {
                return i * 2;
            }
        }
        return 0;
    }

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

    public int taysikasi(Noppa[] nopat) {
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

    public int yatzy(Noppa[] nopat) {
        int ekaNoppa = nopat[0].getSilmaluku();
        for (Noppa noppa : nopat) {
            if (noppa.getSilmaluku() != ekaNoppa) {
                return 0;
            }
        }
        return 50;
    }

    public int sattuma(Noppa[] nopat) {
        int summa = 0;
        for (Noppa noppa : nopat) {
            summa += noppa.getSilmaluku();
        }
        return summa;

    }

}
