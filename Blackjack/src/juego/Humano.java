package juego;

public class Humano extends Jugador {

    private int beiCoins;
    private int inversion;
    private int puntos;

    public Humano(String pNombre, int pSaldoInicial) {
        super(pNombre);
        this.beiCoins = pSaldoInicial;
        this.inversion = 0;
        this.puntos = 0;
    }

    public int getBeiCoins() {
        return this.beiCoins;
    }

    public int getInversion() {
        return this.inversion;
    }
    
    public int getPuntos() {
        return this.puntos;
    }

    public boolean tieneSaldo() {
        return this.beiCoins > 0;
    }

    public boolean invertir(int pInversion) {
        if (pInversion <= 0 || pInversion > this.beiCoins) {
            return false;
        }
        this.inversion = pInversion;
        this.beiCoins -= pInversion;
        return true;
    }

    public void cobrar(int pCantidad) {
        this.beiCoins += pCantidad;
    }
    
    public void sumarPuntos(int pPuntos) {
        this.puntos += pPuntos;
    }

    @Override
    public void juega() {
        Teclado teclado = Teclado.getTeclado();
        boolean seHaPlantado = false;

        System.out.println("\n--- Turno de " + this.getNombre() + " ---");

        // Uso del método delegado en lugar de this.mano.esBlackjackNatural()
        if (this.tieneBlackjackNatural()) {
            this.mostrarMano();
            System.out.println("  ¡BLACKJACK! Espera a que el crupier juegue.");
            seHaPlantado = true;
        }

        while (!seHaPlantado && !this.seHaPasado()) {
            this.mostrarMano();

            if (this.valorMano() == 21) {
                System.out.println("  ¡21! Te plantas automáticamente.");
                seHaPlantado = true;
                break;
            }

            boolean quiereCarta = teclado.leerSiNo(
                    "\n  " + this.getNombre() + ", ¿quieres carta?", "S", "N");

            if (quiereCarta) {
                this.pedirCarta();
            } else {
                seHaPlantado = true;
            }
        }

        if (this.seHaPasado()) {
            this.mostrarMano();
            System.out.println("  ¡Te has pasado de 21!");
        } else if (seHaPlantado && !this.tieneBlackjackNatural()) {
            System.out.println("  " + this.getNombre() + " se planta con " + this.valorMano() + ".");
        }
    }
}