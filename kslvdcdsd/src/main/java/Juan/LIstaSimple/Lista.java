package Juan.LIstaSimple;

// Comparable obliga a que los objetos de datos puedan ser comparables entre sí para establecer orden
public interface Lista<T extends Comparable<T>> {
    void add(T dato);
    T get(T dato);
    T del(T dato);
    boolean isEmpty();
    int getSize();
    MiIterador<T> getIterador();
    void clear();
    boolean contains(T dato);
    T getFirst();
    T getLast();
}