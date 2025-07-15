/**
 * Clase AlgoritmosOrdenamiento, implementa el algoritmo de ordenamiento
 * burbuja2, una mejora de burbuja, para ordenar Strings y objetos d ela clase
 * Persona
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.1
 */
public class AlgoritmosOrdenamiento {

    /**
     * Estos algoritmos utilizan la función compareTo para determinar como son 2
     * objetos comparados entre si, devuelve los siguientes valores para
     * arreglo[j].compareTo(arreglo[j + 1]):
     * 
     * < 0 si arreglo[j] es menor que arreglo[j + 1]
     *   0 si arreglo[j] es igual que arreglo[j + 1]
     * > 0 si arreglo[j] es mayor que arreglo[j + 1]
     */

    /**
     * Mejora del algoritmo por intercambio, burbuja2
     * 
     * @param arreglo a ser ordenado
     */
    public static void burbujaString(String[] arreglo) {
        boolean intercambiado = true; // Bandera para detectar intercambios

        for (int i = 0; i < arreglo.length - 1 && intercambiado; i++) {
            intercambiado = false; // Reiniciar bandera al inicio de cada pasada
            for (int j = 0; j < arreglo.length - 1 - i; j++) {
                if (arreglo[j].compareTo(arreglo[j + 1]) > 0) {
                    // Intercambiar
                    String aux = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = aux;
                    intercambiado = true; // Se realizó al menos un intercambio
                }
            }
        }
    }

    /**
     * Mejora del algoritmo por intercambio, burbuja2
     * 
     * @param arreglo a ser ordenado
     */
    public static void burbujaPersona(Persona[] arreglo) {
        boolean intercambiado = true; // Bandera para detectar intercambios

        for (int i = 0; i < arreglo.length - 1 && intercambiado; i++) {
            intercambiado = false; // Reiniciar bandera al inicio de cada pasada
            for (int j = 0; j < arreglo.length - 1 - i; j++) {
                if (arreglo[j].compareTo(arreglo[j + 1]) > 0) {
                    // Intercambiar
                    Persona aux = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = aux;
                    intercambiado = true; // Se realizó al menos un intercambio
                }
            }
        }
    }

    /**
     * Algoritmo de burbuja genérico.
     * Ordena cualquier arreglo cuyos elementos implementen Comparable.
     *
     * @param <T> tipo de dato que extiende Comparable
     * @param arreglo arreglo a ordenar
     */
    public static <T extends Comparable<T>> void burbujaGenerico(T[] arreglo) {
        boolean intercambiado = true;

        for (int i = 0; i < arreglo.length - 1 && intercambiado; i++) {
            intercambiado = false;
            for (int j = 0; j < arreglo.length - 1 - i; j++) {
                if (arreglo[j].compareTo(arreglo[j + 1]) > 0) {
                    // Intercambiar elementos
                    T aux = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = aux;
                    intercambiado = true;
                }
            }
        }
    }

}
