package Backtrack;

/**
 * Clase que genera todas las combinaciones binarias posibles de longitud n utilizando backtracking.
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class BacktrackCadena {
    private int n;              // Longitud de las cadenas binarias
    private char[] arreglo;     // Arreglo temporal para construir las combinaciones

    /**
     * @brief Constructor que inicializa la longitud de la cadena binaria.
     * @param n Longitud deseada para las combinaciones binarias.
     */
    public BacktrackCadena(int n) throws Exception {
        if (n <= 0) {
            throw new Exception("El tamaño de la cadena debe ser >= 1");
        }
        this.n = n;
        this.arreglo = new char[n];
    }

    /**
     * @brief Inicia el proceso de backtracking para generar todas las cadenas binarias.
     */
    public void generar() {
        backtrack(0);
    }

    /**
     * @brief Método recursivo que implementa el algoritmo de backtracking.
     * 
     * En cada llamada, se elige entre '0' y '1' para la posición actual,
     * y se avanza recursivamente hasta completar la cadena.
     * 
     * @param posicion Índice actual en el arreglo que se está llenando.
     */
    private void backtrack(int posicion) {
        if (posicion == n) {
            System.out.println(new String(arreglo));
            return;
        }

        // Intentar con '0'
        arreglo[posicion] = '0';
        backtrack(posicion + 1);

        // Intentar con '1'
        arreglo[posicion] = '1';
        backtrack(posicion + 1);
    }
}
