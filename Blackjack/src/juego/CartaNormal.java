package juego;

public class CartaNormal extends Carta {
    private int valorNumerico;

    public CartaNormal(String pPalo, String pValorString, int pValorNumerico) {
        super(pPalo, pValorString);
        this.valorNumerico = pValorNumerico;
    }

    @Override
    public int valorCarta() {
        return this.valorNumerico;
    }
}