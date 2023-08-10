import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junitcourse.model.Registradora.BancoDeDados;
import org.junitcourse.model.Registradora.Compra;
import org.junitcourse.model.Registradora.Item;
import org.junitcourse.model.Registradora.RegistradoraModelo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class RegistradoraTest {

    @Test
    public void deveRegistrarAVendaNoBancoDeDados(){

        // Arrange - > Entrada
        var pastelDeCarne = Item.builder().nome("Pastel de Carne").valor(new BigDecimal("7.00")).build();
        var pastelDeFrango= Item.builder().nome("Pastel de Frango").valor(new BigDecimal("6.00")).build();

        List<Item> listaDeItens = new ArrayList<>();
        listaDeItens.add(pastelDeCarne);
        listaDeItens.add(pastelDeFrango);

        var compra = Compra.builder().itens(listaDeItens).build();

        var registradora = RegistradoraModelo.construirCenario()
                .compra(compra)
                .valorRecebido(new BigDecimal("13.50"))
                .build();


        // Act - > Ação

        registradora.efetivarVenda();

        // Assert -> Resultado

        Assertions.assertEquals(1, BancoDeDados.vendas.size());
        Assertions.assertEquals(new BigDecimal("13.00"), BancoDeDados.vendas.get(0).getTotalCompra());
        Assertions.assertEquals(new BigDecimal("00.50"), BancoDeDados.vendas.get(0).getTroco());
        Assertions.assertEquals("Luiz Carlos", BancoDeDados.vendas.get(0).getVendedor().getNome());
        Assertions.assertEquals("Fernando Barros", BancoDeDados.vendas.get(0).getCliente().getNome());
    }
}
