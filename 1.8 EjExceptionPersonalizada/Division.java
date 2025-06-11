/**
 * @file Division.java
 * @brief Clase que realiza la operación de división con validación para evitar división por cero.
 * @author Salvador Gonalez Arerllano
 */

/**
 * @class Division
 * @brief Clase que representa una división y maneja posibles excepciones.
 */
public class Division {
    private double dividendo, divisor;

    /**
     * @brief Constructor de la clase.
     * @param dividendo de la división.
     * @param divisor de la división.
     */
    public Division(double dividendo, double divisor){
        this.dividendo = dividendo;
        this.divisor = divisor;
    }

    /**
     * @brief Obtiene el valor del dividendo.
     * @return dividendo.
     */
    public double getDividendo () {
        return dividendo;
    }

    /**
     * @brief Obtiene el valor del divisor.
     * @return divisor.
     */
    public double getDivisor () {
        return divisor;
    }

    /**
     * @brief Establece el valor del dividendo.
     * @param dividendo
     */
    public void setDividendo(double dividendo) {
        this.dividendo = dividendo;
    }

    /**
     * @brief Establece el valor del divisor.
     * @param divisor
     */
    public void setDivisor(double divisor) {
        this.divisor = divisor;
    }

    /**
     * @brief Realiza la división y verifica que el denominador no sea cero.
     * @exception myException Si el divisor es cero, lanza esta excepción.
     * @return Resultado de la división.
     */
    public double dividir () throws myException {
        if (divisor != 0) {
            return dividendo / divisor;
        } else {
            throw new myException("División por cero");
        }
    }
}
