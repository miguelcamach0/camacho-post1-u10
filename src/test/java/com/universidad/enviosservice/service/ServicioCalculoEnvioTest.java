package com.universidad.enviosservice.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ServicioCalculoEnvioTest {

    private final ServicioCalculoEnvio servicio = new ServicioCalculoEnvio();

    @Test
    void calculaEnvioEstandarPesoBajo() {
        double costo = servicio.calcularCosto("ESTANDAR", 3.0, 100.0, "REGULAR", false);
        assertEquals(50.0, costo, 0.01);
    }

    @Test
    void aplicaDescuentoClientePremium() {
        double costo = servicio.calcularCosto("ESTANDAR", 3.0, 100.0, "PREMIUM", false);
        assertEquals(45.0, costo, 0.01);
    }

    @Test
    void aplicaRecargoPorFragilidad() {
        ServicioCalculoEnvio servicio = new ServicioCalculoEnvio();

        double resultado = servicio.calcularCosto(
                "ESTANDAR", 3.0, 100.0, "REGULAR", true);

        assertEquals(57.5, resultado, 0.0001);
    }

    @Test
    void aplicaDescuentoCorporativo() {
        ServicioCalculoEnvio servicio = new ServicioCalculoEnvio();

        double resultado = servicio.calcularCosto(
                "ESTANDAR", 3.0, 100.0, "CORPORATIVO", false);

        assertEquals(42.5, resultado, 0.0001);
    }

    @Test
    void combinaRecargoPorFragilidadYDescuentoCorporativo() {
        ServicioCalculoEnvio servicio = new ServicioCalculoEnvio();

        double resultado = servicio.calcularCosto(
                "ESTANDAR", 3.0, 100.0, "CORPORATIVO", true);

        assertEquals(48.875, resultado, 0.0001);
    }

    @Test
    void rechazaMetodoDeEnvioNoSoportado() {
        ServicioCalculoEnvio servicio = new ServicioCalculoEnvio();

        IllegalArgumentException excepcion = assertThrows(
                IllegalArgumentException.class,
                () -> servicio.calcularCosto(
                        "DESCONOCIDO", 3.0, 100.0, "REGULAR", false));

        assertTrue(excepcion.getMessage().contains("no soportado"));
    }

}