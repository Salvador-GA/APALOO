package UsoArchivosColaPila;

/**
 * Clase nodo, almacena un dato y la referencia al siguiente nodo en la lista
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class Nodo {
    private char dato;
    private Nodo siguiente;

    /**
     * Constructor de la clase para crear un nodo con el dato y referencia al
     * siguiente nodo en la lista
     * 
     * @param dato      dato que el nodo va a almacenar
     * @param siguiente referencia al siguiente nodo en la lista
     */
    public Nodo(char dato, Nodo siguiente) {
        this.dato = dato;
        this.siguiente = siguiente;
    }

    /**
     * Devuelve el dato almacenado en el nodo
     * 
     * @return dato
     */
    public char getDato() {
        return dato;
    }

    /**
     * Actualiza el valor de dato por el recibido como parametro
     * 
     * @param dato para actualizar el valor del nodo
     */
    public void setDato(char dato) {
        this.dato = dato;
    }

    /**
     * Devuelve la referencia al siguiente nodo en la lista
     * 
     * @return siguiente
     */
    public Nodo getSiguiente() {
        return siguiente;
    }

    /**
     * Actualiza la referencia del siguiente nodo en la lista
     * 
     * @param siguiente nodo en la lista
     */
    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

}