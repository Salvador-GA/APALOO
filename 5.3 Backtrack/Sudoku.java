package Backtrack;

/**
 * @class Sudoku
 * @brief Clase que implementa la lógica para resolver tableros de Sudoku.
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class Sudoku {

    private static final int N = 9;

    /** < Tamaño del tablero de Sudoku (9x9). */

    /**
     * @brief Resuelve un tablero de Sudoku utilizando un algoritmo recursivo con
     *        backtracking.
     *
     * @param tablero Matriz de enteros que representa el tablero de Sudoku. Los
     *                espacios vacíos
     *                están representados por el valor 0.
     * @return true si el Sudoku tiene solución, false en caso contrario.
     *
     * @note El algoritmo intenta colocar números del 1 al 9 en las celdas vacías,
     *       verificando
     *       que cumplan las reglas del Sudoku. Si encuentra una solución, modifica
     *       directamente
     *       el tablero original.
     */
    public static boolean resolverSudoku(int[][] tablero) {
        int[] celdaVacia = encontrarCeldaVacia(tablero);
        if (celdaVacia == null) {
            // No hay celdas vacías, el Sudoku está resuelto
            return true;
        }

        int fila = celdaVacia[0];
        int columna = celdaVacia[1];

        for (int num = 1; num <= N; num++) {
            if (esValido(tablero, fila, columna, num)) {
                tablero[fila][columna] = num; // Colocar el número
                if (resolverSudoku(tablero)) {
                    return true; // Solución encontrada
                }
                tablero[fila][columna] = 0; // Backtracking: deshacer el cambio
            }
        }

        return false; // No hay solución posible
    }

    /**
     * @brief Encuentra la primera celda vacía en el tablero.
     *
     * @param tablero Matriz de enteros que representa el tablero de Sudoku.
     * @return Un arreglo de dos elementos que indica la fila y la columna de la
     *         celda vacía,
     *         o null si no hay celdas vacías.
     */
    private static int[] encontrarCeldaVacia(int[][] tablero) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (tablero[i][j] == 0) {
                    return new int[] { i, j };
                }
            }
        }
        return null;
    }

    /**
     * @brief Verifica si un número puede colocarse en una celda específica del
     *        tablero.
     *
     * @param tablero Matriz de enteros que representa el tablero de Sudoku.
     * @param fila    Índice de la fila de la celda.
     * @param columna Índice de la columna de la celda.
     * @param num     Número a verificar.
     * @return true si el número puede colocarse en la celda sin violar las reglas
     *         del Sudoku,
     *         false en caso contrario.
     */
    private static boolean esValido(int[][] tablero, int fila, int columna, int num) {
        // Verificar fila
        for (int j = 0; j < N; j++) {
            if (tablero[fila][j] == num) {
                return false;
            }
        }

        // Verificar columna
        for (int i = 0; i < N; i++) {
            if (tablero[i][columna] == num) {
                return false;
            }
        }

        // Verificar subcuadro 3x3
        int inicioFila = fila - (fila % 3);
        int inicioColumna = columna - (columna % 3);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[inicioFila + i][inicioColumna + j] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * @brief Imprime el tablero de Sudoku en la consola.
     *
     * @param tablero Matriz de enteros que representa el tablero de Sudoku.
     */
    public static void imprimirTablero(int[][] tablero) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }
}
