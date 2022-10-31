package ba.unsa.etf.rpr;

import java.util.Objects;

public class FiksniBroj extends TelefonskiBroj {
    private String broj;
    private Grad grad;

    FiksniBroj(Grad grad, String broj) {
        this.grad = grad;
        this.broj = broj;
    }

    @Override
    public String ispisi() {
        return grad.dajBroj() + "/" + broj;
    }

    @Override
    public int hashCode() {
        return Objects.hash(broj, grad);
    }

    public Grad dajGrad() {
        return grad;
    }
}
