package org.junitcourse.model;

public class ManualTest {
    public static void main(String[] args) {


        // Depositar com Conta Ativa

        Conta conta = new Conta();

        conta.ativar();

        conta.depositar(100);

        System.out.println("Deve depositar com Conta Ativa");
        System.out.println(conta.getSaldo());

        // Depositar com Conta Inativa

        conta =new Conta();

        conta.inativar();

        System.out.println("Não Deve depositar com Conta Intiva");
        conta.depositar(100);

        System.out.println(conta.getSaldo());


    }
}