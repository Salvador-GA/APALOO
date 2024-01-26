package Recursividad;

/**
 * Clase Funciones recursivas, implementa los algoritmos recursivos:
 * sumaN
 * sumaNentero
 * fibonacci
 * factorial
 * imrpimeAlfabeto
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class FuncionesRecursivas {

    /**
     * Realiza la suma desde 1 hasta n de manera recursiva, no verifica si n es
     * positivo por lo que puede generar un ciclo de llamados infinitos con una n
     * negativa
     * 
     * @param n limite superior de la sumatoria
     * @return la suma desde 1 hasta n
     */
    public static int sumaN(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n + sumaN(n - 1);
        }
    }

    /**
     * Realiza la suma desde 1 hasta n de manera recursiva, verifica si n es
     * positivo, si no es asi arroja una excepcion
     * 
     * @param n limite superior de la sumatoria
     * @return la suma desde 1 hasta n
     * @throws Exception el numero debe ser positivo
     */
    public static int sumaNentero(int n) throws Exception {
        if (n >= 1) {
            if (n == 1) {
                return 1;
            } else {
                return n + sumaN(n - 1);
            }
        } else {
            throw new Exception("n debe ser entero positivo mayor o igual a 1");
        }
    }

    /**
     * Regresa el numero n de la secuencia de fibonacci, verifica n es positivo, si
     * no es asi arroja una excepcion
     * 
     * @param n posicion de la que se quiere obtener el numero de fibonacci
     * @return numero de fibonacci correspondiente a la posicion n
     * @throws Exception el numero debe ser positivo
     */
    public static int fibonacci(int n) throws Exception {
        if (n >= 0) {
            if (n == 0 || n == 1) {
                return n;
            } else {
                return fibonacci(n - 1) + fibonacci(n - 2);
            }
        } else {
            throw new Exception("n debe ser entero positivo mayor o igual a 0");
        }
    }

    /**
     * Regresa el factorial de n, verifica n es positivo, si no es asi arroja una
     * excepcion
     * 
     * @param n el entero del que se quiere saber su factorial
     * @return el factorial de n
     * @throws Exception el numero debe ser positivo
     */
    public static long factorial(int n) throws Exception {
        if (n >= 0) {
            if (n == 0 || n == 1) {
                return 1;
            } else {
                return n * factorial(n - 1);
            }
        } else {
            throw new Exception("n debe ser entero positivo mayor o igual a 0");
        }
    }

    /**
     * Imprime el alfabeto desde a, o desde A, hasta la letra indicada, verifica que
     * la letra se encuentre en el rango de las minusculas o mayusculas, si no es
     * asi arroja una excepcion
     * 
     * @param letra limite superior hasta donde se va a imprimir el alfabeto
     * @throws Exception el argumento debe ser una letra del alfabeto, minuscula o
     *                   mayuscula
     */
    public static void imrpimeAlfabeto(char letra) throws Exception {
        if (letra >= 65 && letra <= 90) {
            if (letra > 'A') {
                letraAnterior(letra);
            }
            System.out.print(letra + " ");
        } else if (letra >= 97 && letra <= 122) {
            if (letra > 'a') {
                letraAnterior(letra);
            }
            System.out.print(letra + " ");
        } else {
            throw new Exception("el argumento debe ser una letra del alfabeto, minuscula o mayuscula");
        }
    }

    /**
     * manda a llamar al metodo letraAnterior con el argumento letra -1
     * 
     * @param letra actual
     * @throws Exception el argumento debe ser una letra del alfabeto, minuscula o
     *                   mayuscula
     */
    private static void letraAnterior(char letra) throws Exception {
        imrpimeAlfabeto(--letra);
    }
}
