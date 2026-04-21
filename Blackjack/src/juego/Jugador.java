package juego;


public class Jugador {

    private ListaCartas mano;
    private String nombre;

    // Constructor
    public Jugador(String pJugador) {
        this.nombre = pJugador;
    }

    public boolean seHaPasado() {
        return false; 
    }

    public boolean seHaPlantado() {
        return false;
    }

    public int valorMano() {
        return 0;
    }

    public boolean verificarBeiCoins() {
        return false;
    }

    public int getBeicoins() {
        return 0;
    }

    public void juega() {
        // Cuerpo vacío
    }

    public void invertir(int pInversion) {
        // Cuerpo vacío
    }

    public void pedirCarta() {
        // Cuerpo vacío
    }
}