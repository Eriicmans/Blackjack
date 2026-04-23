package juego;

import java.util.Scanner;

public class Teclado {

    private Scanner sc;
    private static Teclado miTeclado;

    private Teclado() {
        this.sc = new Scanner(System.in);
    }

    public static Teclado getTeclado() {
        if (miTeclado == null) {
            miTeclado = new Teclado();
        }
        return miTeclado;
    }

    /**
     * Lee un String no vacío mostrando el mensaje de cortesía.
     */
    public String leerString(String pMensajeCortesia) {
        String resultado = "";
        while (resultado.isEmpty()) {
            System.out.print(pMensajeCortesia + " ");
            resultado = sc.nextLine().trim();
            if (resultado.isEmpty()) {
                System.out.println("  [!] El nombre no puede estar vacío. Inténtalo de nuevo.");
            }
        }
        return resultado;
    }

    /**
     * Lee un entero en el rango [pDesde, pHasta] inclusive.
     */
    public int leerEntero(String pMensajeCortesia, int pDesde, int pHasta) {
        int resultado = pDesde - 1;
        while (resultado < pDesde || resultado > pHasta) {
            System.out.print(pMensajeCortesia + " [" + pDesde + "-" + pHasta + "]: ");
            String linea = sc.nextLine().trim();
            try {
                resultado = Integer.parseInt(linea);
                if (resultado < pDesde || resultado > pHasta) {
                    System.out.println("  [!] Introduce un número entre " + pDesde + " y " + pHasta + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("  [!] Entrada no válida. Introduce un número entero.");
            }
        }
        return resultado;
    }

    /**
     * Lee una respuesta Sí/No. Devuelve true si el usuario responde pSi.
     */
    public boolean leerSiNo(String pMensajeCortesia, String pSi, String pNo) {
        String respuesta = "";
        while (!respuesta.equalsIgnoreCase(pSi) && !respuesta.equalsIgnoreCase(pNo)) {
            System.out.print(pMensajeCortesia + " (" + pSi + "/" + pNo + "): ");
            respuesta = sc.nextLine().trim();
            if (!respuesta.equalsIgnoreCase(pSi) && !respuesta.equalsIgnoreCase(pNo)) {
                System.out.println("  [!] Responde " + pSi + " o " + pNo + ".");
            }
        }
        return respuesta.equalsIgnoreCase(pSi);
    }
}
