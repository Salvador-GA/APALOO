package BacktrackEjer;

/**
 * Clase Subconjuntos, encuentra todos los posibles subconjuntos a partir de un
 * arreglo de entrada, que sumen una cantidad especificada tambien, utiliza la
 * tecnica de backtrack
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class Subconjuntos {

    /**
     * Metodo recursivo para encontrar los subconjuntos,
     * - prueba si ha encontrado una solucion, si es asi la imprime
     * - si no revisa si ya no puede avanzar mas, si es asi regresa
     * - en cualquier otro caso intenta encontrar una solucion con y
     * - sin el siguiente numero
     * 
     * @param entrada  arreglo que contiene los numeros de entrada
     * @param suma     objetivo buscado en los subconjuntos
     * @param indice   actual en el que se va a trabajar con la entrada
     * @param auxiliar arreglo que contiene el subconjunto con la posible solucion
     */
    public static void backtrack(int[] entrada, int suma, int indice, int[] auxiliar) {
        if (suma == 0) { // prueba si ha encontrado una solucion
            System.out.print("[ ");
            for (int i = 0; i < auxiliar.length; i++) {
                System.out.print(auxiliar[i] + " ");
            }
            System.out.println("]");
            return;
        } else if (suma < 0 || indice >= entrada.length) { // revisa si ya no puede avanzar mas
            return;
        } else { // intenta encontrar una solucion
            // probamos el siguiente numero
            int nuevoTam = auxiliar.length + 1;
            int[] nuevo = new int[nuevoTam];
            for (int i = 0; i < auxiliar.length; i++) {
                nuevo[i] = auxiliar[i];
            }
            nuevo[nuevoTam - 1] = entrada[indice];
            backtrack(entrada, suma - entrada[indice], indice + 1, nuevo);
            // probamos sin el siguiente numero
            backtrack(entrada, suma, indice + 1, auxiliar);
        }
    }

    /**
     * Metodo inicial para encontrar los subconjuntos a partir de la entrada y la
     * suma
     * 
     * @param entrada arreglo que contiene los numeros de entrada
     * @param suma    objetivo buscado en los subconjuntos
     */
    public static void enocontrarConjuntos(int[] entrada, int suma) {
        int[] auxiliar = new int[0];
        int indice = 0;
        backtrack(entrada, suma, indice, auxiliar);
    }

    public static void main(String[] args) {
        int[] entrada = {1, 2, 4, 5, 6, 10};
        int suma = 10;

        System.out.print("Entrada: [ ");
        for(int i=0; i<entrada.length; i++) {
            System.out.print(entrada[i] + " ");
        }
        System.out.println("]");
        System.out.println("Suma: "+suma);
        System.out.println("Subconjuntos encontrados: ");
        enocontrarConjuntos(entrada, suma);
    }

}
