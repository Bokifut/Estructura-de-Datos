package EstructuradeDatos.Pila;

import EstructuradeDatos.LIstaSimple.MiIterador;

// Iterador para recorrer la pila
public class IteradorPila<T> implements MiIterador<T> {
    private NodoPila<T> actual;

    public IteradorPila(NodoPila<T> comienzo) {
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