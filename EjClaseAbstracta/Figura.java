package EjClaseAbstracta;

/**
 * Clase abstracta Figura, define los métodos que deben ser implementados por
 * las clases derivadas
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public abstract class Figura {

    /**
     * Calcula el area de la figura
     * 
     * @return area
     */
    public abstract double calcularArea();

    /**
     * Calcula el perimetro de la figura
     * 
     * @return perimetro
     */
    public abstract double calcularPerimetro();

    /**
     * Devuelve la información de la figura en un String
     */
    public abstract String toString();
}
