package com.dgphoenix.gso81.temperature;

public class TemperatureConverterFahrenheit extends TemperatureConverter {
    private static TemperatureConverter temperatureConverter = new TemperatureConverterFahrenheit();

    TemperatureConverterFahrenheit() {
    }

    public static TemperatureConverter getInstance() {
        return temperatureConverter;
    }

    @Override
    public double convertFromCelsius(double C) {
        return C * COEFFICIENT_FAHRENHEIT + POINT_MELTING_C_IN_F;
    }

    @Override
    public double convertFromFahrenheit(double F) {
        return F;
    }

    @Override
    public double convertFromKelvin(double K) {
        return K * COEFFICIENT_FAHRENHEIT - POINT_MELTING_F_IN_K;
    }
}
