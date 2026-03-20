package TADS.ListaDoble;

import TADS.ListaSimple.Iterador;
import TADS.ListaSimple.Lista;

public class ListaDoblementeEnlazada<T extends Comparable<T>> implements Lista<T> {
    protected NodoLDE<T> cabeza, ultimo;
    protected int tamaño = 0;

    @Override
    public void add(T dato) {
        NodoLDE<T> nuevo = new NodoLDE<>(dato);
        if (estaVacia()) {
            cabeza = ultimo = nuevo;
        } else {
            ultimo.siguiente = nuevo;
            nuevo.anterior = ultimo;
            ultimo = nuevo;
        }
        tamaño++;
    }
    public void addPrimero(T dato) {
        // Paso 1: Creamos el nuevo nodo con el dato
        NodoLDE<T> nuevoNodo = new NodoLDE<>(dato);

        // Paso 2: El "siguiente" del nuevo nodo apunta a la cabeza actual.
        // (Nota: Si la lista estaba vacía, cabeza es null, así que el nuevo nodo apuntará a null. ¡Eso es correcto!)
        nuevoNodo.siguiente=cabeza;

        // Paso 3: La cabeza de la lista pasa a ser este nuevo nodo
        cabeza = nuevoNodo;

        // Paso 4: Aumentamos el contador de elementos
        tamaño++;
    }


    @Override
    public T get(T dato) {
        NodoLDE<T> act = cabeza;
        while (act != null) {
            if (act.dato.compareTo(dato) == 0) return act.dato;
            act = act.siguiente;
        }
        return null;
    }

    @Override
    public T eliminar(T dato) {
        NodoLDE<T> act = cabeza;
        while (act != null) {
            if (act.dato.compareTo(dato) == 0) {
                if (act.anterior != null) act.anterior.siguiente = act.siguiente;
                else cabeza = act.siguiente;

                if (act.siguiente != null) act.siguiente.anterior = act.anterior;
                else ultimo = act.anterior;

                tamaño--;
                return act.dato;
            }
            act = act.siguiente;
        }
        return null;
    }

    @Override public boolean estaVacia() { return cabeza == null; }
    @Override public int getTamaño() { return tamaño; }

    @Override
    public void vaciar() {
        cabeza = null;
        ultimo = null;
        tamaño = 0;
    }

    @Override
    public boolean contiene(T dato) {
        return get(dato) != null;
    }

    @Override
    public T busqPos(int posicion) {
        if (posicion < 0 && posicion >= tamaño){
            return null;
        }
        NodoLDE<T> act = cabeza;
        int ind = 0;
        while (ind < posicion) {
            act = act.siguiente;
            ind++;
        }
        return act.dato;
    }

    @Override
    public int getPosicion(T dato) {
        NodoLDE<T> act = cabeza;
        int posicion = 0;

        while (act != null) {
            if (act.dato.compareTo(dato) == 0) {
                return posicion; // encontrado
            }
            act = act.siguiente;
            posicion++;
        }
        return -1; // no encontrado
    }
    public T buscarPorPosicion(int posicion) {

        if (posicion < 0 && posicion >= tamaño){
            return null;
        }
        NodoLDE<T> act = cabeza;
        int ind = 0;
        while (ind < posicion) {
            act = act.siguiente;
            ind++;
        }
        return act.dato;
    }


    @Override
    public T getPrimero() {
        if (cabeza != null) {
            return cabeza.dato;
        } else {
            return null;
        }
    }
    @Override
    public T getUltimo() {
        return ultimo != null ? ultimo.dato : null;
    }

    @Override
    public void imprimirLista() {
        NodoLDE<T> act = cabeza;
        System.out.print("[");
        while (act != null) {
            System.out.print(act.dato + ",");
            act = act.siguiente;
        }
        System.out.println("]");
    }
    @Override
    public Iterador<T> getIterador() {
        return new IteradorLDE<>(this.cabeza);
    }

}




