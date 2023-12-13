package ListaArregloCricular;

/**
 * Clase ListaCircular, implementada con arrelgo de String y aritmetica modular
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class ListaCircular {
    private String[] lista;
    private int inicio, fin, N;

    /**
     * Constructor que inicializa la lista con la cantidad maxima de datos
     * indicada por N, además inicializa N, inicio y fin
     * 
     * @param N cantidad maxima de datos en la lsita
     */
    public ListaCircular(int N) {
        lista = new String[N];
        this.N = N;
        inicio = -1;
        fin = -1;
    }

    /**
     * Constructor que inicializa la lista con una cantidad maxima de 10 datos,
     * adenmas inicializa N, inicio y fin
     * 
     */
    public ListaCircular() {
        lista = new String[10];
        this.N = 10;
        inicio = -1;
        fin = -1;
    }

    /**
     * Devuelve verdadero si la lista esta vacia, falso en otro caso
     * 
     * @return verdadero con lista vacia, falso en otro caso
     */
    protected boolean esVacia() {
        if (inicio == -1) {
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
        if ((fin + 1) % N == inicio) {
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
        if (!esVacia()) {
            return ((N + fin - inicio) % N) + 1;
        } else {
            return 0;
        }
    }

    /**
     * Inserta un dato al inicio de la lista
     * 
     * @param dato a ser insertado
     * @return verdadero si se logra insertar, falso en caso contrario
     */
    protected boolean insertarInicio(String dato) {
        if (!esLlena()) {
            if (esVacia()) {
                inicio = fin = 0;
            } else {
                inicio = (inicio + N - 1) % N;
            }
            lista[inicio] = dato;
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
            if (esVacia()) {
                inicio = fin = 0;
            } else {
                fin = (fin + 1) % N;
            }
            lista[fin] = dato;
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
        if (!esLlena() && posicion >= 0 && posicion <= longitud()) {
            if (posicion == 0) {
                return insertarInicio(dato);
            } else if (posicion == longitud()) {
                return insertarFinal(dato);
            } else {
                int i = inicio;
                while (posicion > 0) {
                    lista[(i + N - 1) % N] = lista[i];
                    posicion--;
                    i = (i + 1) % N;
                }
                lista[(i + N - 1) % N] = dato;
                inicio = (inicio + N - 1) % N;
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
            lista[inicio] = null;
            if (longitud() > 1) {
                inicio = (inicio + 1) % N;
            } else {
                inicio = fin = -1;
            }
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
            lista[fin] = null;
            if (longitud() > 1) {
                fin = (fin + N - 1) % N;
            } else {
                inicio = fin = -1;
            }
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
        if (!esVacia() && posicion >= 0 && posicion < longitud()) {
            if (posicion == 0) {
                return eliminarInicio();
            } else if (posicion == longitud() - 1) {
                return eliminarFinal();
            } else {
                int i = (inicio + posicion) % N;
                while (i != inicio) {
                    lista[i] = lista[(i + N - 1) % N];
                    i = (i + N - 1) % N;
                }
                lista[inicio] = null;
                inicio = (inicio + 1) % N;
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
            int tmp = inicio;
            for (int i = 0; i < longitud(); i++) {
                if (lista[tmp].equals(dato)) {
                    return i;
                }
                tmp = (tmp + 1) % N;
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
        if (!esVacia() && posicion >= 0 && posicion < longitud()) {
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
        if (!esVacia() && posicion >= 0 && posicion < longitud()) {
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
        if (!esVacia()){
            int tmp = inicio;
            String datos = "[";
            for (int i = 0; i < longitud() - 1; i++) {
                datos += lista[tmp] + ", ";
                tmp = (tmp + 1) % N;
            }
            datos += lista[fin] + "]";
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
