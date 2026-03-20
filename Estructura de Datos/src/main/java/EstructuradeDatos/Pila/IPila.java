package EstructuradeDatos.Pila;

import EstructuradeDatos.LIstaSimple.MiIterador;

// Interfaz para la Pila
public interface IPila<T extends Comparable<T>> {
    // Añade un elemento a la cima
    void apilar(T dato);

    // Saca y devuelve el elemento de la cima
    T desapilar();

    // Mira el elemento de la cima sin sacarlo
    T verCima();

    // Retorna true si está vacía
    boolean estaVacia();

    // Devuelve el tamaño
    int obtenerTamano();

    // Vacía la pila
    void vaciar();

    // Retorna true si el dato existe
    boolean contiene(T dato);

    // Iterador para recorrer de cima a fondo
    MiIterador<T> obtenerIterador();
}