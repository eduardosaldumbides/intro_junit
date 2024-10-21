package calculadora;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Classe para teste da calculadora")
public class CalculadoraTest {
    
    private Calculadora calc;
    
    @BeforeEach
    public void inicializa() {
        calc = new Calculadora();
    }
    
    @DisplayName("Testa a soma de dois números")
    @Test
    public void testSomaDoisNumeros() {
        int soma = calc.soma(4, 5);
        Assertions.assertEquals(9, soma);    
    }
    
    @DisplayName("Testa a subtração de dois números")
    @Test
    public void testSubtracaoDoisNumeros() {
        int subtracao = calc.subtracao(10, 4);
        assertEquals(6, subtracao);
    }
    
    @DisplayName("Testa a multiplicação de dois números")
    @Test
    public void testMultiplicacaoDoisNumeros() {
        int multiplicacao = calc.multiplicacao(3, 4);
        assertEquals(12, multiplicacao);
    }

    @DisplayName("Testa a divisão de dois números")
    @Test
    public void testDivisaoDoisNumeros() {
        int divisao = calc.divisao(8, 4);
        assertEquals(2, divisao);
    }
    
    @DisplayName("Testa a divisão por zero usando try-catch")
    @Test
    public void testDivisaoPorZero() {
        try {
            calc.divisao(8, 0);
            fail("Exceção não lançada");
        } catch (ArithmeticException e) {
            assertEquals("/ by zero", e.getMessage());
        }    
    }
    
    @DisplayName("Testa a divisão por zero com assertThrows")
    @Test
    public void testDivisaoPorZeroComAssertThrows() {
        assertThrows(ArithmeticException.class,
                () -> calc.divisao(8, 0));
    }

    @DisplayName("Testa o método somatoria")
    @Test
    public void testSomatoria() {
        int resultado = calc.somatoria(5);
        assertEquals(15, resultado); // Somatório de 0 + 1 + 2 + 3 + 4 + 5 = 15
    }

    @DisplayName("Testa se o número é positivo")
    @Test
    public void testEhPositivo() {
        assertTrue(calc.ehPositivo(10));
        assertTrue(!calc.ehPositivo(-5));
    }
    
    @DisplayName("Testa o método compara")
    @Test
    public void testCompara() {
        assertEquals(0, calc.compara(5, 5));  // a == b
        assertEquals(1, calc.compara(10, 5)); // a > b
        assertEquals(-1, calc.compara(3, 7)); // a < b
    }
}
