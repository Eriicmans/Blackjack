package juego;

public abstract class Carta {
    protected String palo;
    protected String valorString;

    public Carta(String pPalo, String pValorString) {
        this.palo = pPalo;
        this.valorString = pValorString;
    }

    // Método que se sobreescribirá usando ligadura dinámica
    public abstract int valorCarta(); 
}




