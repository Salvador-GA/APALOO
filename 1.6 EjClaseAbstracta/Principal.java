public class Principal {

    public static void main(String[] args) {
        Cuadrado c1 = new Cuadrado(2.0);
        Rectangulo r1 = new Rectangulo(2.0, 3.0);
        Circulo circ1 = new Circulo(2.5);

        System.out.println("-------------- Cuadrado --------------");
        System.out.println(c1.toString());
        System.out.println("Area = " + c1.calcularArea());
        System.out.println("Perimetro = " + c1.calcularPerimetro());
        System.out.println();

        System.out.println("-------------- Rectangulo --------------");
        System.out.println(r1.toString());
        System.out.println("Area = " + r1.calcularArea());
        System.out.println("Perimetro = " + r1.calcularPerimetro());
        System.out.println();

        System.out.println("-------------- Circulo --------------");
        System.out.println(circ1.toString());
        System.out.println("Area = " + circ1.calcularArea());
        System.out.println("Perimetro = " + circ1.calcularPerimetro());
        System.out.println();
    }

}
