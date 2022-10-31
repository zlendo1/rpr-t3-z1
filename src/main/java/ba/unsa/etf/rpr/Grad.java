package ba.unsa.etf.rpr;

public enum Grad {
    SARAJEVO("033"), ZENICA("032"), MOSTAR("036");

    private final String broj_telefona;

    Grad(String broj_telefona) {
        this.broj_telefona = broj_telefona;
    }

    public String dajBroj() {
        return broj_telefona;
    }
}
