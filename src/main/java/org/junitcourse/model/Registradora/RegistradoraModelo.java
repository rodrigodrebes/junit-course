package org.junitcourse.model.Registradora;

public class RegistradoraModelo {

    public static Registradora.RegistradoraBuilder construirCenario(){
        return Registradora.builder()
                .vendedor(new Vendedor(1, "Luiz Carlos"))
                .cliente(new Cliente("Fernando Barros"));
    }
}
