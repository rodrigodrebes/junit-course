import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junitcourse.model.Conta;

public class ContaTest {

    // annotation @Test, nomes dos métodos devem ser precisos

    @Test
    @DisplayName("Deve Depositar Somente com Conta Ativa")
    public void deveDepositarComContaAtiva(){

        Conta conta = new Conta();

        conta.ativar();

        conta.depositar(100);

        Assertions.assertEquals(100,conta.getSaldo());
    }

    @Test
    @DisplayName("Não Deve Depositar com Conta Inativa")
    public void naoDeveDepositarComContaInativa(){

        Conta conta = new Conta();

        conta.inativar();

        conta.depositar(100);

        Assertions.assertEquals(0,conta.getSaldo());
    }

    @Test
    @DisplayName("Deve Sacar com Conta Ativa e Saldo Maior que o Valor do Saque")
    public void devesacarComContaAtivaESaldoMaiorQueValorDoSaque(){

        Conta conta = new Conta();

        conta.ativar();

        conta.depositar(100);

        conta.sacar(70);

        Assertions.assertEquals(30,conta.getSaldo());
    }

    @Test
    @DisplayName("Não Deve Sacar com Conta Inativa")
    public void naodevesacarComContaInativa(){

        Conta conta = new Conta();

        conta.ativar();

        conta.depositar(100);

        conta.inativar();

        conta.sacar(70);

        Assertions.assertEquals(100,conta.getSaldo());
    }

    @Test
    @DisplayName("Não Deve Sacar com Conta Ativa e Saldo Menor que o Valor do Saque")
    public void naodevesacarComContaAtivaESaldoMenorQueValorDoSaque(){

        Conta conta = new Conta();

        conta.ativar();

        conta.depositar(100);

        conta.sacar(120);

        Assertions.assertEquals(100,conta.getSaldo());
    }

}
