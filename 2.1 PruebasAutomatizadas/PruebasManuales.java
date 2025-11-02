public class PruebasManuales {
    public static void main(String[] args) {
        // Estos prints ilustran por qué las pruebas manuales son frágiles:
        // - No fallan automáticamente
        // - No hay reporte/contador de tests
        // - Es fácil olvidar casos o no validar errores

        System.out.println("=== PRUEBAS MANUALES (NO RECOMENDADO EN PRODUCCIÓN) ===");

        int s = Funciones.sumar(1, 2);
        System.out.println("sumar(1,2) -> " + s + " (esperado 3)");

        double div = Funciones.dividir(5, 2);
        System.out.println("dividir(5,2) -> " + div + " (esperado 2.5)");

        try {
            Funciones.dividir(10, 0);
            System.out.println("dividir(10,0) -> NO lanzó excepción (MAL, debería lanzar)");
        } catch (IllegalArgumentException ex) {
            System.out.println("dividir(10,0) -> lanzó excepción OK: " + ex.getMessage());
        }

        long f = Funciones.factorial(5);
        System.out.println("factorial(5) -> " + f + " (esperado 120)");

        int g = Funciones.mcd(54, 24);
        System.out.println("mcd(54,24) -> " + g + " (esperado 6)");

        double m = Funciones.media(new double[]{1,2,3});
        System.out.println("media([1,2,3]) -> " + m + " (esperado 2.0)");

        boolean p = Funciones.esPrimo(17);
        System.out.println("esPrimo(17) -> " + p + " (esperado true)");

        // EJEMPLO DEL PROBLEMA: si te equivocas en el "esperado" o no comparas, nadie te avisa:
        int erroneo = Funciones.sumar(1000, -1);
        // Imprimimos pero NO verificamos: si esperábamos 1000 y es 999, esto pasa "desapercibido".
        System.out.println("sumar(1000,-1) -> " + erroneo + " (¿esperado 1000 o 999?)");

        System.out.println("=== FIN DE PRUEBAS MANUALES ===");
    }
}
