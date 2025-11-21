package com.empresa;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class CalculadoraIT {

    @Test
    public void testSumaIntegracion() {
        System.out.println("--- Iniciando prueba de integración de Calculadora ---");
        Calculadora cal = new Calculadora();
        int resultado = cal.sumar(10, 20);
        assertEquals(30, resultado, "La suma de integración 10 + 20 debe ser 30");
        System.out.println("--- Prueba de integración finalizada con éxito ---");
    }
}