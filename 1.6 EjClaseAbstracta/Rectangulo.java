/**
 * Clase Rectangulo, deriva de la clase Figura e implementa sus metodos
 * abstractos
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class Rectangulo extends Figura {
    private double base, altura;

    /**
     * Constructor de la clase para inicializar la base y altura
     * 
     * @param base   del rectangulo
     * @param altura del rectangulo
     */
    public Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    /**
     * Constructor de la clase para inicializar base y altura a 1
     */
    public Rectangulo() {
        this.base = 1;
        this.altura = 1;
    }

    /**
     * Devuelve el valor de la base
     * 
     * @return base
     */
    public double getBase() {
        return base;
    }

    /**
     * Asigna el valor de la base
     * 
     * @param base del rectangulo
     */
    public void setBase(double base) {
        this.base = base;
    }

    /**
     * Devuelve el valor de la alura
     * 
     * @return altura
     */
    public double getAltura() {
        return altura;
    }

    /**
     * Asigna el valor de la altura
     * 
     * @param altura del rectangulo
     */
    public void setAltura(double altura) {
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return base * altura;
    }

    @Override
    public double calcularPerimetro() {
        return (2 * base) + (2 * altura);
    }

    @Override
    public String toString() {
        return "Rectangulo de base: " + base + " y altura: " + altura;
    }

}
