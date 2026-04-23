package juego;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Ranking {
	private static Ranking miRanking = null;
	private ArrayList<Puntuacion> lista;
	
	private Ranking() {
		this.lista = new ArrayList<Puntuacion>();
	}
	
	public static Ranking getMiRanking() {
		if(miRanking == null) {
			miRanking = new Ranking();
		}
		return miRanking;
	}
	
	public void añadirPuntuacion(Puntuacion p) {
		this.lista.add(p);
		Collections.sort(this.lista);
	}
	
	public Iterator<Puntuacion> getIterador(){
		return this.lista.iterator();
	}
	
	public void guardarRanking() {
		try {
			PrintWriter pw = new PrintWriter("Ranking.txt");
			Iterator<Puntuacion> itr = this.getIterador();
			Puntuacion p = null;
			while(itr.hasNext()) {
				p = itr.next();
				pw.println(p.toStr());
			}
			pw.flush();
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void mostrarRanking() {
		System.out.println("\n*************************************");
		System.out.println("*********** RANKING FINAL *************");
		System.out.println("*************************************\n");
		
		int posicion = 1;
		Iterator<Puntuacion> itr = this.getIterador();
		Puntuacion p = null;
		while(itr.hasNext()) {
			p = itr.next();
			System.out.printf("  %d. %s%n", posicion, p.toStr());
			posicion++;
		}
	}
	
	public void limpiarRanking() {
		this.lista.clear();
	}
	
	public Puntuacion obtenerGanador() {
		if(!this.lista.isEmpty()) {
			return this.lista.get(0);
		}
		return null;
	}
}
