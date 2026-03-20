package EstructuradeDatos.Cola;

import EstructuradeDatos.LIstaSimple.MiIterador;
import java.util.NoSuchElementException;

// Implementación de Cola con punteros al primero y al último
public class Cola<T extends Comparable<T>> implements ICola<T> {
    private NodoCola<T> primero;
    private NodoCola<T> ultimo;
    private int tamano = 0; // Número de elementos

    @Override
    public void encolar(T dato) {
        NodoCola<T> nuevo = new NodoCola<>(dato);
        if (ultimo == null) {
            primero = ultimo = nuevo; 
        } else {
            ultimo.siguiente = nuevo; 
            ultimo = nuevo; 
        }
        tamano++;
    }

    @Override
    public T desencolar() {
        if (estaVacia()) throw new NoSuchElementException("Cola vacía");
        T dato = primero.dato;
        primero = primero.siguiente;
        
        if (primero == null) {
            ultimo = null;
        }
        tamano--;
        return dato;
    }

    @Override
    public T verFrente() {
        if (estaVacia()) throw new NoSuchElementException("Cola vacía");
        return primero.dato;
    }

    @Override
    public boolean estaVacia() {
        return primero == null;
    }

    @Override
    public int obtenerTamano() {
        return tamano;
    }

    @Override
    public void vaciar() {
        primero = null;
        ultimo = null;
        tamano = 0;
    }

    @Override
    public boolean contiene(T dato) {
        NodoCola<T> aux = primero;
        while (aux != null) {
            if (aux.dato.compareTo(dato) == 0) return true;
            aux = aux.siguiente;
        }
        return false;
    }

    @Override
    public MiIterador<T> obtenerIterador() {
        return new IteradorCola<>(primero);
    }

    // Formato de impresión: [Frente -> Medio -> Final]
    @Override
    public String toString() {
        if (estaVacia()) return "[]";
        StringBuilder sb = new StringBuilder("[");
        NodoCola<T> aux = primero;
        while (aux != null) {
            sb.append(aux.dato);
            if (aux.siguiente != null) sb.append(" -> ");
            aux = aux.siguiente;
        }
        sb.append("]");
        return sb.toString();
    }
}