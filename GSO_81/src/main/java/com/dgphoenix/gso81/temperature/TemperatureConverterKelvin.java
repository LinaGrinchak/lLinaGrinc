package com.dgphoenix.gso81.temperature;



public class TemperatureConverterKelvin extends TemperatureConverter {
    double temperature;
    private static TemperatureConverter temperatureConverter = new TemperatureConverterKelvin();

    TemperatureConverterKelvin() {
    }
    public static TemperatureConverter getInstance() {
        return temperatureConverter;
    }
    @Override
    public double convertFromCelsius(double C) {
        return C + POINT_FREEZING_OF_WATER_C_IN_K;
    }
    @Override
    public double convertFromFahrenheit(double F) {
        return (F + POINT_MELTING_F_IN_K) / COEFFICIENT_FAHRENHEIT;
    }
    @Override
    public double convertFromKelvin(double K){return K;
    }
}
