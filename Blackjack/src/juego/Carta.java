package juego;

public abstract class Carta {
    private String palo;
    private String valorString; //se usa string para imprimir que es una J,Q,K

    public Carta(String pPalo, String pValorString) {
        this.palo = pPalo;
        this.valorString = pValorString;
    }

    // Ligadura dinamica
    public abstract int valorCarta(); 
}




