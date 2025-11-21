package com.empresa;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginSteps {

    @Given("estoy en la pagina de login")
    public void estoy_pagina_inicio(){
        System.out.println("--- [STEP] Abriendo pagina de login ---");
    }

    @When("Ingreso del usuario {string} y clave {string}")
    public void ingreso_usuario_clave(String nombre, String clave){
        System.out.println("--- [STEP] Ingresando Usuario ---");
    }

    @Then("deberia ver pagina de inicio")
    public void deberia_pagina_inicio(){
        System.out.println("--- [STEP] deberia ver la pagina de inicio --- ");
        assertTrue(true);
    }
}

