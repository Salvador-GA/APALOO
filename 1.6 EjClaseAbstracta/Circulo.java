/**
 * Clase Circulo, deriva de la clase Figura e implementa sus metodos
 * abstractos
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class Circulo extends Figura {
    double radio;

    /**
     * Constructor de la clase para inicializar el radio
     * 
     * @param radio del circulo
     */
    public Circulo(double radio) {
        this.radio = radio;
    }

    /**
     * Constructor de la clase para inicializar el radio a 1
     */
    public Circulo() {
        this.radio = 1.0;
    }

    /**
     * Devuelve el valor del radio
     * 
     * @return radio
     */
    public double getRadio() {
        return radio;
    }

    /**
     * Asigna el valor del radio
     * 
     * @param radio del circulo
     */
    public void setRadio(double radio) {
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * Math.pow(radio, 2);
    }

    @Override
    public double calcularPerimetro() {
        return 2 * Math.PI * radio;
    }

    @Override
    public String toString() {
        return "Circulo de radio: " + radio;
    }

}
