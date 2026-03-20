package EstructuradeDatos.LIstaSimple;

// Interfaz para recorrer estructuras elemento por elemento
public interface MiIterador<T> {
    // Retorna true si hay un elemento siguiente
    boolean tieneSiguiente();

    // Devuelve el elemento actual y avanza
    T siguiente();
}