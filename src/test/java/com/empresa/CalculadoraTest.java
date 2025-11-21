package com.empresa;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraTest {

@Test
    public void testSuma{
        Calculadora cal = new Calculadora();
        int resultado = cal.sumar(51,65);
        assertEquals(116, resultado, "la suma deberia ser 116");
    }
}
