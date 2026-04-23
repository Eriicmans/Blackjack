package juego;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaJugadores {

    private ArrayList<Humano> lista;
    private ArrayList<Humano> jugadoresEliminados;

    public ListaJugadores() {
        this.lista = new ArrayList<Humano>();
        this.jugadoresEliminados = new ArrayList<Humano>();
    }

    public void registrarJugadores() {
        Teclado teclado = Teclado.getTeclado();
        final int SALDO_INICIAL = 300;

        int numJugadores = teclado.leerEntero("¿Cuántos jugadores van a participar?", 1, 6);

        for (int i = 1; i <= numJugadores; i++) {
            System.out.println("\n--- Jugador " + i + " ---");
            String nombre = teclado.leerString("Introduce tu nombre:");
            this.lista.add(new Humano(nombre, SALDO_INICIAL));
            System.out.println("  " + nombre + " registrado con " + SALDO_INICIAL + " BeiCoins.");
        }
    }

    public void faseInversiones() {
        Teclado teclado = Teclado.getTeclado();
        Iterator<Humano> itr = this.getIterador();

        System.out.println("\n========== FASE DE APUESTAS ==========");

        while (itr.hasNext()) {
            Humano jugador = itr.next();
            System.out.println("\n  " + jugador.getNombre()
                    + " — BeiCoins disponibles: " + jugador.getBeiCoins());

            boolean apuestaAceptada = false;
            while (!apuestaAceptada) {
                int apuesta = teclado.leerEntero(
                        "  ¿Cuántos BeiCoins apuestas?", 1, jugador.getBeiCoins());
                apuestaAceptada = jugador.invertir(apuesta);
                if (!apuestaAceptada) {
                    System.out.println("  [!] Saldo insuficiente. Inténtalo de nuevo.");
                }
            }
            System.out.println("  Apuesta registrada: " + jugador.getInversion() + " BeiCoins.");
        }
    }

    public void repartirCartasJugadores() {
        Iterator<Humano> itr = this.getIterador();
        while (itr.hasNext()) {
            Humano jugador = itr.next();
            jugador.pedirCarta();
            jugador.pedirCarta();
        }
    }

    public void jugadoresJuegan() {
        Iterator<Humano> itr = this.getIterador();
        while (itr.hasNext()) {
            itr.next().juega();
        }
    }

    public void resolverRonda(Crupier crupier) {
        System.out.println("\n========== RESULTADO DE LA RONDA ==========");

        int valorCrupier = crupier.valorMano();
        boolean crupierPasado = crupier.seHaPasado();
        // Uso del método delegado
        boolean crupierBJ = crupier.tieneBlackjackNatural();

        Iterator<Humano> itr = this.getIterador();
        while (itr.hasNext()) {
            Humano jugador = itr.next();
            int valorJugador = jugador.valorMano();
            int apuesta = jugador.getInversion();
            boolean jugadorPasado = jugador.seHaPasado();
            // Uso del método delegado
            boolean jugadorBJ = jugador.tieneBlackjackNatural();

            System.out.println("\n  " + jugador.getNombre()
                    + " — mano: " + valorJugador
                    + " | Crupier: " + valorCrupier);

            if (jugadorPasado) {
                System.out.println("  --> PIERDE (se pasó de 21). Pierde " + apuesta + " BeiCoins.");
                jugador.sumarPuntos(0);

            } else if (jugadorBJ && !crupierBJ) {
                int pago = apuesta + (int) Math.floor(apuesta * 1.5);
                jugador.cobrar(pago);
                System.out.println("  --> ¡BLACKJACK! Cobra " + pago + " BeiCoins.");
                jugador.sumarPuntos(3);

            } else if (jugadorBJ && crupierBJ) {
                jugador.cobrar(apuesta);
                System.out.println("  --> EMPATE (ambos Blackjack). Se devuelven " + apuesta + " BeiCoins.");
                jugador.sumarPuntos(1);

            } else if (!crupierBJ && crupierPasado) {
                jugador.cobrar(apuesta * 2);
                System.out.println("  --> GANA (crupier se pasó). Cobra " + (apuesta * 2) + " BeiCoins.");
                jugador.sumarPuntos(1);

            } else if (!crupierPasado && valorJugador > valorCrupier) {
                jugador.cobrar(apuesta * 2);
                System.out.println("  --> GANA. Cobra " + (apuesta * 2) + " BeiCoins.");
                jugador.sumarPuntos(1);

            } else if (valorJugador == valorCrupier) {
                jugador.cobrar(apuesta);
                System.out.println("  --> EMPATE. Se devuelven " + apuesta + " BeiCoins.");
                jugador.sumarPuntos(1);

            } else {
                System.out.println("  --> PIERDE. Pierde " + apuesta + " BeiCoins.");
                jugador.sumarPuntos(0);
            }

            System.out.println("  Saldo actual: " + jugador.getBeiCoins() + " BeiCoins.");
        }
    }

    public void reiniciarRonda() {
        Iterator<Humano> itr = this.lista.iterator();
        while (itr.hasNext()) {
            Humano jugador = itr.next();
            jugador.reiniciarMano();
            if (!jugador.tieneSaldo()) {
                System.out.println("\n  " + jugador.getNombre()
                        + " se ha quedado sin BeiCoins y abandona la partida.");
                this.jugadoresEliminados.add(jugador);
                itr.remove();
            }
        }
    }

    public boolean hayJugadores() {
        return !this.lista.isEmpty();
    }

    // Iterador ahora es privado (encapsulamiento)
    private Iterator<Humano> getIterador() {
        return this.lista.iterator();
    }
    
    // Método que reemplaza la exposición de las listas de jugadores
    public void volcarDatosAlRanking() {
        Ranking ranking = Ranking.getMiRanking();
        
        for (Humano jugador : this.lista) {
            ranking.a�adirPuntuacion(new Puntuacion(jugador.getNombre(), jugador.getPuntos(), jugador.getBeiCoins()));
        }
        for (Humano jugador : this.jugadoresEliminados) {
            ranking.a�adirPuntuacion(new Puntuacion(jugador.getNombre(), jugador.getPuntos(), jugador.getBeiCoins()));
        }
    }
}