package juego;

public class Jugador 
{
	private String nombre;
	protected int beiCoin;
	private ListaCartas mano;
	private int beiCoinJugados;
	
	
	public Jugador(String pNomb) {
		this.nombre = pNomb;
		this.mano = new ListaCartas();
		this.beiCoin = 300;
	}
	
	
	// Metodos
	
	public Carta pedirCarta() {
		
	}
	
	public boolean seHaPasado() {
		return this.valorMano() > 21;
	}
	
	
	public int valorMano() {
		return this.mano.sumarMano();
	}
	
	public boolean comprobarBeicoinsSuficientes() {
		
	}
}

