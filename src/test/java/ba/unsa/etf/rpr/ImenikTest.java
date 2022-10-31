package ba.unsa.etf.rpr;

import junit.framework.TestCase;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class ImenikTest extends TestCase {

    public void testDodaj() {
        Imenik test = new Imenik();
        test.dodaj("Zijad Lendo", new MobilniBroj(61, "730-262"));
    }

    public void testDajBroj() {
        Imenik test = new Imenik();

        test.dodaj("Zijad Lendo", new MobilniBroj(61, "730-262"));
        test.dodaj("Emir Spahic", new MobilniBroj(25, "026-235"));

        assertEquals("061/730-262", test.dajBroj("Zijad Lendo"));
    }

    public void testDajIme() {
        Imenik test = new Imenik();

        test.dodaj("Zijad Lendo", new MobilniBroj(61, "730-262"));
        test.dodaj("Emir Spahic", new MobilniBroj(25, "026-235"));

        assertEquals("Zijad Lendo", test.dajIme(new MobilniBroj(61, "730-262")));
    }

    public void testNaSlovo() {
        Imenik test = new Imenik();

        test.dodaj("Zijad Lendo", new FiksniBroj(Grad.SARAJEVO, "1"));
        test.dodaj("Emir Spahic", new FiksniBroj(Grad.ZENICA, "2"));
        test.dodaj("Akif Dudakovic", new MobilniBroj(61, "3"));

        assertEquals("1. Zijad Lendo - 033/1", test.naSlovo('Z'));
    }

    public void testIzGrada() {
        Imenik test = new Imenik();

        test.dodaj("Zijad Lendo", new FiksniBroj(Grad.SARAJEVO, "1"));
        test.dodaj("Emir Spahic", new FiksniBroj(Grad.ZENICA, "2"));
        test.dodaj("Akif Dudakovic", new MobilniBroj(61, "3"));

        Set<String> pravi_set = new TreeSet<String>();
        pravi_set.add("Zijad Lendo");

        assertEquals(pravi_set, test.izGrada(Grad.SARAJEVO));
    }

    public void testIzGradaBrojevi() {
        Imenik test = new Imenik();

        test.dodaj("Zijad Lendo", new FiksniBroj(Grad.SARAJEVO, "1"));
        test.dodaj("Emir Spahic", new FiksniBroj(Grad.ZENICA, "2"));
        test.dodaj("Akif Dudakovic", new MobilniBroj(61, "3"));

        Set<TelefonskiBroj> pravi_set = new TreeSet<TelefonskiBroj>();
        pravi_set.add(new FiksniBroj(Grad.SARAJEVO, "1"));

        assertEquals(pravi_set, test.izGradaBrojevi(Grad.SARAJEVO));
    }
}