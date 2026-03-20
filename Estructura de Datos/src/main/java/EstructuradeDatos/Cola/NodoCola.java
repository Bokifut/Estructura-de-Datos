package EstructuradeDatos.Cola;

// Nodo para la cola
public class NodoCola<T> {
    T dato; // Valor del nodo
    NodoCola<T> siguiente; // Puntero al de atrás

    public NodoCola(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}