package Backtrack;

/**
 * Clase RecorridoCaballo, resuelve el problema del recorrido del caballo para
 * un tablero de NxN a partir de la posicion indicada en el constructor
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.1
 */
public class RecorridoCaballo {
    private int N;
    private int[][] tablero;
    private boolean exito;
    private int[][] SALTO = { { 2, 1 }, { 1, 2 }, { -1, 2 }, { -2, 1 },
                              { -2, -1 }, { -1, -2 }, { 1, -2 }, { 2, -1 } };
    private int x0, y0;

    /**
     * Constructor de la clase, inicializa los atributos si la posicion es valida,
     * si no es asi arroja una excepcion
     * 
     * @param x coordenada inicial x
     * @param y coordenada inicial y
     * @throws Exception Coordenadas fuera de rango
     */
    public RecorridoCaballo(int x, int y, int N) throws Exception { // constructor
        this.N=N;
        tablero = new int[N][N];
        if ((x < 0) || (x >= N) || (y < 0) || (y >= N)) {
            throw new Exception("Coordenadas fuera de rango");
        }
        x0 = x;
        y0 = y;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tablero[i][j] = 0;
            }
        }
        tablero[x0][y0] = 1;
        exito = false;
    }

    /**
     * metodo que se llama para resolver el problema del recorido
     * 
     * @return verdadero si se encontro una solucion, falso en otro caso
     */
    public boolean resolverProblema() {
        saltoCaballo(x0, y0, 2);
        return exito;
    }

    /**
     * metodo que implementa la tecnica backtrack para buscar una solucion al
     * recorrido del caballo
     * 
     * @param x          coordenada x actual del caballo
     * @param y          coordenada y actual del caballo
     * @param movimiento numero de movimiento que se quiere hacer
     */
    private void saltoCaballo(int x, int y, int movimiento) {
        int nx, ny; // coordenadas del siguiente movimiento
        int k;
        k = 0; // inicializa el conjunto de posibles movimientos
        do {
            nx = x + SALTO[k][0]; // probamos las coordenadas del
            ny = y + SALTO[k][1]; // primer movimiento posible
            k++;
            // determina si nuevas coordenadas son aceptables
            if ((nx >= 0) && (nx < N) && (ny >= 0) && (ny < N) && (tablero[nx][ny] == 0)) {
                tablero[nx][ny] = movimiento; // anota movimiento
                if (movimiento < N * N) {
                    saltoCaballo(nx, ny, movimiento + 1);
                    if (!exito) { // si no se alcanzó la solución
                        tablero[nx][ny] = 0; // se borra anotación
                    }
                } else {
                    exito = true; // tablero cubierto
                }
            }
        } while ((k < 8) && !exito);
    }

    /**
     * imprime en pantalla los saltos del caballo
     */
    public void escribirTablero() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (tablero[i][j] < 10) {
                    System.out.print("0" + tablero[i][j] + " ");
                } else {
                    System.out.print(tablero[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

}
