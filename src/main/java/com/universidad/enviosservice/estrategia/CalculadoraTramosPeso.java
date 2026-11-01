package com.universidad.enviosservice.estrategia;

final class CalculadoraTramosPeso {

    private CalculadoraTramosPeso() {
    }

    static double calcular(
            double pesoKg,
            double distanciaKm,
            double tarifaPorKm,
            double tarifaKgIntermedio,
            double tarifaKgSuperior) {

        double costo = distanciaKm * tarifaPorKm;

        if (pesoKg <= 5) {
            return costo;
        }

        if (pesoKg <= 20) {
            return costo + (pesoKg - 5) * tarifaKgIntermedio;
        }

        return costo
                + 15 * tarifaKgIntermedio
                + (pesoKg - 20) * tarifaKgSuperior;
    }
}
