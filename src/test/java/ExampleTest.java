import org.example.Example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ExampleTest {
    private Example example;

    @BeforeEach
    public void init() {
        this.example = new Example();
    }

    @Test
    public void testSuma() {
        //Given: elementos que tiene para hacer las pruebas
        int a = 5;
        int b = 10;
        //When operacion a ejecutar
        int result = example.suma(a, b);
        assertNotNull(result);
        assertEquals(15, result);

    }
    // 2. Método que lanza una excepción si el argumento es negativo-------------------------------------------------------------------------
    @Test
    public void testExceptionNumero() {
        int number = 10;
        boolean result = example.checkPositivo(number);
//      Validar si es positivo
        assertEquals(true, result);
    }
    @Test
    public void testException() {
        int number = -10;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> example.checkPositivo(number));
        String actual = exception.getMessage();
        String esperado = "El número no puede ser negativo";

        // Validar exception
        assertEquals(esperado, actual);
    }

    // 3. Método para contar el número de letras 'a' en una cadena -------------------------------------------------------------------------------
    @Test
    public void testCountChar(){
        assertAll(
                () -> assertEquals(0, example.contarLetrasA("Pedro")),
                () -> assertEquals(3, example.contarLetrasA("Michael alexis Chacon"))
        );
    }

    // 4. Método que retorna un valor booleano si la lista contiene el elemento------------------------------------------------------------------
    @Test
    public void testContieneElemento(){
        List<String> lista = Arrays.asList("Maritza", "Duvan", "Fabian", "Briand", "Miguel");
        assertAll(
                () -> assertEquals(true, example.contieneElemento(lista, "Maritza")),
                () -> assertEquals(false, example.contieneElemento(lista, "Alexis"))
        );
    }

    // 5. Método para revertir una cadena -------------------------------------------------------------------------------------------------------
    @Test
    public void testRevertirCadena(){
        assertAll(
                () -> assertEquals("sixelA", example.revertirCadena("Alexis"))
        );
    }

    // 6. Método que calcula el factorial de un número
    @Test
    public void testFactorial(){
        assertAll(
                () -> assertEquals(120, example.factorial(5)),
                () -> assertEquals(6, example.factorial(3))
        );
    }

    @Test
    public void testFactorialException(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> example.factorial(-1));
        String actual = exception.getMessage();
        String esperado = "Factorial no definido para números negativos";
        assertEquals(esperado, actual);
    }

    // 7. Método para verificar si un número es primo --------------------------------------------------------------------------------------
    @Test
    public void testPrimo(){
        assertAll(
                () -> assertEquals(true, example.esPrimo(7)),
                () -> assertEquals(false, example.esPrimo(8))
        );
    }

    // 8. Método que simula un retraso y retorna un mensaje ---------------------------------------------------------------------------------
    @Test
    public void testMensajeConRetraso() throws InterruptedException {
        assertAll(
                () -> assertTimeout(Duration.ofMillis(5050), () -> example.mensajeConRetraso()),
                () -> assertEquals("Listo después de retraso", example.mensajeConRetraso())
        );
    }

    // 9. Método para convertir una lista de enteros a lista de strings---------------------------------------------------------------------------
    @Test
    public void testConvertirAString(){
        List<Integer> enteros = Arrays.asList(1, 2, 3, 4, 5);
        List<String> string = Arrays.asList("1", "2", "3", "4", "5");
        assertArrayEquals(string.toArray(new String[string.size()]), example.convertirAString(enteros).toArray(new String[enteros.size()]));
    }

    // 10. Método que calcula la media de una lista de enteros -----------------------------------------------------------------------------------
    @Test
    public void testCalcularMedia(){
        List<Integer> enteros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        assertEquals(5.5, example.calcularMedia(enteros));
    }

    // 11. Método para convertir una lista de enteros a lista de strings --------------------------------------------------------------------------
    @Test
    public void testConvertirListaAString(){
        List<String> string = Arrays.asList("1", "2", "3", "4", "5");
        assertEquals("1,2,3,4,5", example.convertirListaAString(string));
    }

}
