/**
 * @brief Clase Calculadora que realiza operaciones de suma con sobrecarga de métodos.
 * 
 * La clase Calculadora permite realizar sumas utilizando diferentes combinaciones de parámetros
 * mediante la sobrecarga de métodos.
 */
public class Calculadora {

    /**
     * Suma dos números enteros.
     * 
     * @param a El primer número entero.
     * @param b El segundo número entero.
     * @return La suma de los dos números enteros.
     */
    public int sumar(int a, int b) {
        return a + b;
    }

    /**
     * Suma tres números enteros.
     * 
     * @param a El primer número entero.
     * @param b El segundo número entero.
     * @param c El tercer número entero.
     * @return La suma de los tres números enteros.
     */
    public int sumar(int a, int b, int c) {
        return a + b + c;
    }

    /**
     * Suma dos números en punto flotante.
     * 
     * @param a El primer número en punto flotante.
     * @param b El segundo número en punto flotante.
     * @return La suma de los dos números en punto flotante.
     */
    public double sumar(double a, double b) {
        return a + b;
    }

    /**
     * Suma un número entero y un número en punto flotante.
     * 
     * @param a El número entero.
     * @param b El número en punto flotante.
     * @return La suma del número entero y el número en punto flotante.
     */
    public double sumar(int a, double b) {
        return a + b;
    }
}