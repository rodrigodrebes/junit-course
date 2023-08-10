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

    public void depositar(double valor) {
        if (this.ativo) {
            this.saldo += valor;
        } else{
            System.out.println("Conta inativa!");
        }
    }

    public void sacar(double valor) {
        if ((this.ativo) && (this.saldo >= valor)) {
            this.saldo -= valor;
        } else{
            System.out.println("Conta inativa!");
        }
    }


}
