package Juan.Pila;

import Juan.LIstaSimple.MiIterador;

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
    public boolean isEmpty() {
        return cima == null;
    }

    @Override
    public int getSize() {
        return tamaño;
    }

    @Override
    public void clear() {
        cima = null;
        tamaño = 0;
    }

    @Override
    public boolean contains(T dato) {
        NodoPila<T> aux = cima;
        while (aux != null) {
            if (aux.dato.compareTo(dato) == 0) return true;
            aux = aux.siguiente;
        }
        return false;
    }

    @Override
    public MiIterador<T> getIterador() {
        return new IteradorPila<>(cima);
    }
}