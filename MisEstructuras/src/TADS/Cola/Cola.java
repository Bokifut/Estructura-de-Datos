package TADS.Cola;

import TADS.ListaSimple.Iterador;

public class Cola<T extends Comparable<T>> implements ICola<T> {
    private NodoCola<T> primero, ultimo;
    private int tamaño = 0;

    @Override
    public void enqueue(T dato) {
        NodoCola<T> nuevo = new NodoCola<>(dato);
        if (ultimo == null) {
            primero = ultimo = nuevo;
        } else {
            ultimo.siguiente = nuevo;
            ultimo = nuevo;
        }
        tamaño++;
    }

    @Override
    public T dequeue() {
        if (primero == null) return null;
        T dato = primero.dato;
        primero = primero.siguiente;
        if (primero == null) {
            ultimo = null;
        }
        tamaño--;
        return dato;
    }

    @Override
    public T primero() {
        if (primero == null) return null;
        return primero.dato;
    }
    @Override
    public T ultimo() {
        return ultimo.dato;
    }

    @Override
    public boolean estaVacia() {
        return primero == null;
    }

    @Override
    public int getTamaño() {
        return this.tamaño;
   }

    @Override
    public void vaciar() {
        primero = null;
        ultimo = null;
        tamaño = 0;
    }

    @Override
    public boolean contiene(T dato) {
        NodoCola<T> act = primero;
        while (act != null) {
            if (act.dato.compareTo(dato) == 0) return true;
            act = act.siguiente;
        }
        return false;
    }

    @Override
    public Iterador<T> getIterador() {
        return new IteradorCola<>(primero);
    }
}