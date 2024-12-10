package Backtrack;

/**
 * Clase Principal, crea objetos de las clases RecorridoCAballo y Nreinas para
 * verificar su correcto funcionamiento
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class Principal {
    public static void main(String[] args) {
        System.out.println("Recorrido del caballo");
        try {
            RecorridoCaballo caballo = new RecorridoCaballo(0, 0,8);
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
    }
}
