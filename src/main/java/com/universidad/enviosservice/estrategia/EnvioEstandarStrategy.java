package com.universidad.enviosservice.estrategia;

public class EnvioEstandarStrategy implements EstrategiaEnvio {

    @Override
    public double calcular(double pesoKg, double distanciaKm) {

        double costo = CalculadoraTramosPeso.calcular(
                pesoKg,
                distanciaKm,
                0.5,
                0.8,
                1.2
        );

        if (distanciaKm > 500) {
            costo += 10;
        }

        return costo;
    }
}


