package EstructuradeDatos.ListaCircula;

// Nodo para lista circular
public class NodoCircular<T> {
    T dato; // Valor del nodo
    NodoCircular<T> siguiente; // Puntero al siguiente nodo

    public NodoCircular(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}