package ba.unsa.etf.rpr;

abstract public class TelefonskiBroj implements Comparable<FiksniBroj> {
    abstract public String ispisi();

    abstract public int hashCode();

    @Override
    public int compareTo(FiksniBroj o) {
        return ispisi().compareTo(o.ispisi());
    }
}
