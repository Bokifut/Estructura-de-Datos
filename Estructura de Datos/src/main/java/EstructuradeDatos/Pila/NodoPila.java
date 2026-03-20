package EstructuradeDatos.Pila;

// Nodo para la pila
public class NodoPila<T> {
    T dato; // Valor del nodo
    NodoPila<T> siguiente; // Puntero al de abajo

    public NodoPila(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}