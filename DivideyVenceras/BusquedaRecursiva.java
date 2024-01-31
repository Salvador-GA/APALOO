package DivideyVenceras;

/**
 * Clase BusquedaRecursiva, implementa el algoritmo de busqueda:
 * BusquedaBinaria
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class BusquedaRecursiva {

    /**
     * Algoritmo de busqueda binaria recursiva
     * 
     * @param arreglo donde se buscara la clave
     * @param clave   elemnto que se desea buscar
     * @param izq     desde donde se va a buscar
     * @param der     hasta donde se va a buscar
     * @return indice de la clave si se encuentra, -1 en otro caso
     */
    public static int busquedaBinaria(int arreglo[], int clave, int izq, int der) {
        int medio;
        if (izq > der) { // no encontrado
            return -1;
        } else {
            medio = (izq + der) / 2;
            if (arreglo[medio] == clave) {
                return medio;
            } else if (arreglo[medio] < clave) {
                return busquedaBinaria(arreglo, clave, medio + 1, der);
            } else {
                return busquedaBinaria(arreglo, clave, izq, medio - 1);
            }
        }
    }
}
