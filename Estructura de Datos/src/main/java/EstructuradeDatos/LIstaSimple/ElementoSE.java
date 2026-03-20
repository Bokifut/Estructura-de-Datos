package EstructuradeDatos.LIstaSimple;

// Nodo para listas simples
public class ElementoSE<T> {
    T dato; // Valor del nodo
    ElementoSE<T> siguiente; // Puntero al siguiente nodo

    public ElementoSE(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}