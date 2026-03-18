package Juan.ListaCircula;

import Juan.LIstaSimple.MiIterador;

public interface IListaCircular<T extends Comparable<T>> {
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