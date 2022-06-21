package com.dgphoenix.gso81.temperature;

public class TemperatureConverterCelsius extends TemperatureConverter {
    private static TemperatureConverter temperatureConverter = new TemperatureConverterCelsius();

    TemperatureConverterCelsius() {
    }

    public static TemperatureConverter getInstance() {
        return temperatureConverter;
    }

    @Override
    public double convertFromCelsius(double C) {
        return C;
    }

    @Override
    public double convertFromFahrenheit(double F) {
        return (F - POINT_MELTING_C_IN_F) / COEFFICIENT_FAHRENHEIT;
    }

    @Override
    public double convertFromKelvin(double K) {
        return K - POINT_FREEZING_OF_WATER_C_IN_K;
    }
}
