package ba.unsa.etf.rpr;

import java.util.Objects;

public class MobilniBroj extends TelefonskiBroj {
    private String mobilnaMreza, broj;

    MobilniBroj(int mobilnaMreza, String broj) {
        this.mobilnaMreza = "0" + mobilnaMreza;
        this.broj = broj;
    }

    @Override
    public String ispisi() {
        return mobilnaMreza + "/" + broj;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mobilnaMreza, broj);
    }
}
