package TADS.ListaCircula;

import TADS.ListaSimple.Iterador;

public interface IListaCircular<T extends Comparable<T>> {
    void add(T dato);
    T get(T dato);
    T eliminar(T dato);
    boolean estaVacia();
    int getTamaño();
    void vaciar();
    boolean contiene(T dato);
    T busqPos(int indice);
    T getUltimo();
    T getPrimero();
    void imprimirLista();
    Iterador<T> getIterador();
}