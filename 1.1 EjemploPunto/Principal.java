public class Principal {
    /**
     * Clase principal que hace uso de la clase Punto
     * @param args no son requeridos
     */
    public static void main(String[] args) {
        Punto a1 = new Punto(1,2);
        System.out.println("Punto a1 ("+a1.getX()+", "+a1.getY()+")");
        a1.setY(7);
        System.out.println("Punto a1 ("+a1.getX()+", "+a1.getY()+")");
        Punto a2 = new Punto();
        System.out.println("Punto a2 ("+a2.getX()+", "+a2.getY()+")");
    }
}
