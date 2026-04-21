package juego;

import java.util.Scanner;

public class Teclado {

    // Atributos privados
    private Scanner sc;
    private static Teclado miTeclado; // Subrayado = static

    // Constructor (implícito por el patrón, aunque no esté en el diagrama)
    private Teclado() {
    }

    // Métodos públicos
    public static Teclado getTeclado() {
        return null;
    }

    public String leerString(String pMensajeCortesia) {
        return "";
    }

    public int leerEntero(String pMensajeCortesia, int pDesde, int pHasta) {
        return 0;
    }

    public boolean leerSiNo(String pMensajeCortesia, String pSi, String pNo) {
        return false;
    }
}