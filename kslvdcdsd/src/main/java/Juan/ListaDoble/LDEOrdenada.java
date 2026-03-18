package Juan.ListaDoble;

public class LDEOrdenada<T extends Comparable<T>> extends ListaDoblementeEnlazada<T> {
    @Override
    public void add(T dato) {
        ElementoDE<T> nuevo = new ElementoDE<>(dato);
        if (isEmpty()) {
            primero = ultimo = nuevo;
        } else if (primero.dato.compareTo(dato) >= 0) {
            nuevo.siguiente = primero;
            primero.anterior = nuevo;
            primero = nuevo;
        } else if (ultimo.dato.compareTo(dato) <= 0) {
            super.add(dato); // Usa la lógica de insertar al final
            return;
        } else {
            ElementoDE<T> act = primero;
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