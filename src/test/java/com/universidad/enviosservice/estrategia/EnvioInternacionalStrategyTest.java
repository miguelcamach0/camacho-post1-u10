package com.universidad.enviosservice.estrategia;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EnvioInternacionalStrategyTest {

    private final EnvioInternacionalStrategy estrategia =
            new EnvioInternacionalStrategy();

    @ParameterizedTest
    @CsvSource({
        "3.0, 100.0, 230.0",
        "5.0, 100.0, 230.0",
        "8.0, 100.0, 239.0",
        "20.0, 100.0, 275.0",
        "25.0, 100.0, 297.5",
        "3.0, 5000.0, 9050.0",
        "3.0, 5001.0, 9151.8"
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

