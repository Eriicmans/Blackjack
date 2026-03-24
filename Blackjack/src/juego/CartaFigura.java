package juego;

public class CartaFigura extends Carta {
    public CartaFigura(String pPalo, String pValorString) {
        super(pPalo, pValorString);
    }

    @Override
    public int valorCarta() {
        return 10;
    }
}