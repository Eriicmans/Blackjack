package juego;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaCartas {

    private ArrayList<Carta> lista;

    public ListaCartas() {
        this.lista = new ArrayList<Carta>();
    }

    public void a�adirCarta(Carta pCarta) {
        this.lista.add(pCarta);
    }

    public void vaciar() {
        this.lista.clear();
    }

    // Iterador ahora es PRIVADO
    private Iterator<Carta> getIterador() {
        return this.lista.iterator();
    }

    public int sumarMano() {
        int suma = 0;
        int asesAltos = 0;

        Iterator<Carta> itr = this.getIterador();
        while (itr.hasNext()) {
            Carta c = itr.next();
            if (c.esAs()) {
                suma += 11;
                asesAltos++;
            } else {
                suma += c.valorCarta();
            }
        }

        while (suma > 21 && asesAltos > 0) {
            suma -= 10;
            asesAltos--;
        }

        return suma;
    }

    public boolean esBlackjackNatural() {
        if (this.lista.size() != 2) return false;
        Carta c1 = this.lista.get(0);
        Carta c2 = this.lista.get(1);
        boolean primerAsSegundoDiez  = c1.esAs() && c2.valorCarta() == 10;
        boolean primerDiezSegundoAs  = c2.esAs() && c1.valorCarta() == 10;
        return primerAsSegundoDiez || primerDiezSegundoAs;
    }

    public String mostrar() {
        StringBuilder sb = new StringBuilder();
        Iterator<Carta> itr = this.getIterador();
        while (itr.hasNext()) {
            Carta c = itr.next();
            sb.append("  [").append(c.toString()).append("]");
        }
        return sb.toString();
    }
    
    // Nuevo método para delegación
    public Carta getPrimeraCarta() {
        if (!this.lista.isEmpty()) {
            return this.lista.get(0);
        }
        return null;
    }
}