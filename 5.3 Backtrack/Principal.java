package Backtrack;

/**
 * Clase Principal, hace uso de las clases RecorridoCAballo, Nreinas y Sudoku
 * para verificar su correcto funcionamiento
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.1
 */
public class Principal {
    public static void main(String[] args) {
        System.out.println("Recorrido del caballo");
        try {
            RecorridoCaballo caballo = new RecorridoCaballo(0, 0, 8);
            if (caballo.resolverProblema()) {
                caballo.escribirTablero();
            } else {
                System.out.println("No se puede resolver el problema");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("\nProblema de las N reinas");
        try {
            Nreinas reinas = new Nreinas(4);
            reinas.resolverNReinas();
            if (reinas.getSolucionEncontrada()) {
                System.out.println("Número de soluciones encontradas: " + reinas.getContadorSoluciones());
            } else {
                System.out.println("No se puede resolver el problema");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nProblema de Sudoku");
        int[][] tablero = {
                { 5, 3, 0, 0, 7, 0, 0, 0, 0 },
                { 6, 0, 0, 1, 9, 5, 0, 0, 0 },
                { 0, 9, 8, 0, 0, 0, 0, 6, 0 },
                { 8, 0, 0, 0, 6, 0, 0, 0, 3 },
                { 4, 0, 0, 8, 0, 3, 0, 0, 1 },
                { 7, 0, 0, 0, 2, 0, 0, 0, 6 },
                { 0, 6, 0, 0, 0, 0, 2, 8, 0 },
                { 0, 0, 0, 4, 1, 9, 0, 0, 5 },
                { 0, 0, 0, 0, 8, 0, 0, 7, 9 }
        };
        if (Sudoku.resolverSudoku(tablero)) {
            Sudoku.imprimirTablero(tablero);
        }
    }
}
