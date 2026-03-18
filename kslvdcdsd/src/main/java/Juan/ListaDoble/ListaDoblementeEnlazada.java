package Juan.ListaDoble;

import Juan.LIstaSimple.Lista;
import Juan.LIstaSimple.MiIterador;

public class ListaDoblementeEnlazada<T extends Comparable<T>> implements Lista<T> {
    protected ElementoDE<T> primero, ultimo;
    protected int tamaño = 0;

    @Override
    public void add(T dato) {
        ElementoDE<T> nuevo = new ElementoDE<>(dato);
        if (isEmpty()) {
            primero = ultimo = nuevo;
        } else {
            ultimo.siguiente = nuevo;
            nuevo.anterior = ultimo;
            ultimo = nuevo;
        }
        tamaño++;
    }

    @Override
    public T get(T dato) {
        ElementoDE<T> aux = primero;
        while (aux != null) {
            if (aux.dato.compareTo(dato) == 0) return aux.dato;
            aux = aux.siguiente;
        }
        return null;
    }

    @Override
    public T del(T dato) {
        ElementoDE<T> aux = primero;
        while (aux != null) {
            if (aux.dato.compareTo(dato) == 0) {
                if (aux.anterior != null) aux.anterior.siguiente = aux.siguiente;
                else primero = aux.siguiente;

                if (aux.siguiente != null) aux.siguiente.anterior = aux.anterior;
                else ultimo = aux.anterior;

                tamaño--;
                return aux.dato;
            }
            aux = aux.siguiente;
        }
        return null;
    }

    @Override public boolean isEmpty() { return primero == null; }
    @Override public int getSize() { return tamaño; }

    @Override
    public MiIterador<T> getIterador() {
        return new IteradorLDE<>(this.primero);
    }

    @Override
    public void clear() {
        primero = null;
        ultimo = null;
        tamaño = 0;
    }

    @Override
    public boolean contains(T dato) {
        return get(dato) != null;
    }

    @Override
    public T getFirst() {
        return primero != null ? primero.dato : null;
    }

    @Override
    public T getLast() {
        return ultimo != null ? ultimo.dato : null;
    }
}