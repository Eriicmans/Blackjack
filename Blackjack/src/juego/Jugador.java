package juego;

public class Jugador 
{
	private String nombre;
	private int beiCoin;
	private ListaCartas mano;
	private int beiCoinJugados;
	
	
	public Jugador(String pNomb) {
		this.nombre = pNomb;
		this.mano = new ListaCartas();
		this.beiCoin = 300;
	}
}
