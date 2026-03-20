package EstructuradeDatos.ListaDoble;

import EstructuradeDatos.LIstaSimple.MiIterador;

// Iterador para recorrer una lista doblemente enlazada
public class IteradorLDE<T> implements MiIterador<T> {
    private ElementoDE<T> actual;

    public IteradorLDE(ElementoDE<T> comienzo) {
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