/**
 * Clase que representa una Esfera a partir del radio
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class Esfera {
    private double radio;

    /**
     * Constructor de la clase para inicializar el radio a 0
     */
    public Esfera() {
        this.radio = 0.0;
    }

    /**
     * Constructor de la clase para inicializar el radio
     * @param radio el valor del radio
     */
    public Esfera(double radio) {
        this.radio = radio;
    }

    /**
     * Funcion para devolver el valor del radio
     * @return el valor del radio
     */
    public double getRadio() {
        return radio;
    }

    /**
     * Funcion para asignar un valor al radio
     * @param radio valor del radio
     */
    public void setRadio(double radio) {
        this.radio = radio;
    }

    /**
     * Funcion para calcular el radio de la esfera
     * @return superficie de la esfera
     */
    public double superficie() {
        return 4 * Math.PI * Math.pow(radio, 2);
    }

    /**
     * Funcion que devuelve la informacion de la esfera en un String
     * @return Informacion de la esfera en un String
     */
    public String toString() {
        return "Radio = " + radio;
    }
}
