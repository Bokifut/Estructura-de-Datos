package TADS.ListaSimple;

// Interfaz para el iterador personalizado
public interface Iterador<T> {
    boolean hasNext();
    T next();
}