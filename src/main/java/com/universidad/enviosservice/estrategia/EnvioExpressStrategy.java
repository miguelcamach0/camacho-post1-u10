package com.universidad.enviosservice.estrategia;

public class EnvioExpressStrategy implements EstrategiaEnvio {

    @Override
    public double calcular(double pesoKg, double distanciaKm) {

        double costo = CalculadoraTramosPeso.calcular(
                pesoKg,
                distanciaKm,
                1.2,
                1.5,
                2.0
        );

        if (distanciaKm > 500) {
            costo += 25;
        }

        costo = costo * 1.3;

        return costo;
    }
}


