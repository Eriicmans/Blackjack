package juego;

import java.util.ArrayList;

public class ListaJugadores {
	
	private ArrayList<Jugador> lista;
	
	public ListaJugadores() {
		this.lista = new ArrayList<Jugador>();
	}
	
	public void añadirJugador(Jugador pJugador) {
		this.lista.add(pJugador);
	}
}
