package juego;

import java.util.Scanner;

public class Teclado {
	private Scanner sc;
	private static Teclado miTeclado;
	
	private Teclado() {
		this.sc = new Scanner(System.in);
	}
	
	public static Teclado getTeclado() {
		if (miTeclado==null);{
			miTeclado = new Teclado();
		}
		return miTeclado;
	}

}
