package juego;

public class Carta {
    private String palo;
    private String valorString; //se usa string para imprimir que es una J,Q,K
    private int valorNum;
    
    public Carta(int pValorNum, String pPalo) {
        this.palo = pPalo;
        this.valorNum = pValorNum;
    }

    public  int valorCarta() {
    	return 0;
	}

}