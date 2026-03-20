package EstructuradeDatos.ListaDoble;

// Nodo para listas dobles
public class ElementoDE<T> {
    T dato; // Valor del nodo
    ElementoDE<T> siguiente; // Puntero al siguiente
    ElementoDE<T> anterior; // Puntero al anterior

    public ElementoDE(T dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }
}