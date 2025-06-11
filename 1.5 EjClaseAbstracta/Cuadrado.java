/**
 * Clase Cuadrado, deriva de la clase Rectangulo sobreescribe los metodos
 * setBase, setAltura y toString
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class Cuadrado extends Rectangulo {

    /**
     * Constructor de la clase para inicializar el lado
     * 
     * @param lado lado del cuadrado
     */
    public Cuadrado(double lado) {
        super(lado, lado);
    }

    /**
     * Constructor de la clase para inicializar el lado a 1
     */
    public Cuadrado() {
        super();
    }

    /**
     * Asigna el valor del lado
     * 
     * @param lado del cuadrado
     */
    @Override
    public void setBase(double lado) {
        setBase(lado);
        setAltura(lado);
    }

    /**
     * Asigna el valor del lado
     * 
     * @param lado del cuadrado
     */
    @Override
    public void setAltura(double lado) {
        setBase(lado);
        setAltura(lado);
    }

    @Override
    public String toString() {
        return "Cuadrado de lado: " + getBase();
    }

}
