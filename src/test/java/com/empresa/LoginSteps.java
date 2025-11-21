package com.empresa;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginSteps {


//Simulacion de persona en pagina de login
    @Given("que estoy en la pagina de login")
    public void que_estoy_en_la_pagina_de_login() {
        System.out.println("--- [STEP] Abriendo navegador en Login ---");
    }

//Simulacion de persona ingresando datos para login
    @When("ingreso usuario {string} y clave {string}")
    public void ingreso_usuario_y_clave(String usuario, String clave) {
        System.out.println("--- [STEP] Ingresando usuario: " + usuario + " ---");
    }

//Simulacion de persona viendo pagina de inicio
    @Then("deberia ver la pagina de inicio")
    public void deberia_ver_la_pagina_de_inicio() {
        System.out.println("--- [STEP] Validando pagina de inicio ---");
        assertTrue(true);
    }
}