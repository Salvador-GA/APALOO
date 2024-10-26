/**
 * Clase ListaEnlazadaSimple, mantiene una lista por medio de referencias a
 * objetos tipo Nodo
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class ListaEnlazadaSimple {
    Nodo inicio;
    Nodo fin;
    int longitud;

    /**
     * Constructor de la clase, inicializa la referencia inicio a null y la longitud
     * a 0
     */
    public ListaEnlazadaSimple() {
        inicio = null;
        fin = null;
        longitud = 0;
    }

    /**
     * Indica si la lsita esta vacia
     * 
     * @return verdader si es vacia, falso si no es vacia
     */
    public boolean esVacia() {
        return (longitud == 0);
    }

    /**
     * Devuelve la cantidad de datos en la lista
     * 
     * @return longitud
     */
    public int longitud() {
        return longitud;
    }

    /**
     * Inserta un dato al inicio de la lista
     * 
     * @param dato a ser insertado
     */
    public void insertarInicio(String dato) {
        Nodo nuevo = new Nodo(dato, inicio);
        if(esVacia()){
            fin = nuevo;
        }
        inicio = nuevo;
        longitud++;
    }

    /**
     * Inserta un dato al final de la lista
     * 
     * @param dato a ser insertado
     */
    public void insertarFinal(String dato) {
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
     * Inserta un dato en la posicion especificada
     * 
     * @param dato     a ser insertado
     * @param posicion donde se quiere insertar el dato
     * @return verdadero si se logra insertar, falso en caso contrario
     */
    public boolean insertar(String dato, int posicion) {
        if (posicion >= 0 && posicion <= longitud) {
            if (posicion == 0) {
                insertarInicio(dato);
            } else if (posicion == longitud) {
                insertarFinal(dato);
            } else {
                Nodo auxRecorrer = inicio;
                for (int i = 0; i < posicion - 1; i++) {
                    auxRecorrer = auxRecorrer.getSiguiente();
                }
                Nodo nuevo = new Nodo(dato, auxRecorrer.getSiguiente());
                auxRecorrer.setSiguiente(nuevo);
                longitud++;
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     * Elimina un dato del inicio la lista
     * 
     * @return verdadero si se pudo eliminar, falso en caso contrario
     */
    public boolean eliminarInicio() {
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
     * Elimina un dato del final de la lista
     * 
     * @return verdadero si se pudo eliminar, falso en caso contrario
     */
    public boolean eliminarFinal() {
        if (!esVacia()) {
            if (inicio == fin){
                inicio = fin = null;
            } else {
                Nodo auxRecorrer = inicio;
                while (auxRecorrer.getSiguiente() != fin){
                    auxRecorrer = auxRecorrer.getSiguiente();
                }
                auxRecorrer.setSiguiente(null);
                fin = auxRecorrer;
            }
            longitud--;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Elimina un dato de la lista en la posicion indicada
     * 
     * @param posicion de donde se quiere eliminar el dato
     * @return verdadero si se pudo eliminar, falso en caso contrario
     */
    public boolean eliminar(int posicion) {
        if (posicion >= 0 && posicion < longitud) {
            if (posicion == 0) {
                return eliminarInicio();
            } else if (posicion == longitud - 1) {
                return eliminarFinal();
            } else {
                Nodo auxRecorrer = inicio;
                for (int i = 0; i < posicion - 1; i++) {
                    auxRecorrer = auxRecorrer.getSiguiente();
                }
                auxRecorrer.setSiguiente(auxRecorrer.getSiguiente().getSiguiente());
                longitud--;
                return true;
            }
        } else {
            return false;
        }
    }

    /**
     * Determina si un dato se encuentra en la lista
     * 
     * @param dato a ser buscado
     * @return posicion del dato si se encuentra, -1 en otro caso
     */
    public int buscar(String dato) {
        if (!esVacia()) {
            Nodo auxRecorrer = inicio;
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
     * Devuelve el dato de la posicion indicada
     * 
     * @param posicion de donde se quiere recuperar el dato
     * @return el dato si la posicion es valida y la lista no esta vacia, null en
     *         otro caso
     */
    public String devolver(int posicion) {
        if (!esVacia() && posicion >= 0 && posicion < longitud) {
            Nodo auxRecorrer = inicio;
            for (int i = 0; i < posicion; i++) {
                auxRecorrer = auxRecorrer.getSiguiente();
            }
            return auxRecorrer.getDato();
        } else {
            return null;
        }
    }

    /**
     * Reemplaza un dato en la posicion indicada
     * 
     * @param dato     para reemplazar el existente
     * @param posicion donde se quiere guardar el dato
     * @return verdadero si la posicion es valida y la lista no esta vacia, falso en
     *         otro caso
     */
    public boolean reemplazar(String dato, int posicion) {
        if (!esVacia() && posicion >= 0 && posicion < longitud) {
            Nodo auxRecorrer = inicio;
            for (int i = 0; i < posicion; i++) {
                auxRecorrer = auxRecorrer.getSiguiente();
            }
            auxRecorrer.setDato(dato);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Devuelve los datos de la lista en un Strins
     */
    public String toString() {
        if (!esVacia()){
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
