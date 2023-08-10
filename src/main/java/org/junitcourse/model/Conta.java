package org.junitcourse.model;

public class Conta {

    private double saldo;
    private boolean ativo;

    public double getSaldo() {
        return saldo;
    }
    public void ativar(){
        this.ativo=true;
    }
    public void inativar(){
        this.ativo=false;
    }

    public boolean depositar(double valor) {
        if (this.ativo) {
            this.saldo += valor;
            return true;
        } else{
            System.out.println("Conta inativa!");
            return false;
        }
    }

    public boolean sacar(double valor) {
        if ((this.ativo) && (this.saldo >= valor)) {
            this.saldo -= valor;
            return true;
        } else{
            System.out.println("Conta inativa ou saldo menor que o valor do saque!");
            return false;
        }
    }


}
