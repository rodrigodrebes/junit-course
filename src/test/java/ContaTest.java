import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junitcourse.model.Conta;

public class ContaTest {

    // annotation @Test, nomes dos métodos devem ser precisos
    @Test
    @DisplayName("Deve Depositar somente com Conta Ativa")
    public void deveDepositarComContaAtiva(){

        Conta conta = new Conta();

        conta.ativar();

        conta.depositar(100);

        Assertions.assertEquals(100,conta.getSaldo());
    }
}
