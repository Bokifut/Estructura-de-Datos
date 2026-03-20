package TADS.Pila;

import TADS.ListaSimple.Iterador;

public class Pila<T extends Comparable<T>> implements IPila<T> {
    private NodoPila<T> cima;
    private int tamaño = 0;

    @Override
    public void push(T dato) {
        NodoPila<T> nuevo = new NodoPila<>(dato);
        nuevo.siguiente = cima;
        cima = nuevo;
        tamaño++;
    }

    @Override
    public T pop() {
        if (cima == null) return null;
        T dato = cima.dato;
        cima = cima.siguiente;
        tamaño--;
        return dato;
    }

    @Override
    public T peek() {
        if (cima == null) return null;
        return cima.dato;
    }

    @Override
    public boolean estaVacia() {
        return cima == null;
    }

    @Override
    public int getTamaño() {
        return tamaño;
    }

    @Override
    public void vaciar() {
        cima = null;
        tamaño = 0;
    }

    @Override
    public boolean contiene(T dato) {
        NodoPila<T> act = cima;
        while (act != null) {
            if (act.dato.compareTo(dato) == 0) return true;
            act = act.siguiente;
        }
        return false;
    }

    @Override
    public Iterador<T> getIterador() {
        return new IteradorPila<>(cima);
    }
}