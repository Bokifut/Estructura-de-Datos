package TADS.Pila;

import TADS.ListaSimple.Iterador;

public class IteradorPila<T extends Comparable<T>> implements Iterador<T> {
    private NodoPila<T> actual;

    public IteradorPila(NodoPila<T> comienzo) {
        this.actual = comienzo;
    }

    @Override
    public boolean hasNext() {
        return actual != null;
    }

    @Override
    public T next() {
        if (!hasNext()) return null;
        T dato = actual.dato;
        actual = actual.siguiente;
        return dato;
    }
}