package Juan.LIstaSimple;

public class LSEOrdenada<T extends Comparable<T>> extends ListaSimplementeEnlazada<T> {
    private ElementoSE<T> ultimo;

    @Override
    public void add(T dato) {
        ElementoSE<T> nuevo = new ElementoSE<>(dato);
        if (isEmpty()) {
            primero = ultimo = nuevo;
        } else if (primero.dato.compareTo(dato) >= 0) {
            nuevo.siguiente = primero;
            primero = nuevo;
        } else if (ultimo.dato.compareTo(dato) <= 0) {
            super.add(dato);
            return;
        } else {
            ElementoSE<T> act = primero;
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