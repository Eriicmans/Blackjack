package juego;

public class Puntuacion implements Comparable<Puntuacion> {
	private String nombre;
	private int puntos;
	private int beicoins;
	
	public Puntuacion(String nombre, int puntos, int beicoins) {
		this.nombre = nombre;
		this.puntos = puntos;
		this.beicoins = beicoins;
	}

	@Override
	public int compareTo(Puntuacion o) {
		// Para ordenar de mayor a menor puntuación
		int resul = Integer.compare(o.puntos, this.puntos);
		if(resul == 0) {
			// Si tienen los mismos puntos, ordenar por BeiCoins de mayor a menor
			resul = Integer.compare(o.beicoins, this.beicoins);
		}
		if(resul == 0) {
			// Si ambos son iguales, ordenar alfabéticamente
			resul = this.nombre.compareTo(o.nombre);
		}
		return resul;
	}
	
	public String toStr() {
		return this.nombre + ": " + this.puntos + " puntos, " + this.beicoins + " BeiCoins";
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public int getPuntos() {
		return this.puntos;
	}
	
	public int getBeicoins() {
		return this.beicoins;
	}
}
