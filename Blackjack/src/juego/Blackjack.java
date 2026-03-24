package juego;

public class Blackjack {
	
	private static Blackjack miBlackjack;
    private ListaJugadores listaJugadores;
    private Crupier crupier;

    private Blackjack() {
        this.listaJugadores = new ListaJugadores();
        this.crupier = new Crupier();
    }
    
    public static Blackjack getBlackjack() {
        if (miBlackjack == null) {
            miBlackjack = new Blackjack();
        }
        return miBlackjack;
    }
    
    
    public void iniciarPartida() {
        Teclado teclado = Teclado.getTeclado();
        Baraja baraja = Baraja.getBaraja();
        
        
        
        
        
    }
    
}
