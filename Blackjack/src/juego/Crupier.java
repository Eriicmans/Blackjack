package juego;

public class Crupier extends Jugador {

    public Crupier() {
        super("Crupier");
    }

    /**
     * El crupier sigue las reglas de la casa:
     * pide carta mientras su mano valga menos de 17,
     * y se planta automáticamente con 17 o más.
     * No hay interacción con el usuario.
     */
    @Override
    public void juega() {
        System.out.println("\n--- Turno del Crupier ---");
        this.mostrarMano();

        while (this.valorMano() < 17) {
            System.out.println("  El crupier pide carta...");
            this.pedirCarta();
            this.mostrarMano();
        }

        if (this.seHaPasado()) {
            System.out.println("  ¡El crupier se ha pasado de 21!");
        } else {
            System.out.println("  El crupier se planta con " + this.valorMano() + ".");
        }
    }
}
