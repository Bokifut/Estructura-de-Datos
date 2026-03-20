package EstructuradeDatos.Pila;

import EstructuradeDatos.LIstaSimple.MiIterador;
import java.util.EmptyStackException;

// Implementación de Pila con nodos enlazados
public class Pila<T extends Comparable<T>> implements IPila<T> {
    private NodoPila<T> cima; // Puntero al elemento superior
    private int tamano = 0; // Número de elementos

    @Override
    public void apilar(T dato) {
        NodoPila<T> nuevo = new NodoPila<>(dato);
        nuevo.siguiente = cima;
        cima = nuevo;
        tamano++;
    }

    @Override
    public T desapilar() {
        if (estaVacia()) throw new EmptyStackException();
        T dato = cima.dato;
        cima = cima.siguiente;
        tamano--;
        return dato;
    }

    @Override
    public T verCima() {
        if (estaVacia()) throw new EmptyStackException();
        return cima.dato;
    }

    @Override
    public boolean estaVacia() {
        return cima == null;
    }

    @Override
    public int obtenerTamano() {
        return tamano;
    }

    @Override
    public void vaciar() {
        cima = null;
        tamano = 0;
    }

    @Override
    public boolean contiene(T dato) {
        NodoPila<T> aux = cima;
        while (aux != null) {
            if (aux.dato.compareTo(dato) == 0) return true;
            aux = aux.siguiente;
        }
        return false;
    }

    @Override
    public MiIterador<T> obtenerIterador() {
        return new IteradorPila<>(cima);
    }

    // Formato de impresión: [Cima -> Elemento -> Fondo]
    @Override
    public String toString() {
        if (estaVacia()) return "[]";
        StringBuilder sb = new StringBuilder("[");
        NodoPila<T> aux = cima;
        while (aux != null) {
            sb.append(aux.dato);
            if (aux.siguiente != null) sb.append(" -> ");
            aux = aux.siguiente;
        }
        sb.append("]");
        return sb.toString();
    }
}