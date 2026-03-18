package Juan.ListaDoble;

import Juan.LIstaSimple.MiIterador;

public class IteradorLDE<T> implements MiIterador<T> {
    private ElementoDE<T> actual;

    public IteradorLDE(ElementoDE<T> comienzo) {
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