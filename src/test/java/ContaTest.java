import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junitcourse.model.Conta;

public class ContaTest {

    private Conta conta;
    @BeforeEach
    public void inicializarConta(){
        conta = new Conta();
        conta.ativar();
    }

    // annotation @Test, nomes dos métodos devem ser precisos

    @Test
    @DisplayName("Deve Depositar Somente com Conta Ativa")
    public void deveDepositarComContaAtiva(){

        conta.depositar(100);

        Assertions.assertEquals(100,conta.getSaldo());
    }

    @Test
    @DisplayName("Não Deve Depositar com Conta Inativa")
    public void naoDeveDepositarComContaInativa(){

        conta.depositar(100);

        Assertions.assertEquals(0,conta.getSaldo());
    }

    @Test
    @DisplayName("Deve Sacar com Conta Ativa e Saldo Maior que o Valor do Saque")
    public void devesacarComContaAtivaESaldoMaiorQueValorDoSaque(){

        conta.depositar(100);

        conta.sacar(70);

        Assertions.assertEquals(30,conta.getSaldo());
    }

    @Test
    @DisplayName("Não Deve Sacar com Conta Inativa")
    public void naodevesacarComContaInativa(){

        conta.depositar(100);

        conta.inativar();

        conta.sacar(70);

        Assertions.assertEquals(100,conta.getSaldo());
    }

    @Test
    @DisplayName("Não Deve Sacar com Conta Ativa e Saldo Menor que o Valor do Saque")
    public void naodevesacarComContaAtivaESaldoMenorQueValorDoSaque(){

        conta.depositar(100);

        conta.sacar(120);

        Assertions.assertEquals(100,conta.getSaldo());
    }

}
