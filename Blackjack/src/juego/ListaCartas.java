package juego;

import java.util.ArrayList;

public class ListaCartas {
	
	private ArrayList<Carta> lista;
	
	
	public ListaCartas() {
		this.lista = new ArrayList<Carta>();
	}
	
	public void añadirCarta(Carta pCarta) {
		lista.add(pCarta);
	}
	
	public void extraerCarta(Carta pCarta) {
		lista.remove(pCarta);
	}
	
	public int sumarMano() {
		
	}
}
