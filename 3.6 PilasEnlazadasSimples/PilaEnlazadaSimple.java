/**
 * Clase PilaEnlazadaSimple, mantiene una Pila por medio de referencias a
 * objetos tipo Nodo
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class PilaEnlazadaSimple {
    private Nodo tope;
    private int longitud;

    /**
     * Constructor de la clase, inicializa la referencia tope a null y la longitud
     * a 0
     */
    public PilaEnlazadaSimple() {
        tope = null;
        longitud = 0;
    }

    /**
     * Indica si la pila esta vacia
     * 
     * @return verdadero si es vacia, falso si no es vacia
     */
    public boolean esVacia() {
        return (longitud == 0);
    }

    /**
     * Devuelve la cantidad de datos en la pila
     * 
     * @return longitud
     */
    public int longitud() {
        return longitud;
    }

    /**
     * Inserta un dato en el tope de la pila
     * 
     * @param dato a ser insertado
     */
    public void apilar(String dato) {
        Nodo nuevo = new Nodo(dato, tope);
        tope = nuevo;
        longitud++;
    }

    /**
     * Elimina un dato del tope la pila
     * 
     * @return verdadero si se pudo eliminar, falso en caso contrario
     */
    public boolean desapilar() {
        if (!esVacia()) {
            tope = tope.getSiguiente();
            longitud--;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Determina si un dato se encuentra en la pila
     * 
     * @param dato a ser buscado
     * @return posicion del dato si se encuentra, -1 en otro caso
     */
    public int buscar(String dato) {
        if (!esVacia()) {
            Nodo auxRecorrer = tope;
            for (int i = 0; i < longitud; i++) {
                if (dato.equals(auxRecorrer.getDato())) {
                    return i;
                }
                auxRecorrer = auxRecorrer.getSiguiente();
            }
            return -1;
        } else {
            return -1;
        }
    }

    /**
     * Devuelve el dato del tope de la pila
     * 
     * @return el dato si la pila no esta vacia, null en otro caso
     */
    public String frente() {
        if (!esVacia()) {
            return tope.getDato();
        } else {
            return null;
        }
    }

    /**
     * Devuelve los datos de la lista en un Strins
     */
    public String toString() {
        if (!esVacia()) {
            String elementos = "[";
            Nodo auxRecorrer = tope;
            for (int i = 0; i < longitud - 1; i++) {
                elementos += auxRecorrer.getDato() + ", ";
                auxRecorrer = auxRecorrer.getSiguiente();
            }
            elementos += auxRecorrer.getDato() + "]";
            return elementos;
        } else {
            return "[]";
        }
    }

}
