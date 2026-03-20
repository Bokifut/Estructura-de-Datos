package EstructuradeDatos.ListaDoble;

// Variante de la lista doble que mantiene los elementos ordenados
public class LDEOrdenada<T extends Comparable<T>> extends ListaDoblementeEnlazada<T> {
    
    // Inserta el dato en su posición correcta
    @Override
    public void agregar(T dato) {
        ElementoDE<T> nuevo = new ElementoDE<>(dato);
        
        if (estaVacia()) {
            primero = ultimo = nuevo;
        } else if (primero.dato.compareTo(dato) >= 0) {
            // Inserción al inicio
            nuevo.siguiente = primero;
            primero.anterior = nuevo;
            primero = nuevo;
        } else if (ultimo.dato.compareTo(dato) <= 0) {
            // Inserción al final
            super.agregar(dato); 
            return;
        } else {
            // Inserción en el medio
            ElementoDE<T> act = primero;
            while (act != null && act.dato.compareTo(dato) < 0) {
                act = act.siguiente;
            }
            nuevo.siguiente = act;
            nuevo.anterior = act.anterior;
            if (act.anterior != null) {
                act.anterior.siguiente = nuevo;
            }
            act.anterior = nuevo;
        }
        tamano++;
    }
}