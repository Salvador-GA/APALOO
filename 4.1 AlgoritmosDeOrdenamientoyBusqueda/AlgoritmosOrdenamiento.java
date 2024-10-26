/**
 * Clase AlgoritmosOrdenamiento, implementa los algoritmos de ordenamiento:
 * burbuja
 * burbuja2, una mejora de burbuja
 * seleccion
 * insercion
 * conteo
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class AlgoritmosOrdenamiento {

    /**
     * Algoritmo por intercambio, burbuja
     * 
     * @param arreglo a ser ordenado
     */
    public static void burbuja(int[] arreglo) {
        for (int i = 0; i < arreglo.length - 1; i++) {
            for (int j = i + 1; j < arreglo.length; j++) {
                if (arreglo[i] > arreglo[j]) {
                    int aux = arreglo[i];
                    arreglo[i] = arreglo[j];
                    arreglo[j] = aux;
                }
            }
        }
    }

    /**
     * Mejora del algoritmo por intercambio, burbuja2
     * 
     * @param arreglo a ser ordenado
     */
    public static void burbuja2(int[] arreglo) {
        boolean intercambio = true;
        for (int i = 0; i < arreglo.length - 1 && intercambio; i++) {
            intercambio = false;
            for (int j = i + 1; j < arreglo.length; j++) {
                if (arreglo[i] > arreglo[j]) {
                    int aux = arreglo[i];
                    arreglo[i] = arreglo[j];
                    arreglo[j] = aux;
                    intercambio = true;
                }
            }
        }
    }

    /**
     * Algoritmo por seleccion
     * 
     * @param arreglo a ser ordenado
     */
    public static void seleccion(int arreglo[]) {
        int indiceMenor;
        for (int i = 0; i < arreglo.length - 1; i++) {
            indiceMenor = i;
            for (int j = i + 1; j < arreglo.length; j++) {
                if (arreglo[j] < arreglo[indiceMenor]) {
                    indiceMenor = j;
                }
            }
            if (i != indiceMenor) {
                int aux = arreglo[i];
                arreglo[i] = arreglo[indiceMenor];
                arreglo[indiceMenor] = aux;
            }
        }
    }

    /**
     * Algoritmo por insercion
     * 
     * @param arreglo a ser ordenado
     */
    public static void insercion(int[] arreglo) {
        int j, aux;
        for (int i = 1; i < arreglo.length; i++) {
            j = i;
            aux = arreglo[i];
            while (j > 0 && aux < arreglo[j - 1]) {
                arreglo[j] = arreglo[j - 1];
                j--;
            }
            arreglo[j] = aux;
        }
    }

    /**
     * Algoritmo por conteo
     * 
     * @param arreglo a ser ordenado
     */
    public static void conteo(int[] arreglo) {
        int max = -1;
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] > max) {
                max = arreglo[i];
            }
        }
        int[] cont = new int[max + 1];
        for (int i = 0; i < cont.length; i++) {
            cont[i] = 0;
        }
        for (int i = 0; i < arreglo.length; i++) {
            cont[arreglo[i]]++;
        }
        int j = 0;
        for (int i = 0; i < cont.length; i++) {
            while (cont[i] > 0) {
                arreglo[j] = i;
                j++;
                cont[i]--;
            }
        }
    }

}
