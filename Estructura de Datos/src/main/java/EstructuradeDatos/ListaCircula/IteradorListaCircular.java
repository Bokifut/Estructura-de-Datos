package EstructuradeDatos.ListaCircula;

import EstructuradeDatos.LIstaSimple.MiIterador;

// Iterador para recorrer una lista circular
public class IteradorListaCircular<T> implements MiIterador<T> {
    private NodoCircular<T> actual;
    private NodoCircular<T> ultimo;
    private boolean primero = true;

    public IteradorListaCircular(NodoCircular<T> ultimo) {
        this.ultimo = ultimo;
        if (ultimo != null) {
            this.actual = ultimo.siguiente; 
        }
    }

    @Override
    public boolean tieneSiguiente() {
        if (ultimo == null) return false;
        // Evita un bucle infinito al dar la vuelta
        return primero || actual != ultimo.siguiente;
    }

    @Override
    public T siguiente() {
        if (!tieneSiguiente()) return null;
        T dato = actual.dato;
        actual = actual.siguiente;
        primero = false;
        return dato;
    }
}