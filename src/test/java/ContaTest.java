import org.junit.jupiter.api.*;
import org.junitcourse.model.Conta;

public class ContaTest {

    private Conta conta;
    private static double depositoInicial;
    private static double saqueValido;
    private static double saqueInvalido;

    private static double saldoZerado;

    @BeforeAll
    private static void definirValoresPadrao(){
        saldoZerado=0;
        depositoInicial = 100;
        saqueValido = 70;
        saqueInvalido = 120;
    }

    @BeforeEach
    private void inicializarConta(){
        conta = new Conta();
        conta.ativar();
    }

    // annotation @Test, nomes dos métodos devem ser precisos
    @Test
    @DisplayName("Deve Depositar Somente com Conta Ativa")
    public void deveDepositarComContaAtiva(){

        Assertions.assertTrue(conta.depositar(depositoInicial));

        Assertions.assertEquals(depositoInicial,conta.getSaldo());
    }

    @Test
    @DisplayName("Não Deve Depositar com Conta Inativa")
    public void naoDeveDepositarComContaInativa(){

        conta.inativar();

        Assertions.assertFalse(conta.depositar(depositoInicial));

        Assertions.assertEquals(saldoZerado,conta.getSaldo());
    }

    @Test
    @DisplayName("Deve Sacar com Conta Ativa e Saldo Maior que o Valor do Saque")
    public void devesacarComContaAtivaESaldoMaiorQueValorDoSaque(){

        Assertions.assertTrue(conta.depositar(depositoInicial));

        conta.sacar(saqueValido);

        Assertions.assertEquals(depositoInicial-saqueValido ,conta.getSaldo());
    }

    @Test
    @DisplayName("Não Deve Sacar com Conta Inativa")
    public void naodevesacarComContaInativa(){

        Assertions.assertTrue(conta.depositar(depositoInicial));

        conta.inativar();

        Assertions.assertFalse(conta.sacar(saqueValido));

        Assertions.assertEquals(depositoInicial,conta.getSaldo());
    }

    @Test
    @DisplayName("Não Deve Sacar com Conta Ativa e Saldo Menor que o Valor do Saque")
    public void naodevesacarComContaAtivaESaldoMenorQueValorDoSaque(){

        Assertions.assertTrue(conta.depositar(depositoInicial));

        Assertions.assertFalse(conta.sacar(saqueInvalido));

        Assertions.assertEquals(depositoInicial,conta.getSaldo());
    }

}
