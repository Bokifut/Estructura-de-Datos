package EstructuradeDatos.LIstaSimple;

// Iterador para recorrer una lista simple
public class IteradorLSE<T> implements MiIterador<T> {
    private ElementoSE<T> actual;

    public IteradorLSE(ElementoSE<T> comienzo) {
        this.actual = comienzo;
    }

    @Override
    public boolean tieneSiguiente() {
        return actual != null;
    }

    @Override
    public T siguiente() {
        if (!tieneSiguiente()) return null;
        T dato = actual.dato;
        actual = actual.siguiente;
        return dato;
    }
}