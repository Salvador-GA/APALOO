package Backtrack;

/**
 * Clase Principal, hace uso de las clases RecorridoCAballo, Nreinas y Sudoku
 * para verificar su correcto funcionamiento
 * 
 * @author Salvador Gonzalez Arellano
 * @version 2.0
 */
public class Principal {
    public static void main(String[] args) {
        System.out.println("\nCadena binaria");
        try {
            BacktrackCadena generador = new BacktrackCadena(3);
            generador.generar();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nRecorrido del caballo");
        try {
            RecorridoCaballo caballo = new RecorridoCaballo(0, 0, 8);
            caballo.resolverProblema();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("\nProblema de las N reinas");
        try {
            Nreinas reinas = new Nreinas(8);
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
        Sudoku s1;
        try {
            s1 = new Sudoku(tablero);
            s1.resolver();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
