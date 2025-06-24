/**
 * Clase ListaCircular, implementada con arrelgo de String y aritmetica modular
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.1
 */
public class ListaCircular {

    /**
     * El arreglo que contiene los elementos de la lista circular.
     */
    private String[] lista;

    /**
     * Índice de inicio de la lista circular. Representa la posición
     * en la que se encuentra el primer elemento.
     */
    private int inicio;

    /**
     * Índice de fin de la lista circular. Representa la posición
     * en la que se encuentra el último elemento.
     */
    private int fin;

    /**
     * Tamaño máximo de la lista circular.
     */
    private int N;

    /**
     * Cantidad de elementos en la lista circular.
     */
    private int longitud;

    /**
     * Constructor que inicializa la lista con la cantidad maxima de datos
     * indicada por N, además inicializa N, inicio, fin y longitud
     * 
     * @param N cantidad maxima de datos en la lsita
     */
    public ListaCircular(int N) {
        lista = new String[N];
        this.N = N;
        inicio = 0;
        fin = 0;
        longitud = 0;
    }

    /**
     * Constructor que inicializa la lista con una cantidad maxima de 10 datos,
     * adenmas inicializa N, inicio, fin y longitud
     */
    public ListaCircular() {
        // alternativamente podemos usar this(10);
        lista = new String[10];
        N = 10;
        inicio = 0;
        fin = 0;
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
        if (N == longitud) {
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
            inicio = (inicio + N - 1) % N;
            lista[inicio] = dato;
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
            lista[fin] = dato;
            fin = (fin + 1) % N;
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
            int i = inicio;
            while (posicion > 0) {
                lista[(i + N - 1) % N] = lista[i];
                posicion--;
                i = (i + 1) % N;
            }
            lista[(i + N - 1) % N] = dato;
            inicio = (inicio + N - 1) % N;
            longitud++;
            return true;
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
            lista[inicio] = null;
            inicio = (inicio + 1) % N;
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
            fin = (fin + N - 1) % N;
            lista[fin] = null;
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
            int i = (inicio + posicion) % N;
            while (i != inicio) {
                lista[i] = lista[(i + N - 1) % N];
                i = (i + N - 1) % N;
            }
            lista[inicio] = null;
            inicio = (inicio + 1) % N;
            longitud--;
            return true;
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
            int tmp = inicio;
            for (int i = 0; i < longitud; i++) {
                if (lista[tmp].equals(dato)) {
                    return i;
                }
                tmp = (tmp + 1) % N;
            }
        }
        return -1;
    }

    /**
     * Devuelve el dato en la posicion indicada
     * 
     * @param posicion para devolver el dato
     * @return el dato buscado, null si la posicion no es valida o no hay datos
     */
    protected String devolver(int posicion) {
        if (!esVacia() && posicion >= 0 && posicion < longitud) {
            return lista[(inicio + posicion) % N];
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
            lista[(inicio + posicion) % N] = dato;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Devuelve los datos de la lista en un string
     */
    public String toString() {
        if (!esVacia()) {
            int tmp = inicio;
            String datos = "[";
            for (int i = 0; i < longitud() - 1; i++) {
                datos += lista[tmp] + ", ";
                tmp = (tmp + 1) % N;
            }
            datos += lista[(fin + N -1)%N] + "]";
            return datos;
        } else {
            return "[]";
        }
    }

    /**
     * Muestra el estado interno de la lista circular
     * 
     * @return
     */
    public String estadoActual() {
        String estado = "Inicio: " + inicio + "\nFin: " + fin + "\n[";
        for (int i = 0; i < N - 1; i++) {
            estado += lista[i] + ", ";
        }
        estado += lista[N - 1] + "]";
        return estado;
    }

}
