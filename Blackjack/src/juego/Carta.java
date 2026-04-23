package juego;

public class Carta {

    private String palo;
    private String valorString; // "A", "J", "Q", "K" o el número como texto
    private int valorBase;      // Valor numérico base: As=1, Figuras=10, resto su número

    public Carta(String pPalo, String pValorString, int pValorBase) {
        this.palo = pPalo;
        this.valorString = pValorString;
        this.valorBase = pValorBase;
    }

    /**
     * Devuelve el valor base de la carta.
     * El tratamiento especial del As (1 u 11) se gestiona en ListaCartas.sumarMano().
     */
    public int valorCarta() {
        return this.valorBase;
    }

    public boolean esAs() {
        return this.valorString.equals("A");
    }

    public String getPalo() {
        return this.palo;
    }

    public String getValorString() {
        return this.valorString;
    }

    @Override
    public String toString() {
        return this.valorString + " de " + this.palo;
    }
}
