package TADS.ListaDoble;

import TADS.ListaSimple.Iterador;

public class IteradorLDE<T> implements Iterador<T> {
    private NodoLDE<T> actual;

    public IteradorLDE(NodoLDE<T> comienzo) {
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