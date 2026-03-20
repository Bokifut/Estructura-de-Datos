package EstructuradeDatos.Cola;

import EstructuradeDatos.LIstaSimple.MiIterador;

// Interfaz para la Cola
public interface ICola<T extends Comparable<T>> {
    // Añade un elemento al final
    void encolar(T dato);

    // Saca y devuelve el elemento del frente
    T desencolar();

    // Mira el elemento del frente sin sacarlo
    T verFrente();

    // Retorna true si está vacía
    boolean estaVacia();

    // Devuelve el tamaño
    int obtenerTamano();

    // Vacía la cola
    void vaciar();

    // Retorna true si el dato existe
    boolean contiene(T dato);

    // Iterador para recorrer del frente al final
    MiIterador<T> obtenerIterador();
}