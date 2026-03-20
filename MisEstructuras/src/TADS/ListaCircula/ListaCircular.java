package TADS.ListaCircula;

import TADS.ListaSimple.Iterador;

public class ListaCircular<T extends Comparable<T>> implements IListaCircular<T> {
    private NodoCircular<T> ultimo;
    private int tamaño = 0;

    @Override
    public void add(T dato) {
        NodoCircular<T> nuevo = new NodoCircular<>(dato);
        if (estaVacia()) {
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
        if (estaVacia()) return null;
        NodoCircular<T> act = ultimo.siguiente;//primero
        while (act.siguiente != ultimo.siguiente) {
            if (act.dato.compareTo(dato) == 0) {
                return act.dato;
                }
            act = act.siguiente;
            }
            // comprobar el último nodo
            if (act.dato.compareTo(dato) == 0) {
                return act.dato;
            }

            return null;
        }

    @Override
    public T eliminar(T dato) {
        if (estaVacia()) return null;
        NodoCircular<T> act = ultimo.siguiente;
        NodoCircular<T> ant = ultimo;
        while (act.siguiente != ultimo.siguiente) {
            if (act.dato.compareTo(dato) == 0) {
                if (act == ultimo && act == ultimo.siguiente) {
                    ultimo = null;
                }
                else {
                    ant.siguiente = act.siguiente;
                    if (act == ultimo) ultimo = ant;
                }
                tamaño--;
                return act.dato;
            }
            ant = act;
            act = act.siguiente;
        }
        // comprobar último nodo
        if (act.dato.compareTo(dato) == 0) {
            if (act == ultimo && act == ultimo.siguiente) {
                ultimo = null;
            } else {
                ant.siguiente = act.siguiente;
                if (act == ultimo) ultimo = ant;
            }
            tamaño--;
            return act.dato;
        }
        return null;
    }

    @Override
    public boolean estaVacia() {
        return ultimo == null;
    }

    @Override
    public int getTamaño() {
        return tamaño;
    }

    @Override
    public void vaciar() {
        ultimo = null;
        tamaño = 0;
    }

    @Override
    public boolean contiene(T dato) {

        return get(dato) != null;
    }

    public T busqPos(int posicion){
        if (estaVacia() && posicion < 0 && posicion >= tamaño) {
            return null; // índice inválido o lista vacía
        }
        NodoCircular<T> act = ultimo.siguiente;
        int indice = 0;
        while (indice < posicion) {
            act = act.siguiente;
            indice++;
        }
        return act.dato;
    }

    @Override
    public T getPrimero() {
        if (ultimo != null) {
            return ultimo.siguiente.dato;
        } else {
            return null;
        }
    }

    @Override
    public T getUltimo() {
        if (ultimo != null) {
            return ultimo.dato;
        } else {
            return null;
        }
    }

    @Override
    public void imprimirLista() {
        if (estaVacia()) {
            System.out.println("Lista vacía");
            return;
        }
        NodoCircular<T> act = ultimo.siguiente;
        while (act.siguiente != ultimo.siguiente) {
            System.out.print(act.dato + " -> ");
            act = act.siguiente;
        }
        // imprimir el último nodo
        System.out.print(act.dato + " -> ");
        System.out.println("(vuelve al inicio)");
    }

    @Override
    public Iterador<T> getIterador() {
        return new IteradorListaCircular(this.ultimo);
    }
}