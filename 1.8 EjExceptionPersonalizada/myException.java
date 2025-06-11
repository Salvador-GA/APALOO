/**
 * @file myException.java
 * @brief Clase que define una excepción personalizada para errores de división.
 * @author Salvador Gonalez Arerllano
 */

/**
 * @class myException
 * @brief Excepción personalizada para manejar división por cero.
 */
public class myException extends Exception {
    /**
     * @brief Constructor de la excepción.
     * @param mensaje Mensaje de error a mostrar.
     */
    public myException(String mensaje){
        super(mensaje);
    }
}
