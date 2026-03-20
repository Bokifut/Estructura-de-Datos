package TADS.Pila;

import TADS.ListaSimple.Iterador;

public interface IPila<T extends Comparable<T>> {
    void push(T dato);
    T pop();
    T peek();
    boolean estaVacia();
    int getTamaño();
    void vaciar();
    boolean contiene(T dato);
    Iterador<T> getIterador();
}