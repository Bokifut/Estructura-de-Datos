package TADS.ListaSimple;

public class LSEOrdenada<T extends Comparable<T>> extends ListaSimplementeEnlazada<T> {
    private NodoLSE<T> ultimo;

    @Override
    public void add(T dato) {
        NodoLSE<T> nuevo = new NodoLSE<>(dato);
        if (estaVacia()) {
            cabeza = ultimo = nuevo;
        } else if (cabeza.dato.compareTo(dato) >= 0) {
            nuevo.siguiente = cabeza;
            cabeza = nuevo;
        } else if (ultimo.dato.compareTo(dato) <= 0) {
            super.add(dato);
            return;
        } else {
            NodoLSE<T> act = cabeza;
            while (act.siguiente != null && act.siguiente.dato.compareTo(dato) < 0) {
                act = act.siguiente;
            }
            nuevo.siguiente = act.siguiente;
            act.siguiente = nuevo;
            if (nuevo.siguiente == null) {
                ultimo = nuevo;
            }
        }
        tamaño++;
    }
}