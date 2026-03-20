package EstructuradeDatos.Cola;

import EstructuradeDatos.LIstaSimple.MiIterador;

// Iterador para recorrer la cola
public class IteradorCola<T> implements MiIterador<T> {
    private NodoCola<T> actual;

    public IteradorCola(NodoCola<T> comienzo) {
        this.actual = comienzo;
    }

    @Override
    public boolean tieneSiguiente() {
        return actual != null;
    }

    @Override
    public T siguiente() {
        if (!tieneSiguiente()) return null;
        T dato = actual.dato;
        actual = actual.siguiente;
        return dato;
    }
}