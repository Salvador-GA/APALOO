public class Principal {
    public static void main(String[] args) {
        Calculadora calc = new Calculadora();

        // Llamadas a los métodos sobrecargados
        System.out.println(calc.sumar(5, 10)); // Llama al primer método (int, int)
        System.out.println(calc.sumar(5, 10, 15)); // Llama al segundo método (int, int, int)
        System.out.println(calc.sumar(5.5, 10.5)); // Llama al tercer método (double, double)
        System.out.println(calc.sumar(5, 10.5)); // Llama al cuarto método (int, double)
    }
}