package juego;

import java.util.ArrayList;
import java.util.Iterator;


public class ListaJugadores {
	
	private ArrayList<Jugador> lista;
	
	public ListaJugadores() {
		this.lista = new ArrayList<Jugador>();
	}
	
	public void registrarJugadores(Jugador pJugador) {
		this.lista.add(pJugador);
	}
	
	private Iterator<Jugador> getIterador(){
		return lista.iterator();
	}
	
	public void resolverRonda() {
		null;
	}
	
	public void jugadoresJuegan() {
	    Iterator<Jugador> itr = this.getIterador();
	    while (itr.hasNext()) {
	        Jugador j = itr.next();
	        j.juega();
	    }
	}
	
	public void faseInversiones() {
		null;
	}
	
	public void repartirCartas() {
		null;
	}
}
