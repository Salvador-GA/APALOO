package UsoArchivosColaPila;

/**
 * Clase ColaEnlazadaSimple, mantiene una cola por medio de referencias a
 * objetos tipo Nodo
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class ColaEnlazadaSimple {
    private Nodo inicio;
    private Nodo fin;
    private int longitud;

    /**
     * Constructor de la clase, inicializa la referencia inicio y fin a null y
     * la longitud a 0
     */
    public ColaEnlazadaSimple() {
        inicio = null;
        fin = null;
        longitud = 0;
    }

    /**
     * Indica si la cola esta vacia
     * 
     * @return verdadero si es vacia, falso si no es vacia
     */
    public boolean esVacia() {
        return (longitud == 0);
    }

    /**
     * Devuelve la cantidad de datos en la cola
     * 
     * @return longitud
     */
    public int longitud() {
        return longitud;
    }

    /**
     * Inserta un dato al final de la cola
     * 
     * @param dato a ser insertado
     */
    public void encolar(char dato) {
        Nodo nuevo = new Nodo(dato, null);
        if (esVacia()) {
            inicio = nuevo;
        } else {
            fin.setSiguiente(nuevo);
        }
        fin = nuevo;
        longitud++;
    }

    /**
     * Elimina un dato del inicio la cola
     * 
     * @return verdadero si se pudo eliminar, falso en caso contrario
     */
    public boolean desencolar() {
        if (!esVacia()) {
            if (inicio == fin) {
                inicio = fin = null;
            } else {
                inicio = inicio.getSiguiente();
            }
            longitud--;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Determina si un dato se encuentra en la cola
     * 
     * @param dato a ser buscado
     * @return posicion del dato si se encuentra, -1 en otro caso
     */
    public int buscar(char dato) {
        if (!esVacia()) {
            Nodo auxRecorrer = inicio;
            for (int i = 0; i < longitud; i++) {
                if (dato == auxRecorrer.getDato()) {
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
     * Devuelve el dato del inicio de la cola
     * 
     * @return el dato si la cola no esta vacia, null en otro caso
     */
    public char frente() {
        if (!esVacia()) {
            return inicio.getDato();
        } else {
            return '0';
        }
    }

    /**
     * Devuelve los datos de la cola en un String
     */
    public String toString() {
        if (!esVacia()) {
            String elementos = "[";
            Nodo auxRecorrer = inicio;
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
