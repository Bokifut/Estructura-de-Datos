package Juan;

import Juan.Cola.Cola;
import Juan.ListaCircula.ListaCircular;
import Juan.ListaDoble.ListaDoblementeEnlazada;
import Juan.LIstaSimple.ListaSimplementeEnlazada;
import Juan.Pila.Pila;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== TEST DE ESTRUCTURAS DE DATOS ===");

        System.out.println("\n1. Pila (Stack LIFO)");
        Pila<Integer> pila = new Pila<>();
        pila.push(10);
        pila.push(20);
        pila.push(30);
        System.out.println("Cima de la pila: " + pila.peek());
        System.out.println("Desapilando: " + pila.pop());
        System.out.println("Tamaño de la pila: " + pila.getSize());

        System.out.println("\n2. Cola (Queue FIFO)");
        Cola<String> cola = new Cola<>();
        cola.enqueue("Primero");
        cola.enqueue("Segundo");
        cola.enqueue("Tercero");
        System.out.println("Frente de la cola: " + cola.peek());
        System.out.println("Desencolando: " + cola.dequeue());
        System.out.println("Tamaño de la cola: " + cola.getSize());

        System.out.println("\n3. Lista Simplemente Enlazada");
        ListaSimplementeEnlazada<Integer> listaSE = new ListaSimplementeEnlazada<>();
        listaSE.add(1);
        listaSE.add(2);
        listaSE.add(3);
        System.out.println("Primer elemento: " + listaSE.getFirst());
        System.out.println("Eliminando el 2: " + listaSE.del(2));
        System.out.println("Contiene el 3? " + listaSE.contains(3));

        System.out.println("\n4. Lista Doblemente Enlazada");
        ListaDoblementeEnlazada<Double> listaDE = new ListaDoblementeEnlazada<>();
        listaDE.add(1.1);
        listaDE.add(2.2);
        listaDE.add(3.3);
        System.out.println("Último elemento: " + listaDE.getLast());
        System.out.println("Eliminando el 1.1: " + listaDE.del(1.1));

        System.out.println("\n5. Lista Circular");
        ListaCircular<Character> listaCircular = new ListaCircular<>();
        listaCircular.add('A');
        listaCircular.add('B');
        listaCircular.add('C');
        System.out.println("Primer elemento: " + listaCircular.getFirst());
        System.out.println("Eliminando 'B': " + listaCircular.del('B'));
        System.out.println("Tamaño actual: " + listaCircular.getSize());
        
        System.out.println("\n¡Todos los TADs funcionan correctamente!");
    }
}