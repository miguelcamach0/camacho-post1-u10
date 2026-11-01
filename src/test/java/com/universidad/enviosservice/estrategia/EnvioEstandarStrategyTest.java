package com.universidad.enviosservice.estrategia;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EnvioEstandarStrategyTest {

    private final EnvioEstandarStrategy estrategia =
            new EnvioEstandarStrategy();

    @ParameterizedTest
    @CsvSource({
        "3.0, 100.0, 50.0",
        "5.0, 100.0, 50.0",
        "8.0, 100.0, 52.4",
        "20.0, 100.0, 62.0",
        "25.0, 100.0, 68.0",
        "3.0, 500.0, 250.0",
        "3.0, 501.0, 260.5"
    })
    void calculaCostoSegunPesoYDistancia(
            double pesoKg,
            double distanciaKm,
            double esperado) {

        assertEquals(
                esperado,
                estrategia.calcular(pesoKg, distanciaKm),
                0.0001
        );
    }
}

