package Juan.Cola;

import Juan.LIstaSimple.MiIterador;

public interface ICola<T extends Comparable<T>> {
    void enqueue(T dato);
    T dequeue();
    T peek();
    boolean isEmpty();
    int getSize();
    void clear();
    boolean contains(T dato);
    MiIterador<T> getIterador();
}