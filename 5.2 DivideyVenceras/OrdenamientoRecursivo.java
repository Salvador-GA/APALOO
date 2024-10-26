/**
 * Clase OrdenamientoRecursivo, implementa los algoritmos de ordenamiento:
 * MergeSort
 * QuickSort
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class OrdenamientoRecursivo {

    /**
     * metodo recursivo que divide el problema de ordenar en 2 partes
     * y luego mezcla las partes ordenadas
     * 
     * @param arreglo el arreglo que se quiere ordenar
     * @param izq     indice desde donde se quiere trabajar
     * @param der     indice hasta donde se va trabajar
     */
    public static void mergeSort(int[] arreglo, int izq, int der) {
        if (izq < der) {
            int medio = (izq + der) / 2;
            mergeSort(arreglo, izq, medio);
            mergeSort(arreglo, medio + 1, der);
            merge(arreglo, izq, medio, der);
        }
    }

    /**
     * metodo que mezcla la parte izquierda y derecha en orden
     * 
     * @param arreglo donde quedará ordenada la mezcla
     * @param izq     desde donde se va a trabajar
     * @param medio   punto donde se partio el arreglo en dos
     * @param der     hasta donde se va a trabajar
     */
    private static void merge(int[] arreglo, int izq, int medio, int der) {
        // Creando arreglos temporales
        int arregloIzq[] = new int[medio - izq + 1];
        int arregloDer[] = new int[der - medio];

        // Copiando los subarreglos en los arreglos temporales
        for (int i = 0; i < arregloIzq.length; i++) {
            arregloIzq[i] = arreglo[izq + i];
        }
        for (int i = 0; i < arregloDer.length; i++) {
            arregloDer[i] = arreglo[medio + i + 1];
        }

        int indiceIzq = 0;
        int indiceDer = 0;

        // Copiando de los arreglos temporales a nuestro arreglo final
        for (int i = izq; i < der + 1; i++) {
            // Si ambos arreglos temporales tienen elementos que copiar, copiamos al más
            // chico de ellos
            if (indiceIzq < arregloIzq.length && indiceDer < arregloDer.length) {
                if (arregloIzq[indiceIzq] < arregloDer[indiceDer]) {
                    arreglo[i] = arregloIzq[indiceIzq];
                    indiceIzq++;
                } else {
                    arreglo[i] = arregloDer[indiceDer];
                    indiceDer++;
                }
            } else if (indiceIzq < arregloIzq.length) {
                // Si ya se han copiado todos los elementos de arregloDer, copiamos el resto de
                // arregloIzq
                arreglo[i] = arregloIzq[indiceIzq];
                indiceIzq++;
            } else if (indiceDer < arregloDer.length) {
                // Si ya se han copiado todos los elementos de arregloIzq, copiamos el resto de
                // arregloDer
                arreglo[i] = arregloDer[indiceDer];
                indiceDer++;
            }
        }
    }

    /**
     * metodo recursivo que divide el problema de ordenar en 2 partes
     * y va ordenando cada parte
     * 
     * @param arreglo el arreglo que se quiere ordenar
     * @param izq     indice desde donde se quiere trabajar
     * @param der     indice hasta donde se va trabajar
     */
    public static void quicksort(int arreglo[], int izq, int der) {
        int pivote = arreglo[izq]; // tomamos primer elemento como pivote
        int i = izq; // i realiza la búsqueda de izquierda a derecha
        int j = der; // j realiza la búsqueda de derecha a izquierda

        while (i < j) { // mientras no se crucen las búsquedas
            while (arreglo[i] <= pivote && i < j) { // busca elemento mayor que pivote
                i++;
            }
            while (arreglo[j] > pivote) { // busca elemento menor que pivote
                j--;
            }
            if (i < j) { // si no se han cruzado
                int aux = arreglo[i]; // los intercambia
                arreglo[i] = arreglo[j];
                arreglo[j] = aux;
            }
        }
        arreglo[izq] = arreglo[j]; // se coloca el pivote en su lugar de forma que tendremos
        arreglo[j] = pivote; // los menores a su izquierda y los mayores a su derecha
        if (izq < j - 1) {
            quicksort(arreglo, izq, j - 1); // ordenamos subarray izquierdo
        }
        if (j + 1 < der) {
            quicksort(arreglo, j + 1, der); // ordenamos subarray derecho
        }
    }

}
