package juego;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

public class Baraja {
    // Atributos
    private ArrayList<Carta> lista;
    private static Baraja miBaraja;

    // Constructor privado
    private Baraja() {
        this.lista = new ArrayList<Carta>();
        this.inicializarBaraja();
    }

    public static Baraja getMiBaraja() {
        if (miBaraja == null) {
            miBaraja = new Baraja();
        }
        return miBaraja;
    }

    private void inicializarBaraja() {
        String[] palos = {"Corazones", "Diamantes", "Tréboles", "Picas"};
        
        for (String palo : palos) {
            for (int i = 1; i <= 13; i++) {
                // Se asume que la clase Carta existe y recibe (valor, palo)
                this.lista.add(new Carta(i, palo));
            }
        }
        // Mezclamos la baraja al principio para que extraer la primera sea "al azar"
        Collections.shuffle(this.lista);
    }

    public Carta extraerCarta() {
        if (!lista.isEmpty()) {
            Random rand = new Random();
            int index = rand.nextInt(lista.size());
            return lista.remove(index);
        }
        System.out.println("No quedan cartas en la baraja.");
        return null;
    }

    private Iterator<Carta> getIterador() {
        return lista.iterator();
    }
}