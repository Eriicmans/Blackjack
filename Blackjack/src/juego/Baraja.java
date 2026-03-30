package juego;

import java.util.ArrayList;

public class Baraja {
	
	private static Baraja miBaraja;
	private ArrayList<Carta> listaTodasCartas;
	
	private static 
	
	private Baraja() {
        this.listaTodasCartas = new ArrayList<Carta>();
        this.inicializarBaraja(); // Se pone en la constructora porque nada mas crear la baraja se quieren tener todas las cartas
    }
	
	public static Baraja getBaraja() {
        if (miBaraja == null) {
            miBaraja = new Baraja();
        }
        return miBaraja;
    }
	
	
	private void inicializarBaraja() {
		
		
	}
}


