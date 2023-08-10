package org.junitcourse.model.Calculadora;

public class Calculadora {

    public int somar(int x, int y){
        return x+y;
    }

    public int subtrair(int x, int y) {
        return (x-y);
    }

    public int dividir(int x, int y) {
        if(y ==0){
           throw new ArithmeticException("Não pode dividir por zero");
        }else{
            return (x/y);
        }
    }
}
