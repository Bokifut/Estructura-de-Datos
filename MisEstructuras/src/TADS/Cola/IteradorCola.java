package TADS.Cola;

import TADS.ListaSimple.Iterador;

public class IteradorCola<T> implements Iterador<T> {
    private NodoCola<T> actual;

    public IteradorCola(NodoCola<T> comienzo) {
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