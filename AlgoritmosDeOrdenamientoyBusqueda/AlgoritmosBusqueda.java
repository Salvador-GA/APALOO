package AlgoritmosDeOrdenamientoyBusqueda;

/**
 * Clase AlgoritmosBusqueda, implementa los algoritmos de busqueda:
 * lineal
 * binaria
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class AlgoritmosBusqueda {

    /**
     * Algoritmo de busqueda lineal
     * 
     * @param arreglo donde se buscara la clave
     * @param clave   elemnto que se desea buscar
     * @return indice de la clave si se encuentra, -1 en otro caso
     */
    public static int busquedaLineal(int[] arreglo, int clave) {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == clave) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Algoritmo de busqueda binaria
     * 
     * @param arreglo donde se buscara la clave
     * @param clave   elemnto que se desea buscar
     * @return indice de la clave si se encuentra, -1 en otro caso
     */
    public static int busquedaBinaria(int[] arreglo, int clave) {
        int central, bajo, alto;
        bajo = 0;
        alto = arreglo.length - 1;
        while (bajo <= alto) {
            central = (bajo + alto) / 2;            // índice de elemento central
            if (clave == arreglo[central]) {
                return central;                     // encontrado, devuelve posición
            } else if (clave < arreglo[central]) {
                alto = central - 1;                 // ir a sublista inferior
            } else {
                bajo = central + 1;                 // ir a sublista superior
            }
        }
        return -1;
    }
}
