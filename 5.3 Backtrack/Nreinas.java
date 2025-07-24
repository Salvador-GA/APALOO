package Backtrack;

/**
 * Clase Nreinas, resuelve el problema de colocar N reinas sin que se ataquen en
 * un tablero de NxN
 * 
 * @author Salvador Gonzalez Arellano
 * @version 2.0
 */
public class Nreinas {
    private int N;
    private int[][] tablero;
    private int contadorSoluciones;
    private boolean solucionEncontrada;

    /**
     * Constructor de la clase, inicializa los atributos si N es positivo,
     * si no es asi arroja una excepcion
     * 
     * @param N tamaño del tablero NxN
     * @throws Exception N debe ser positivo
     */
    public Nreinas(int N) throws Exception {
        if (N > 0) {
            this.N = N;
            tablero = new int[N][N];
            contadorSoluciones = 0;
            solucionEncontrada = false;
        } else {
            throw new Exception("N debe ser positivo");
        }
    }

    /**
     * Actualiza el valor de N e inicializa el resto de atributos de nuevo
     * 
     * @param N
     * @throws Exception
     */
    public void setN(int N) throws Exception {
        if (N > 0) {
            this.N = N;
            tablero = new int[N][N];
            contadorSoluciones = 0;
            solucionEncontrada = false;
        } else {
            throw new Exception("N debe ser positivo");
        }
    }

    /**
     * Metodo que verifica si es seguro colocar una reina en una ubicacion dada
     * 
     * @param fila    en la que se pondra a la reina
     * @param columna en la que se pondra a la reina
     * @return verdadero si la posicion es segura, falso en otro caso
     **/
    private boolean esSeguro(int fila, int columna) {
        // Verificar la fila hacia la izquierda
        for (int i = 0; i < columna; i++) {
            if (tablero[fila][i] != 0) {
                return false;
            }
        }
        // Verificar la diagonal superior izquierda
        for (int i = fila-1, j = columna-1; i >= 0 && j >= 0; i--, j--) {
            if (tablero[i][j] != 0) {
                return false;
            }
        }
        // Verificar la diagonal inferior izquierda
        for (int i = fila+1, j = columna-1; i < N && j >= 0; i++, j--) {
            if (tablero[i][j] != 0) {
                return false;
            }
        }
        return true; // La posición es segura para colocar una reina
    }

    /**
     * Metodo recursivo que encuentra todas las posibles soluciones de un
     * tablero e imprime la primera que encuentra
     * 
     * @param columna donde se intenta colocar la reina actualmente
     **/
    private void resolverNReinas(int columna) {
        if (columna == N) {
            // Se ha encontrado una solución
            contadorSoluciones++;
            if (!solucionEncontrada) { // Imprime la primer solución encontrada
                System.out.println("Solución encontrada:");
                imprimirTablero();
                solucionEncontrada = true;
            }
        } else {
            for (int i = 0; i < N; i++) {
                if (esSeguro(i, columna)) {
                    tablero[i][columna] = 1; // Colocar una reina en esta posición
                    resolverNReinas(columna + 1);
                    tablero[i][columna] = 0; // Retroceder y deshacer la colocación
                }
            }
        }
    }

    /**
     * Metodo publico para que en las clases externas no tengan que indicar siempre
     * en que columna comenzar a resolver el problema (que siempre es 0), este
     * metodo llama al metodo recursivo con la columna 0 que realmente resuelve el
     * problema
     */
    public void resolverNReinas() {
        resolverNReinas(0);
    }

    /**
     * Devuelve el numero de soluciones encontradas
     * 
     * @return numero de soluciones
     */
    public int getContadorSoluciones() {
        return contadorSoluciones;
    }

    /**
     * Devuelve verdadero si se encontro al menos una solucion, falso en otro caso
     * 
     * @return verdadero si se encontro solucion, falso en otro caso
     */
    public boolean getSolucionEncontrada() {
        return solucionEncontrada;
    }

    /**
     * @brief Imprime un tablero de N reinas con formato de tablero de ajedrez.
     * 
     * Imprime una 'R' en las celdas que contienen una reina (valor 1) y un espacio en las vacías (valor 0).
     * Las celdas están separadas visualmente para facilitar la lectura.
     */
    public void imprimirTablero() {

        // Construir la línea divisoria
        String linea = "+";
        for (int i = 0; i < N; i++) {
            linea += "---+";
        }

        for (int i = 0; i < N; i++) {
            System.out.println(linea); // Línea horizontal superior

            for (int j = 0; j < N; j++) {
                System.out.print("| ");
                // Imprimir 'R' si hay reina, espacio en blanco si no
                System.out.print(tablero[i][j] == 1 ? "R" : " ");
                System.out.print(" ");
            }
            System.out.println("|"); // Cierre de fila
        }

        System.out.println(linea); // Última línea horizontal
    }

}
