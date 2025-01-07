package DivideyVenceras;

/**
 * @class TorresHanoi
 * @brief Clase que proporciona una solución recursiva para el problema de las
 *        Torres de Hanoi.
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class TorresHanoi {

    /**
     * @brief Resuelve el problema de las Torres de Hanoi.
     *
     *        Este método imprime los movimientos necesarios para trasladar los
     *        discos desde
     *        la torre inicial hasta la torre final, utilizando una torre auxiliar,
     *        mientras
     *        se cumplen las reglas del problema.
     *
     * @param n   Número de discos a mover.
     * @param ini Nombre o identificador de la torre inicial.
     * @param aux Nombre o identificador de la torre auxiliar.
     * @param fin Nombre o identificador de la torre final.
     *
     * @note El problema de las Torres de Hanoi implica mover \(n\) discos de una
     *       torre a otra,
     *       utilizando una torre auxiliar y respetando las reglas: solo un disco
     *       puede moverse
     *       a la vez, y ningún disco puede colocarse sobre uno más pequeño.
     *
     * @warning El método asume que \(n \geq 1\). Si \(n = 0\), no se realizarán
     *          movimientos.
     *
     * @example
     *          TorresHanoi.resolverHanoi(3, "Inicial", "Auxiliar", "Final");
     */
    public static void resolverHanoi(int n, String ini, String aux, String fin) {
        if (n == 1) {
            System.out.println("Movemos el disco " + n + " desde " + ini + " a " + fin);
        } else if (n > 1) {
            resolverHanoi(n - 1, ini, fin, aux);
            System.out.println("Movemos el disco " + n + " desde " + ini + " a " + fin);
            resolverHanoi(n - 1, aux, ini, fin);
        }
    }
}
