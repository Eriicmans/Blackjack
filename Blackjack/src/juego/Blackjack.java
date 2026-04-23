package juego;

public class Blackjack {

    private static Blackjack miBlackjack;
    private ListaJugadores listaJugadores;
    private Crupier crupier;

    private Blackjack() {
        this.listaJugadores = new ListaJugadores();
        this.crupier = new Crupier();
    }

    public static Blackjack getBlackjack() {
        if (miBlackjack == null) {
            miBlackjack = new Blackjack();
        }
        return miBlackjack;
    }

    public void jugarPartida() {
        Teclado teclado = Teclado.getTeclado();

        System.out.println("********************************************");
        System.out.println("********* BIENVENIDO A BEICON-CHEESE *******");
        System.out.println("************* B L A C K J A C K ************");
        System.out.println("********************************************\n");

        this.registrarJugadores();

        boolean seguirJugando = true;

        while (seguirJugando && this.listaJugadores.hayJugadores()) {
            this.faseInversiones();
            this.repartirCartas();
            this.jugadoresJuegan();
            this.crupierJuega();
            this.resolverRonda();
            this.reiniciarRonda();
            this.mostrarResumenFinal();
            System.out.println("========= ¡GRACIAS POR JUGAR! =========");
            if (this.listaJugadores.hayJugadores()) {
                seguirJugando = teclado.leerSiNo(
                        "\n¿Quereis jugar otra ronda?", "S", "N");
            } else {
                System.out.println("\nTodos los jugadores han quebrado. ¡Fin de la partida!");
            }
        }
    }

    private void registrarJugadores() {
        this.listaJugadores.registrarJugadores();
    }

    private void faseInversiones() {
        this.listaJugadores.faseInversiones();
    }

    private void repartirCartas() {
        System.out.println("\n========== REPARTO DE CARTAS ==========");
        this.listaJugadores.repartirCartasJugadores();
        this.crupier.pedirCarta();
        this.crupier.pedirCarta();
        System.out.println("  Cartas repartidas.");

        System.out.println("\n  Primera carta del crupier visible:");
        System.out.println("  [" + obtenerPrimeraCarta() + "] y [carta oculta]");
    }

    private void jugadoresJuegan() {
        System.out.println("\n========== TURNO DE LOS JUGADORES ==========");
        this.listaJugadores.jugadoresJuegan();
    }

    private void crupierJuega() {
        this.crupier.juega();
    }

    private void resolverRonda() {
        this.listaJugadores.resolverRonda(this.crupier);
    }
    
    // Delegación limpia para volcar los datos
    private void mostrarResumenFinal() {
        Ranking ranking = Ranking.getMiRanking();
        ranking.limpiarRanking();

        // Le pedimos a la lista que haga su trabajo (Tell, Don't Ask)
        this.listaJugadores.volcarDatosAlRanking();

        ranking.mostrarRanking();
    }

    private void reiniciarRonda() {
        this.crupier.reiniciarMano();
        this.listaJugadores.reiniciarRonda();
    }

    // Uso del método delegado en lugar del iterador interno de la mano
    private String obtenerPrimeraCarta() {
        Carta c = this.crupier.getPrimeraCarta();
        return c.toString();
    }
}