package juego;

public abstract class Jugador {
    private ListaCartas mano;
    private String nombre;

    public Jugador(String pJugador) {
        this.nombre = pJugador;
        this.mano = new ListaCartas();
    }

    public boolean seHaPasado() {
        return this.valorMano() > 21; 
    }

    public int valorMano() {
        return 0;
    }

    public abstract boolean verificarBeiCoins();

    public abstract int getBeicoins();
    
    public void mostrarMano() {
        System.out.println();
    }

    public void juega() {
        Teclado teclado = Teclado.getTeclado();
        boolean seHaPlantado = false;
        
        while(!seHaPlantado && !this.seHaPasado()) {
            this.mostrarMano();
            boolean quiereCarta = teclado.leerSiNo("¿Quieres pedir otra carta (S/N)?", "S", "N");
            
            if (quiereCarta) {
                this.pedirCarta();
            } else {
                seHaPlantado = true;
            }
        }
    }


    public void pedirCarta() {
        Baraja b = Baraja.getMiBaraja();
        Carta nuevaCarta = b.extraerCarta();
        if (nuevaCarta != null) {
            this.mano.añadirCarta(nuevaCarta);
        }
    }
    
    public abstract void invertir(int pInversion);

}