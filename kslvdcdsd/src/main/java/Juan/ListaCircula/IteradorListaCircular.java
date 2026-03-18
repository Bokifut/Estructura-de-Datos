package Juan.ListaCircula;

import Juan.LIstaSimple.MiIterador;

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
    public boolean hasNext() {
        if (ultimo == null) return false;
        return primero || actual != ultimo.siguiente;
    }

    @Override
    public T next() {
        if (!hasNext()) return null;
        T dato = actual.dato;
        actual = actual.siguiente;
        primero = false;
        return dato;
    }
}