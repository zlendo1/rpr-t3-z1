package ba.unsa.etf.rpr;

import java.util.*;

public class Imenik {
    private Map<String, TelefonskiBroj> imenik = new HashMap<String, TelefonskiBroj>();

    Imenik() {
    }

    Imenik(Map<String, TelefonskiBroj> imenik) {
        this.imenik = imenik;
    }

    Imenik(Imenik k) {
        this.imenik = new HashMap<String, TelefonskiBroj>(k.imenik);
    }


    /**
     * @param ime ime osobe koju dodajemo
     * @param broj telefonski broj osobe
     */
    public void dodaj(String ime, TelefonskiBroj broj) {
        imenik.put(ime, broj);
    }

    public String dajBroj(String ime) {
        return imenik.get(ime).ispisi();
    }

    public String dajIme(TelefonskiBroj broj) {
        for (Map.Entry<String, TelefonskiBroj> entry : imenik.entrySet()) {
            if (Objects.equals(entry.getValue().ispisi(), broj.ispisi())) {
                return entry.getKey();
            }
        }

        return null;
    }

    /**
     * @param s pocetno slovo imena (mnozina) kojih zelimo da vratimo
     * @return String koji sadrzi imena, prezimena i brojeve telefona sa pocetnim slovom s
     */
    public String naSlovo(char s) {
        StringBuilder brojevi = new StringBuilder(new String());
        int brojac_mjesta = 0;

        for (Map.Entry<String, TelefonskiBroj> entry : imenik.entrySet()) {
            if (entry.getKey().charAt(0) == s) {
                if (brojac_mjesta != 0) {
                    brojevi.append("\n");
                }

                brojac_mjesta++;

                brojevi.append(brojac_mjesta).append(". ").append(entry.getKey()).append(" - ").append(entry.getValue().ispisi());
            }
        }

        return brojevi.toString();
    }

    /**
     * @param g Grad iz kog zelimo izvuci
     * @return Skup koji sadrzi imena i prezimena osoba iz Grada g
     */
    public Set<String> izGrada(Grad g) {
        Set<String> osobe = new TreeSet<String>();

        for (Map.Entry<String, TelefonskiBroj> entry : imenik.entrySet()) {
            try {
                if ( Objects.equals(((FiksniBroj) entry.getValue()).dajGrad().dajBroj(), g.dajBroj()) ) {
                    osobe.add(entry.getKey());
                }
            } catch (ClassCastException ignored) {}
        }

        return osobe;
    }

    /**
     * @param g Grad iz kog zelimo izvuci
     * @return Skup telefonskih brojeva iz Grada g
     */
    public Set<TelefonskiBroj> izGradaBrojevi(Grad g) {
        Set<TelefonskiBroj> brojevi = new TreeSet<TelefonskiBroj>();

        for (Map.Entry<String, TelefonskiBroj> entry : imenik.entrySet()) {
            try {
                if ( Objects.equals(((FiksniBroj) entry.getValue()).dajGrad().dajBroj(), g.dajBroj()) ) {
                    brojevi.add(entry.getValue());
                }
            } catch (ClassCastException ignored) {}
        }

        return brojevi;
    }
}
