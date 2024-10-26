/**
 * Clase Principal, utiliza los metodos de la clase FuncionesRecursivas para
 * verificar su correcto funcionamiento
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class Principal {
    public static void main(String[] args) {
        int n = 15;
        try {
            System.out.println("La suma de los primeros " + n + " enteros es: " + FuncionesRecursivas.sumaNentero(n));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.print("La serie de fibonacci hasta " + n + " es:");
        for (int i = 0; i < n; i++) {
            try {
                System.out.print(" " + FuncionesRecursivas.fibonacci(i));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println();
        try {
            System.out.println(n + "! = " + FuncionesRecursivas.factorial(n));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.print("Alfabeto minuscula: ");
            FuncionesRecursivas.imrpimeAlfabeto('z');
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
    }
}
