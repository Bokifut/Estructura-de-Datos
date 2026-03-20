package EstructuradeDatos.LIstaSimple;

// Interfaz principal para las Listas
public interface Lista<T extends Comparable<T>> {
    // Añade un dato
    void agregar(T dato);

    // Busca un dato y lo devuelve
    T obtener(T dato);

    // Elimina un dato y lo devuelve
    T eliminar(T dato);

    // Retorna true si no hay elementos
    boolean estaVacia();

    // Devuelve el tamaño actual
    int obtenerTamano();

    // Devuelve un iterador para la lista
    MiIterador<T> obtenerIterador();

    // Elimina todos los elementos
    void vaciar();

    // Retorna true si el dato existe
    boolean contiene(T dato);

    // Devuelve el primer dato
    T obtenerPrimero();

    // Devuelve el último dato
    T obtenerUltimo();
}