package juego;

import java.util.ArrayList;
import java.util.Collections;

public class Baraja {

    private ArrayList<Carta> lista;
    private static Baraja miBaraja;

    private Baraja() {
        this.lista = new ArrayList<Carta>();
        this.inicializarBaraja();
    }

    public static Baraja getBaraja() {
        if (miBaraja == null) {
            miBaraja = new Baraja();
        }
        return miBaraja;
    }

    /**
     * Crea las 52 cartas de la baraja francesa y las baraja.
     * - As:     valorBase = 1  (sumarMano() lo tratará como 11 por defecto)
     * - 2-10:   valorBase = su número
     * - J/Q/K:  valorBase = 10
     */
    private void inicializarBaraja() {
        String[] palos = {"Corazones", "Diamantes", "Tréboles", "Picas"};

        for (String palo : palos) {
            // As
            lista.add(new Carta(palo, "A", 1));

            // Cartas numéricas 2-10
            for (int i = 2; i <= 10; i++) {
                lista.add(new Carta(palo, String.valueOf(i), i));
            }

            // Figuras (valen 10)
            lista.add(new Carta(palo, "J", 10));
            lista.add(new Carta(palo, "Q", 10));
            lista.add(new Carta(palo, "K", 10));
        }

        Collections.shuffle(this.lista);
    }

    /**
     * Extrae la primera carta del mazo (ya está mezclado).
     * Si se agota, reinicia y avisa.
     */
    public Carta extraerCarta() {
        if (this.lista.isEmpty()) {
            System.out.println("\n  [La baraja se ha agotado. Mezclando de nuevo...]\n");
            this.inicializarBaraja();
        }
        return this.lista.remove(0);
    }
}
