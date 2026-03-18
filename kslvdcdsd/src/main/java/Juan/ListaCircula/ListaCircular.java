package Juan.ListaCircula;

import Juan.LIstaSimple.Lista;
import Juan.LIstaSimple.MiIterador;

public class ListaCircular<T extends Comparable<T>> implements IListaCircular<T>, Lista<T> {
    private NodoCircular<T> ultimo;
    private int tamaño = 0;

    @Override
    public void add(T dato) {
        NodoCircular<T> nuevo = new NodoCircular<>(dato);
        if (isEmpty()) {
            ultimo = nuevo;
            ultimo.siguiente = ultimo;
        } else {
            nuevo.siguiente = ultimo.siguiente;
            ultimo.siguiente = nuevo;
            ultimo = nuevo;
        }
        tamaño++;
    }

    @Override
    public T get(T dato) {
        if (isEmpty()) return null;
        NodoCircular<T> aux = ultimo.siguiente;
        do {
            if (aux.dato.compareTo(dato) == 0) return aux.dato;
            aux = aux.siguiente;
        } while (aux != ultimo.siguiente);
        return null;
    }

    @Override
    public T del(T dato) {
        if (isEmpty()) return null;
        NodoCircular<T> act = ultimo.siguiente;
        NodoCircular<T> ant = ultimo;
        
        do {
            if (act.dato.compareTo(dato) == 0) {
                if (act == ultimo && act == ultimo.siguiente) {
                    ultimo = null; // Unico elemento
                } else {
                    ant.siguiente = act.siguiente;
                    if (act == ultimo) ultimo = ant;
                }
                tamaño--;
                return act.dato;
            }
            ant = act;
            act = act.siguiente;
        } while (act != ultimo.siguiente);
        
        return null;
    }

    @Override
    public boolean isEmpty() {
        return ultimo == null;
    }

    @Override
    public int getSize() {
        return tamaño;
    }

    @Override
    public MiIterador<T> getIterador() {
        return new IteradorListaCircular<>(ultimo);
    }

    @Override
    public void clear() {
        ultimo = null;
        tamaño = 0;
    }

    @Override
    public boolean contains(T dato) {
        return get(dato) != null;
    }

    @Override
    public T getFirst() {
        return ultimo != null ? ultimo.siguiente.dato : null;
    }

    @Override
    public T getLast() {
        return ultimo != null ? ultimo.dato : null;
    }
}