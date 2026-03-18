package Juan.Cola;

import Juan.LIstaSimple.MiIterador;

public class IteradorCola<T> implements MiIterador<T> {
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