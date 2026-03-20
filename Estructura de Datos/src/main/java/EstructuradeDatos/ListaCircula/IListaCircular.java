package EstructuradeDatos.ListaCircula;

import EstructuradeDatos.LIstaSimple.MiIterador;

// Interfaz para la Lista Circular
public interface IListaCircular<T extends Comparable<T>> {
    // Añade un dato
    void agregar(T dato);
    
    // Obtiene un dato sin eliminarlo
    T obtener(T dato);
    
    // Elimina un dato
    T eliminar(T dato);
    
    // Retorna true si está vacía
    boolean estaVacia();
    
    // Devuelve el número de elementos
    int obtenerTamano();
    
    // Devuelve un iterador circular
    MiIterador<T> obtenerIterador();
    
    // Vacía la lista
    void vaciar();
    
    // Retorna true si el dato existe
    boolean contiene(T dato);
    
    // Retorna el primer elemento
    T obtenerPrimero();
    
    // Retorna el último elemento
    T obtenerUltimo();
}