package EstructuradeDatos.ListaDoble;

import EstructuradeDatos.LIstaSimple.Lista;
import EstructuradeDatos.LIstaSimple.MiIterador;

// Lista donde cada nodo apunta al siguiente y al anterior
public class ListaDoblementeEnlazada<T extends Comparable<T>> implements Lista<T> {
    protected ElementoDE<T> primero; // Cabeza de la lista
    protected ElementoDE<T> ultimo; // Cola de la lista
    protected int tamano = 0; // Número de elementos

    @Override
    public void agregar(T dato) {
        ElementoDE<T> nuevo = new ElementoDE<>(dato);
        if (estaVacia()) {
            primero = ultimo = nuevo;
        } else {
            ultimo.siguiente = nuevo;
            nuevo.anterior = ultimo;
            ultimo = nuevo;
        }
        tamano++;
    }

    @Override
    public T obtener(T dato) {
        ElementoDE<T> aux = primero;
        while (aux != null) {
            if (aux.dato.compareTo(dato) == 0) return aux.dato;
            aux = aux.siguiente;
        }
        return null;
    }

    @Override
    public T eliminar(T dato) {
        ElementoDE<T> aux = primero;
        while (aux != null) {
            if (aux.dato.compareTo(dato) == 0) {
                if (aux.anterior != null) {
                    aux.anterior.siguiente = aux.siguiente;
                } else {
                    primero = aux.siguiente;
                }

                if (aux.siguiente != null) {
                    aux.siguiente.anterior = aux.anterior;
                } else {
                    ultimo = aux.anterior;
                }

                tamano--;
                return aux.dato;
            }
            aux = aux.siguiente;
        }
        return null;
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
    public MiIterador<T> obtenerIterador() {
        return new IteradorLDE<>(this.primero);
    }

    @Override
    public void vaciar() {
        primero = null;
        ultimo = null;
        tamano = 0;
    }

    @Override
    public boolean contiene(T dato) {
        return obtener(dato) != null;
    }

    @Override
    public T obtenerPrimero() {
        return primero != null ? primero.dato : null;
    }

    @Override
    public T obtenerUltimo() {
        return ultimo != null ? ultimo.dato : null;
    }

    // Formato de impresión: [A <-> B <-> C]
    @Override
    public String toString() {
        if (estaVacia()) return "[]";
        StringBuilder sb = new StringBuilder("[");
        ElementoDE<T> aux = primero;
        while (aux != null) {
            sb.append(aux.dato);
            if (aux.siguiente != null) sb.append(" <-> ");
            aux = aux.siguiente;
        }
        sb.append("]");
        return sb.toString();
    }
}