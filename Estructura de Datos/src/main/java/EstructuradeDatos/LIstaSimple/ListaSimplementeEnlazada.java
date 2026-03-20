package EstructuradeDatos.LIstaSimple;

// Lista donde cada nodo apunta solo al siguiente
public class ListaSimplementeEnlazada<T extends Comparable<T>> implements Lista<T> {
    protected ElementoSE<T> primero; // Cabeza de la lista
    protected int tamano = 0; // Número de elementos

    @Override
    public void agregar(T dato) {
        ElementoSE<T> nuevo = new ElementoSE<>(dato);
        if (primero == null) {
            primero = nuevo;
        } else {
            ElementoSE<T> aux = primero;
            while (aux.siguiente != null) {
                aux = aux.siguiente;
            }
            aux.siguiente = nuevo;
        }
        tamano++;
    }

    @Override
    public T obtener(T dato) {
        ElementoSE<T> aux = primero;
        while (aux != null) {
            if (aux.dato.compareTo(dato) == 0) return aux.dato;
            aux = aux.siguiente;
        }
        return null;
    }

    @Override
    public T eliminar(T dato) {
        ElementoSE<T> act = primero, ant = null;
        while (act != null) {
            if (act.dato.compareTo(dato) == 0) {
                if (ant == null) {
                    primero = act.siguiente;
                } else {
                    ant.siguiente = act.siguiente;
                }
                tamano--;
                return act.dato;
            }
            ant = act;
            act = act.siguiente;
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
        return new IteradorLSE<>(this.primero);
    }

    @Override
    public void vaciar() {
        primero = null;
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
        if (primero == null) return null;
        ElementoSE<T> aux = primero;
        while (aux.siguiente != null) aux = aux.siguiente;
        return aux.dato;
    }

    // Formato de impresión: [A -> B -> C]
    @Override
    public String toString() {
        if (estaVacia()) return "[]";
        StringBuilder sb = new StringBuilder("[");
        ElementoSE<T> aux = primero;
        while (aux != null) {
            sb.append(aux.dato);
            if (aux.siguiente != null) sb.append(" -> ");
            aux = aux.siguiente;
        }
        sb.append("]");
        return sb.toString();
    }
}