/**
 * Clase Division, implementa un metodo estatico para realizar una division de
 * dos numero reales
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class Division {

    /**
     * Devuelve la division de dos numeros reales
     * 
     * @param dividendo
     * @param divisor
     * @return resultado de la division
     * @throws ArithmeticException Si se intenta dividir por cero
     */
    public static double dividir(double dividendo, double divisor) throws ArithmeticException {
        double resultado;
        resultado = dividendo / divisor;
        if (resultado == Double.POSITIVE_INFINITY ||
                resultado == Double.NEGATIVE_INFINITY ||
                Double.isNaN(resultado)) {
            throw new ArithmeticException("No se puede dividir por 0");
        } else {
            return resultado;
        }
    }
}
