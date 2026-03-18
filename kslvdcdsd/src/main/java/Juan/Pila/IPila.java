package Juan.Pila;

import Juan.LIstaSimple.MiIterador;

public interface IPila<T extends Comparable<T>> {
    void push(T dato);
    T pop();
    T peek();
    boolean isEmpty();
    int getSize();
    void clear();
    boolean contains(T dato);
    MiIterador<T> getIterador();
}