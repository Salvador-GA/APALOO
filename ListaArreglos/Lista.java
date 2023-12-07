package ListaArreglos;

/**
 * Clase Lista, implementada con arrelgo de String
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class Lista {
    private String[] lista;
    private int longitud;

    /**
     * Constructor que inicializa la lista con la cantidad maxima de datos
     * indicada por tam
     * 
     * @param tam cantidad maxima de datos en la lsita
     */
    public Lista(int tam) {
        lista = new String[tam];
        longitud = 0;
    }

    /**
     * Constructor que inicializa la lista con una cantidad maxima de 10 datos
     */
    public Lista() {
        lista = new String[10];
        longitud = 0;
    }

    /**
     * Devuelve verdadero si la lista esta vacia, falso en otro caso
     * 
     * @return verdadero con lista vacia, falso en otro caso
     */
    protected boolean esVacia() {
        if (longitud == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Devuelve verdadero si la lista esta llena, falso en otro caso
     * 
     * @return verdadero con lista llena, falso en otro caso
     */
    protected boolean esLlena() {
        if (longitud == lista.length) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Devuelve la longitud de la lista
     * 
     * @return longitud de la lista
     */
    protected int longitud() {
        return longitud;
    }

    /**
     * Inserta un dato al inicio de la lista
     * 
     * @param dato a ser insertado
     * @return verdadero si se logra insertar, falso en caso contrario
     */
    protected boolean insertarInicio(String dato) {
        if (!esLlena()) {
            for (int i = longitud; i > 0; i--) {
                lista[i] = lista[i - 1];
            }
            lista[0] = dato;
            longitud++;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Inserta un dato al final de la lista
     * 
     * @param dato a ser insertado
     * @return verdadero si se logra insertar, falso en caso contrario
     */
    protected boolean insertarFinal(String dato) {
        if (!esLlena()) {
            lista[longitud] = dato;
            longitud++;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Inserta un dato en la posicion indicada
     * 
     * @param dato     a ser insertado
     * @param posicion donde se debe insertar
     * @return verdadero si se logra insertar, falso en caso contrario
     */
    protected boolean insertar(String dato, int posicion) {
        if (!esLlena() && posicion >= 0 && posicion <= longitud) {
            if (posicion == 0) {
                return insertarInicio(dato);
            } else if (posicion == longitud) {
                return insertarFinal(dato);
            } else {
                for (int i = longitud; i > posicion; i--) {
                    lista[i] = lista[i - 1];
                }
                lista[posicion] = dato;
                longitud++;
                return true;
            }
        } else {
            return false;
        }
    }

    /**
     * Elimina un dato del inicio de la lista
     * 
     * @return verdadero si se logra eliminar, falso en caso contrario
     */
    protected boolean eliminarInicio() {
        if (!esVacia()) {
            for (int i = 0; i < longitud - 1; i++) {
                lista[i] = lista[i + 1];
            }
            lista[longitud - 1] = null;
            longitud--;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Elimina un dato del final de la lista
     * 
     * @return verdadero si se logra eliminar, falso en caso contrario
     */
    protected boolean eliminarFinal() {
        if (!esVacia()) {
            lista[longitud - 1] = null;
            longitud--;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Elimina el dato de la posicion indicada
     * 
     * @param posicion a eliminar
     * @return verdadero si se logra eliminar, falso en caso contrario
     */
    protected boolean eliminar(int posicion) {
        if (!esVacia() && posicion >= 0 && posicion < longitud) {
            if (posicion == 0) {
                return eliminarInicio();
            } else if (posicion == longitud - 1) {
                return eliminarFinal();
            } else {
                for (int i = posicion; i < longitud - 1; i++) {
                    lista[i] = lista[i + 1];
                }
                lista[longitud - 1] = null;
                longitud--;
                return true;
            }
        } else {
            return false;
        }
    }

    /**
     * Busca un dato en la lista
     * 
     * @param dato a buscar
     * @return posicion del dato si se encuentra, -1 en otro caso
     */
    protected int buscar(String dato) {
        if (!esVacia()) {
            for (int i = 0; i < longitud; i++) {
                if (lista[i].equals(dato)) {
                    return i;
                }
            }
            return -1;
        } else {
            return -1;
        }
    }

    /**
     * Devuelve el dato en la posicion indicada
     * 
     * @param posicion para devolver el dato
     * @return el dato buscado, null si la posicion no es valida o no hay datos
     */
    protected String devolver(int posicion) {
        if (!esVacia() && posicion >= 0 && posicion < longitud) {
            return lista[posicion];
        } else {
            return null;
        }
    }

    /**
     * Reemplaza un dato en la posicion indicada
     * 
     * @param dato     que reemplazara al de la posicion indicada
     * @param posicion en la que se reemplazara el dato
     * @return verdadero si se logra reemplazar, falso en caso contrario
     */
    protected boolean reemplazar(String dato, int posicion) {
        if (!esVacia() && posicion >= 0 && posicion < longitud) {
            lista[posicion] = dato;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Devuelve los datos de la lista en un string
     */
    public String toString() {
        if (!esVacia()){
            String datos = "[";
            for (int i = 0; i < longitud - 1; i++) {
                datos += lista[i] + ", ";
            }
            datos += lista[longitud - 1] + "]";
            return datos;
        } else {
            return "[]";
        }
    }

}
