package juego;

public abstract class Jugador {
    protected ListaCartas mano;
    private String nombre;

    public Jugador(String pJugador) {
        this.nombre = pJugador;
        this.mano = new ListaCartas();
    }

    public String getNombre() {
        return this.nombre;
    }

    public boolean seHaPasado() {
        return this.valorMano() > 21; 
    }

    public int valorMano() {
        return 0;
    }
    
    public void mostrarMano() {
        System.out.println("Mano de " + this.nombre + ":");
    }

    public abstract void juega();

    public void pedirCarta() {
        Baraja b = Baraja.getMiBaraja();
        Carta nuevaCarta = b.extraerCarta();
        if (nuevaCarta != null) {
            this.mano.añadirCarta(nuevaCarta);
        }
    }
}