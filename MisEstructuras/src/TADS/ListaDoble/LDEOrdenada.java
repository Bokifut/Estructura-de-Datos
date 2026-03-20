package TADS.ListaDoble;

public class LDEOrdenada<T extends Comparable<T>> extends ListaDoblementeEnlazada<T> {
    @Override
    public void add(T dato) {
        NodoLDE<T> nuevo = new NodoLDE<>(dato);
        if (estaVacia()) {
            cabeza = ultimo = nuevo;
        } else if (cabeza.dato.compareTo(dato) >= 0) {
            nuevo.siguiente = cabeza;
            cabeza.anterior = nuevo;
            cabeza = nuevo;
        } else if (ultimo.dato.compareTo(dato) <= 0) {
            super.add(dato); // Usa la lógica de insertar al final
            return;
        } else {
           NodoLDE<T> act = cabeza;
            while (act != null && act.dato.compareTo(dato) < 0) {
                act = act.siguiente;
            }
            nuevo.siguiente = act;
            nuevo.anterior = act.anterior;
            act.anterior.siguiente = nuevo;
            act.anterior = nuevo;
        }
        tamaño++;
    }
}