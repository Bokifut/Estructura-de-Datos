package TADS.ListaDoble;

// Nodo para listas dobles
public class NodoLDE<T> {
    T dato;
    NodoLDE<T> siguiente;
    NodoLDE<T> anterior;

    public NodoLDE(T dato) {
        this.dato = dato;
    }
}