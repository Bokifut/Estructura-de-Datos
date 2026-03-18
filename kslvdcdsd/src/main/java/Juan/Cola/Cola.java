package Juan.Cola;

import Juan.LIstaSimple.MiIterador;

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
    public T peek() {
        if (primero == null) return null;
        return primero.dato;
    }

    @Override
    public boolean isEmpty() {
        return primero == null;
    }

    @Override
    public int getSize() {
        return tamaño;
    }

    @Override
    public void clear() {
        primero = null;
        ultimo = null;
        tamaño = 0;
    }

    @Override
    public boolean contains(T dato) {
        NodoCola<T> aux = primero;
        while (aux != null) {
            if (aux.dato.compareTo(dato) == 0) return true;
            aux = aux.siguiente;
        }
        return false;
    }

    @Override
    public MiIterador<T> getIterador() {
        return new IteradorCola<>(primero);
    }
}