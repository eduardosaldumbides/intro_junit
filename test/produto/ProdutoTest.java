package produto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProdutoTest {

    Produto livro;

    @BeforeEach
    public void inicializa() {
        // Inicializa um objeto Produto antes de cada teste
        livro = new Produto("Introdução ao Teste de Software", 100.00);
    }

    @DisplayName("Testa a criação de um Produto")
    @Test
    public void testCriaProduto() {
        // Verifica se o produto foi criado com o nome e preço corretos
        Assertions.assertAll("livro",
            () -> assertEquals("Introdução ao Teste de Software", livro.getNome()),
            () -> assertTrue(100.00 == livro.getPreco())  // Verifica o preço
        );
    }

    @DisplayName("Testa se dois produtos com o mesmo nome não são o mesmo objeto")
    @Test
    public void testProdutosIguais() {
        // Cria outro produto com o mesmo nome, mas preço diferente
        Produto livro2 = new Produto("Introdução ao Teste de Software", 90.00);

        // Verifica se os dois objetos são diferentes (não têm a mesma referência)
        assertNotSame(livro, livro2);

        // Verifica se os dois produtos são considerados iguais com base no nome (método equals)
        assertTrue(livro.equals(livro2)); // Como equals é baseado no nome, espera-se que sejam iguais
    }

    @DisplayName("Testa assertions com Hamcrest Matcher")
    @Test
    public void assertionComHamcrestMatcher() {
        // Verifica se o preço do livro é 100.00 usando Hamcrest
        assertThat(livro.getPreco(), equalTo(100.00));

        // Verifica se o nome do livro não é nulo
        assertThat(livro.getNome(), notNullValue());

        // Verifica se o nome contém a palavra "Teste"
        assertThat(livro.getNome(), containsString("Teste"));

        // Verifica se o objeto é uma instância da classe Produto
        assertThat(livro, instanceOf(Produto.class));
    }

    @DisplayName("Testa a alteração do nome e preço do Produto")
    @Test
    public void testAlteraNomeEPreco() {
        // Altera o nome e o preço do produto
        livro.setNome("Engenharia de Software");
        livro.setPreco(150.00);

        // Verifica se as alterações foram realizadas corretamente
        assertEquals("Engenharia de Software", livro.getNome());
        assertEquals(150.00, livro.getPreco());
    }
}
