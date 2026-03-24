package juego;

public class Crupier extends Jugador {
	
	public Crupier() {
		super("Crupier");
		
	}

	public boolean debePedirCarta() {
        if (this.sumaMano() < 17) {
            return true;
        } else {
            return false; // Se planta automáticamente si tiene 17 o más
        }
    }
}
