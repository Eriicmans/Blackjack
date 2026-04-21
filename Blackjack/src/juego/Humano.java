package juego;

public class Humano extends Jugador {
    private int beiCoins;

    public Humano(String pNombre, int pSaldoInicial) {
        super(pNombre);
        this.beiCoins = pSaldoInicial;
    }

    public int getBeicoins() {
        return this.beiCoins;
    }

    public boolean verificarBeiCoins() {
        return this.beiCoins > 0;
    }

    public void invertir(int pInversion) {
        this.beiCoins -= pInversion;
    }

    @Override
    public void juega() {
        Teclado teclado = Teclado.getTeclado();
        boolean seHaPlantado = false;
        
        while(!seHaPlantado && !this.seHaPasado()) {
            this.mostrarMano();
            System.out.println("Valor de la mano: " + this.valorMano());
            boolean quiereCarta = teclado.leerSiNo("¿" + getNombre() + ", quieres carta? (S/N)", "S", "N");
            
            if (quiereCarta) {
                this.pedirCarta();
            } else {
                seHaPlantado = true;
            }
        }
    }
}