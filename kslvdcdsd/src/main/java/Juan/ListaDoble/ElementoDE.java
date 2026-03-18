package Juan.ListaDoble;

// Nodo para listas dobles
public class ElementoDE<T> {
    T dato;
    ElementoDE<T> siguiente;
    ElementoDE<T> anterior;

    public ElementoDE(T dato) {
        this.dato = dato;
    }
}