package DivideyVenceras;

/**
 * Clase BusquedaRecursiva, implementa el algoritmo de busqueda:
 * BusquedaBinaria
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.1
 */
public class BusquedaRecursiva {

    /**
     * Algoritmo de busqueda binaria recursiva
     * 
     * @param arreglo   donde se buscara la clave
     * @param clave     elemnto que se desea buscar
     * @param inicio    desde donde se va a buscar
     * @param fin       hasta donde se va a buscar
     * @return indice de la clave si se encuentra, -1 en otro caso
     */
    public static int busquedaBinaria(int arreglo[], int clave, int inicio, int fin) {
        int medio;
        if (inicio > fin) { // no encontrado
            return -1;
        } else {
            medio = (inicio + fin) / 2;
            if (arreglo[medio] == clave) {
                return medio;
            } else if (arreglo[medio] < clave) {
                return busquedaBinaria(arreglo, clave, medio + 1, fin);
            } else {
                return busquedaBinaria(arreglo, clave, inicio, medio - 1);
            }
        }
    }
}
