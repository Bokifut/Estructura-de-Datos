package TADS.Cola;

import TADS.ListaSimple.Iterador;

public interface ICola<T extends Comparable<T>> {
    void enqueue(T dato);
    T dequeue();
    T primero();
    T ultimo();
    boolean estaVacia();
    int getTamaño();
    void vaciar();
    boolean contiene(T dato);
    Iterador<T> getIterador();
}