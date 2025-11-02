public class Funciones {

    /**
     * Suma de dos enteros
     * 
     * @param a primer valor
     * @param b segundo valor
     * @return a+b
     */
    public static int sumar(int a, int b) { 
        return a + b; 
    }

    /**
     * Resta de dos enteros
     * 
     * @param a primer valor
     * @param b segundo valor
     * @return a-b
     */
    public static int restar(int a, int b) { 
        return a - b; 
    }

    /**
     * Multiplicacion de dos enteros
     * 
     * @param a primer valor
     * @param b segundo valor
     * @return a*b
     */
    public static int multiplicar(int a, int b) { 
        return a * b; 
    }

    /**
     * Divide a entre b como double.
     * 
     * @param a dividendo
     * @param b divisor
     * @return a/b
     * @throws IllegalArgumentException si b == 0
     */
    public static double dividir(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("División entre cero");
        }
        return (double) a / (double) b;
    }

    /**
     * Factorial de n. 
     * @param n 
     * @return n!
     * @throws IllegalArgumentException si n<0 o si hay riesgo de overflow en long.
     */
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n debe ser >= 0");
        } else if (n > 20) {
            throw new IllegalArgumentException("n demasiado grande (overflow de long)");
        }
        long res = 1L;
        for (int i = 2; i <= n; i++) {
            res *= i;
        }
        return res;
    }

    /**
     * Máximo común divisor por Euclides (siempre no negativo).
     * 
     * @param a primer valor
     * @param b segundo valor
     * @return maximo comun divisor de a y b
     */
    public static int mcd(int a, int b) {
        a = Math.abs(a); b = Math.abs(b);
        if (a == 0 && b == 0) return 0;
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    /**
     * Media aritmética de un arreglo.
     * 
     * @param valores arreglo de valores
     * @return media aritmética
     * @throws IllegalArgumentException si null o vacío
     */
    public static double media(double[] valores) {
        if (valores == null || valores.length == 0) {
            throw new IllegalArgumentException("Arreglo null o vacío");
        }
        double s = 0;
        for (double v : valores) {
            s += v;
        }
        return s / valores.length;
    }

    /**
     * Determina si un numero es primo
     * 
     * @param n
     * @return verdadero si n es primo, falso en otro caso
     */
    public static boolean esPrimo(int n) {
        if (n == 2 || n == 3) {
            return true;
        }
        if (n <= 1 || n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        for (int i = 5; (long) i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }

}
