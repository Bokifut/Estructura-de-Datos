package Juan.LIstaSimple;

// Interfaz para el iterador personalizado
public interface MiIterador<T> {
    boolean hasNext();
    T next();
}