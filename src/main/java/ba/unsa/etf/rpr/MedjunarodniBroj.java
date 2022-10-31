package ba.unsa.etf.rpr;

import java.util.Objects;

public class MedjunarodniBroj extends TelefonskiBroj {
    public String drzava, broj;

    MedjunarodniBroj(String drzava, String broj) {
        this.drzava = drzava;
        this.broj = broj;
    }

    @Override
    public String ispisi() {
        return drzava + broj;
    }

    @Override
    public int hashCode() {
        return Objects.hash(drzava, broj);
    }
}
