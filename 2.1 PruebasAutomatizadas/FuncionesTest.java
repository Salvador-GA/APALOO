import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @file FuncionesTest.java
 * @brief Pruebas automatizadas para la clase Funciones usando JUnit 5 (Jupiter).
 *
 * @details
 * Esta suite valida operaciones matemáticas típicas (suma, división, factorial,
 * máximo común divisor, media y primalidad). Se ejemplifica el uso de:
 *  - @Test para casos unitarios puntuales.
 *  - @ParameterizedTest + @CsvSource para ejecutar el mismo test con múltiples entradas.
 *  - Assertions.assertThrows para verificar que se lancen excepciones esperadas.
 *
 * Convenciones:
 *  - Los nombres de prueba y @DisplayName buscan ser legibles en el reporte.
 *  - La tolerancia en aserciones de double se maneja con un delta (p.ej. 1e-9).
 */
public class FuncionesTest {

    /**
     * @test
     * @brief Verifica sumas correctas para distintos pares (a, b).
     * @details
     * Usa @ParameterizedTest para ejecutar el mismo cuerpo de prueba con múltiples
     * combinaciones. @CsvSource provee filas "a, b, esperado".
     * Se evalúa que Funciones.sumar(a, b) == esperado.
     */
    @ParameterizedTest(name = "sumar({0}, {1}) = {2}")
    @CsvSource({
        "1, 2, 3",
        "-1, 5, 4",
        "0, 0, 0",
        "1000, -1, 999"
    })
    @DisplayName("Sumas básicas")
    void testSumar(int a, int b, int esperado) {
        Assertions.assertEquals(esperado, Funciones.sumar(a, b));
    }

    /**
     * @test
     * @brief Comprueba división en caso normal (sin excepción).
     * @details
     * Verifica que 5/2 produzca 2.5 con tolerancia de 1e-9. Si la implementación
     * hace división entera o pierde precisión, esta aserción fallará.
     */
    @Test
    @DisplayName("Dividir: caso normal")
    void testDividirOk() {
        double r = Funciones.dividir(5, 2);
        Assertions.assertEquals(2.5, r, 1e-9);
    }

    /**
     * @test
     * @brief Verifica que dividir entre cero lanza IllegalArgumentException.
     * @details
     * Se espera que Funciones.dividir(10, 0) lance la excepción documentada.
     * Este test falla si:
     *  - No se lanza excepción, o
     *  - Se lanza un tipo distinto al esperado.
     */
    @Test
    @DisplayName("Dividir: división entre cero lanza excepción")
    void testDividirPorCero() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Funciones.dividir(10, 0));
    }

    /**
     * @test
     * @brief Valida factorial en valores pequeños conocidos.
     * @details
     * Se compara contra resultados cerrados: 0! = 1, 1! = 1, 5! = 120, 10! = 3628800.
     * Si la implementación no maneja casos base o el bucle, fallará.
     */
    @ParameterizedTest(name = "factorial({0}) = {1}")
    @CsvSource({
        "0, 1",
        "1, 1",
        "5, 120",
        "10, 3628800"
    })
    @DisplayName("Factorial: valores pequeños")
    void testFactorial(int n, long esperado) {
        Assertions.assertEquals(esperado, Funciones.factorial(n));
    }

    /**
     * @test
     * @brief Verifica que factorial para n negativo lance IllegalArgumentException.
     * @details
     * Este test asegura el manejo defensivo de entradas inválidas (n < 0).
     */
    @Test
    @DisplayName("Factorial: negativo lanza excepción")
    void testFactorialNegativo() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Funciones.factorial(-3));
    }

    /**
     * @test
     * @brief Valida el máximo común divisor (MCD) con el algoritmo de Euclides.
     * @details
     * Casos cubiertos:
     *  - Comunes (54,24) -> 6
     *  - Primos relativos (7,13) -> 1
     *  - Ambos ceros (0,0) -> 0 (convención elegida)
     *  - Con cero (0,5) -> 5
     *  - Valores negativos (-12,18) -> 6 (se asume uso de valor absoluto)
     */
    @ParameterizedTest(name = "mcd({0}, {1}) = {2}")
    @CsvSource({
        "54, 24, 6",
        "7, 13, 1",
        "0, 0, 0",
        "0, 5, 5",
        "-12, 18, 6"
    })
    @DisplayName("MCD (Euclides)")
    void testMcd(int a, int b, int esperado) {
        Assertions.assertEquals(esperado, Funciones.mcd(a, b));
    }

    /**
     * @test
     * @brief Prueba la media de un arreglo y los casos de error.
     * @details
     * - Caso normal: media([1,2,3]) = 2.0 con delta 1e-9.
     * - Errores esperados: arreglo vacío y null deben lanzar IllegalArgumentException.
     */
    @Test
    @DisplayName("Media: caso normal y errores")
    void testMedia() {
        Assertions.assertEquals(2.0, Funciones.media(new double[]{1,2,3}), 1e-9);
        Assertions.assertThrows(IllegalArgumentException.class, () -> Funciones.media(new double[]{}));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Funciones.media(null));
    }

    /**
     * @test
     * @brief Verifica primalidad para varios enteros.
     * @details
     * Casos cubren:
     *  - No primos: <=1 (por definición), pares >2, múltiplos de 3.
     *  - Primos típicos: 2, 3, 17, 97.
     * Si el test falla, revisar condiciones de borde y bucle hasta sqrt(n).
     */
    @ParameterizedTest(name = "esPrimo({0}) = {1}")
    @CsvSource({
        "-5, false",
        "0, false",
        "1, false",
        "2, true",
        "3, true",
        "4, false",
        "17, true",
        "21, false",
        "97, true"
    })
    @DisplayName("Primalidad")
    void testEsPrimo(int n, boolean esperado) {
        Assertions.assertEquals(esperado, Funciones.esPrimo(n));
    }
}
