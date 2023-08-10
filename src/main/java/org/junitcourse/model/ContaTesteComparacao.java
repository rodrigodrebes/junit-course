package org.junitcourse.model;

public class ContaTesteComparacao {

    public static void main(String[] args) {

        // Depositar com Conta Ativa

        Conta conta = new Conta();

        conta.ativar();

        conta.depositar(100);

        System.out.println("Deve depositar com Conta Ativa");
        System.out.println(conta.getSaldo());
        if(conta.getSaldo() == 100){
            System.out.println("Teste funcionou!");

        }else{
            System.out.println("Teste falhou!");
        }

        // Depositar com Conta Inativa

        conta =new Conta();

        conta.inativar();

        System.out.println("\n\nNão Deve depositar com Conta Intiva");
        conta.depositar(100);

        System.out.println(conta.getSaldo());

        if(conta.getSaldo() == 100){
            System.out.println("Teste falhou!");

        }else{
            System.out.println("Teste funcionou!");
        }
    }

}
