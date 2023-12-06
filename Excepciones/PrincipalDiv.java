
/**
 * Clase de ejemplo para manejar excepciones, se solicitan numeros al usuario 
 * hasta que la division se pueda realizar correctamente
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PrincipalDiv {

    /**
     * Devuelve unnumero real introducido por el usuario
     * 
     * @param msg mensaje que se mostrara al usuario al solicitar que ingrese un
     *            numero
     * @return numero real
     * @throws Exception Error al leer o convertir el numero ingresado por el
     *                   usuario
     */
    private static double leerDato(String msg) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double num;

        System.out.print(msg);
        try {
            String entrada = br.readLine();
            num = Double.parseDouble(entrada);
            return num;
        } catch (Exception e) {
            throw new Exception("Error al ingresar el dato");
        }
    }

    public static void main(String[] args) {
        double dividendo, divisor, resultado;
        boolean exito = false;

        do {
            try {
                dividendo = leerDato("Ingresa el dividendo: ");
                divisor = leerDato("Ingresa el divisor: ");
                resultado = Division.dividir(dividendo, divisor);
                System.out.println("El resultado es: " + resultado);
                exito = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (!exito);
    }
}
