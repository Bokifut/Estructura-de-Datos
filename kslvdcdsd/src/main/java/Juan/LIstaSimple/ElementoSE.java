package Juan.LIstaSimple;

// Nodo para listas simples
public class ElementoSE<T> {
    T dato;
    ElementoSE<T> siguiente;

    public ElementoSE(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}