package juego;

public class CartaAs extends Carta {
    public CartaAs(String pPalo, String pValorString) {
        super(pPalo, pValorString);
    }

    @Override
    public int valorCarta() {
        // Aqui se podria hacer lo de que valga 1 / 11
        return 1;
    }
}
