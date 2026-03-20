package EstructuradeDatos.ListaCircula;

import EstructuradeDatos.LIstaSimple.Lista;
import EstructuradeDatos.LIstaSimple.MiIterador;
import java.util.NoSuchElementException;

// Lista donde el último nodo apunta al primero, formando un ciclo
public class ListaCircular<T extends Comparable<T>> implements IListaCircular<T>, Lista<T> {
    private NodoCircular<T> ultimo; // Único puntero necesario
    private int tamano = 0;

    @Override
    public void agregar(T dato) {
        NodoCircular<T> nuevo = new NodoCircular<>(dato);
        if (estaVacia()) {
            ultimo = nuevo;
            ultimo.siguiente = ultimo; 
        } else {
            nuevo.siguiente = ultimo.siguiente; 
            ultimo.siguiente = nuevo; 
            ultimo = nuevo; 
        }
        tamano++;
    }

    @Override
    public T obtener(T dato) {
        if (estaVacia()) return null;
        NodoCircular<T> aux = ultimo.siguiente; 
        do {
            if (aux.dato.compareTo(dato) == 0) return aux.dato;
            aux = aux.siguiente;
        } while (aux != ultimo.siguiente); 
        return null;
    }

    @Override
    public T eliminar(T dato) {
        if (estaVacia()) return null;
        
        NodoCircular<T> act = ultimo.siguiente; 
        NodoCircular<T> ant = ultimo; 
        
        do {
            if (act.dato.compareTo(dato) == 0) {
                if (act == ultimo && act == ultimo.siguiente) {
                    ultimo = null; // Era el único nodo
                } else {
                    ant.siguiente = act.siguiente; 
                    if (act == ultimo) {
                        ultimo = ant; 
                    }
                }
                tamano--;
                return act.dato;
            }
            ant = act;
            act = act.siguiente;
        } while (act != ultimo.siguiente);
        
        return null; 
    }

    @Override
    public boolean estaVacia() {
        return ultimo == null;
    }

    @Override
    public int obtenerTamano() {
        return tamano;
    }

    @Override
    public MiIterador<T> obtenerIterador() {
        return new IteradorListaCircular<>(ultimo);
    }

    @Override
    public void vaciar() {
        ultimo = null;
        tamano = 0;
    }

    @Override
    public boolean contiene(T dato) {
        return obtener(dato) != null;
    }

    @Override
    public T obtenerPrimero() {
        if (estaVacia()) throw new NoSuchElementException("Lista vacía");
        return ultimo.siguiente.dato;
    }

    @Override
    public T obtenerUltimo() {
        if (estaVacia()) throw new NoSuchElementException("Lista vacía");
        return ultimo.dato;
    }

    // Formato de impresión: [A -> B -> (A)]
    @Override
    public String toString() {
        if (estaVacia()) return "[]";
        StringBuilder sb = new StringBuilder("[");
        NodoCircular<T> aux = ultimo.siguiente; 
        do {
            sb.append(aux.dato);
            sb.append(" -> ");
            aux = aux.siguiente;
        } while (aux != ultimo.siguiente);
        sb.append("(").append(ultimo.siguiente.dato).append(")]");
        return sb.toString();
    }
}