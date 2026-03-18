package Juan.Pila;

public class NodoPila<T extends Comparable<T>> {
    T dato;
    NodoPila<T> siguiente;

    public NodoPila(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}