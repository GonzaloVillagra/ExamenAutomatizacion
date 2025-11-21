package com.empresa;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraTest {

    @Test
    public void testSuma() {
        Calculadora cal = new Calculadora();
        int resultado = cal.sumar(2, 3);
        // Verificamos que 2 + 3 sea igual a 5
        assertEquals(5, resultado, "La suma de 2 + 3 debería ser 5");
    }
}