import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junitcourse.model.Calculadora.Calculadora;

public class CalculadoraTest {

    private Calculadora calculadora = new Calculadora();

    @Test
    void deveSomar(){
        int resultado = calculadora.somar(1,2);
        Assertions.assertEquals(3, resultado);
    }

    @Test
    void deveSubtrair(){
        int resultado = calculadora.subtrair(2,2);
        Assertions.assertEquals(0, resultado);
    }

    @Test
    @DisplayName("Deve retornar Erro ao tentar dividir por Zero")
    void deveRetornarErroAoDividirPorZero(){
        var erro = Assertions.assertThrows(ArithmeticException.class, () -> calculadora.dividir(10,0));

        Assertions.assertEquals("Não pode dividir por zero", erro.getMessage());
    }
}
