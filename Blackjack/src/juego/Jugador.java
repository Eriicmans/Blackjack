package juego;

public abstract class Jugador {

    private ListaCartas mano; // Ahora es PRIVADO
    private String nombre;

    public Jugador(String pNombre) {
        this.nombre = pNombre;
        this.mano = new ListaCartas();
    }

    public String getNombre() {
        return this.nombre;
    }

    public int valorMano() {
        return this.mano.sumarMano();
    }

    public boolean seHaPasado() {
        return this.valorMano() > 21;
    }

    public void mostrarMano() {
        System.out.println("  Mano de " + this.nombre + ":");
        System.out.println(this.mano.mostrar());
        System.out.println("  Valor: " + this.valorMano());
    }

    public void pedirCarta() {
        Baraja baraja = Baraja.getBaraja();
        Carta nuevaCarta = baraja.extraerCarta();
        if (nuevaCarta != null) {
            this.mano.añadirCarta(nuevaCarta);
        }
    }

    public void reiniciarMano() {
        this.mano.vaciar();
    }

    public abstract void juega();
        
    public boolean tieneBlackjackNatural() {
        return this.mano.esBlackjackNatural();
    }
    
    public Carta getPrimeraCarta() {
        return this.mano.getPrimeraCarta();
    }
}