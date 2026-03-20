package EstructuradeDatos.LIstaSimple;

// Variante de la lista simple que mantiene los elementos ordenados automáticamente
public class LSEOrdenada<T extends Comparable<T>> extends ListaSimplementeEnlazada<T> {
    private ElementoSE<T> ultimo; // Puntero al último elemento

    // Inserta un dato en la posición correcta para mantener el orden
    @Override
    public void agregar(T dato) {
        ElementoSE<T> nuevo = new ElementoSE<>(dato);
        
        if (estaVacia()) {
            primero = ultimo = nuevo;
        } else if (primero.dato.compareTo(dato) >= 0) {
            // Inserción al principio
            nuevo.siguiente = primero;
            primero = nuevo;
        } else if (ultimo.dato.compareTo(dato) <= 0) {
            // Inserción al final
            super.agregar(dato);
            ElementoSE<T> aux = primero;
            while (aux.siguiente != null) aux = aux.siguiente;
            ultimo = aux;
            return;
        } else {
            // Inserción en el medio
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
        tamano++;
    }
}