package Juan.ListaCircula;

public class NodoCircular<T> {
    T dato;
    NodoCircular<T> siguiente;

    public NodoCircular(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}