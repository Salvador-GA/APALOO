package Backtrack;

/**
 * @class Sudoku
 * @brief Clase que implementa la lógica para resolver tableros de Sudoku.
 * 
 * @author Salvador Gonzalez Arellano
 * @version 2.0
 */
public class Sudoku {

    /** Tamaño del tablero de Sudoku (9x9). */
    private static final int N = 9;
    private int[][] tablero;
    private boolean solucion;

    /**
     * @brief Constructor de la clase Sudoku.
     * 
     * Este constructor recibe una matriz de enteros de 9x9 como tablero inicial.
     * Verifica que sea una matriz válida y copia su contenido al tablero del objeto.
     * 
     * @param tableroInicial Una matriz de enteros de 9x9 que representa el estado inicial del Sudoku.
     *                       Los valores válidos van de 0 (casilla vacía) a 9.
     * 
     * @throws Exception Si la matriz es nula, no es de tamaño 9x9,
     *         alguna fila no tiene longitud 9, o alguna celda contiene un valor inválido.
     */
    public Sudoku(int[][] tableroInicial) throws Exception {
        // Verificamos que el tablero no sea nulo y tenga exactamente 9 filas
        if (tableroInicial != null && tableroInicial.length == N) {
            for (int i = 0; i < N; i++) {
                // Verificamos que cada fila no sea nula y tenga exactamente 9 columnas
                if (tableroInicial[i] == null || tableroInicial[i].length != N) {
                    throw new Exception("El tablero del sudoku debe ser 9x9, la fila " + i + " no lo es");
                }
            }

            // Creamos una copia del tablero inicial en el tablero del objeto
            this.tablero = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // Verificamos que cada número esté entre 0 y 9 (inclusive)
                    if (tableroInicial[i][j] >= 0 && tableroInicial[i][j] <= 9) {
                        this.tablero[i][j] = tableroInicial[i][j]; // Copiamos el valor
                    } else {
                        throw new Exception("La celda (" + i + ", " + j + 
                            ") no tiene un número válido. Solo se permite 0 para celdas vacías y 1–9 para celdas con número.");
                    }
                }
            }
            solucion = false;
        } else {
            // Si el tablero es nulo o no tiene 9 filas, lanzamos excepción
            throw new Exception("El tablero del sudoku debe ser 9x9");
        }
    }

    /**
     * @brief Resuelve un tablero de Sudoku utilizando un algoritmo recursivo con
     *        backtracking.
     * @note El algoritmo intenta colocar números del 1 al 9 en las celdas vacías,
     *       verificando que cumplan las reglas del Sudoku. Si encuentra una solución, 
     *       modifica directamente el tablero original.
     */
    public void resolver() {
        int[] celdaVacia = encontrarCeldaVacia();
        if (celdaVacia == null) {
            // No hay celdas vacías, el Sudoku está resuelto
            solucion = true;
            imprimirTablero();
            return;
        }

        int fila = celdaVacia[0];
        int columna = celdaVacia[1];

        for (int num = 1; num <= N; num++) {
            if (esValido(fila, columna, num)) {
                tablero[fila][columna] = num; // Colocar el número
                resolver();
                if (solucion) {
                    return; // Solución encontrada
                }
                tablero[fila][columna] = 0; // Backtracking: deshacer el cambio
            }
        }

        return; // No hay solución posible en este camino
    }

    /**
     * @brief Encuentra la primera celda vacía en el tablero.
     *
     * @return Un arreglo de dos elementos que indica la fila y la columna de la
     *         celda vacía,
     *         o null si no hay celdas vacías.
     */
    private int[] encontrarCeldaVacia() {
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
     * @param fila    Índice de la fila de la celda.
     * @param columna Índice de la columna de la celda.
     * @param num     Número a verificar.
     * @return true si el número puede colocarse en la celda sin violar las reglas
     *         del Sudoku,
     *         false en caso contrario.
     */
    private boolean esValido(int fila, int columna, int num) {
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
     */
    public void imprimirTablero() {
        for (int i = 0; i < N; i++) {
            // Línea horizontal superior cada 3 filas (excepto la primera)
            if (i % 3 == 0 && i != 0) {
                System.out.println("------+-------+------");
            }
            for (int j = 0; j < N; j++) {
                // Línea vertical cada 3 columnas (excepto la primera)
                if (j % 3 == 0 && j != 0) {
                    System.out.print("| ");
                }
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }
}
