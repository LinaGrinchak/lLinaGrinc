package com.dgphoenix.gso81.temperature;

public abstract class TemperatureConverter {
    final static String DEGREE = "\u00b0";
    final static double POINT_FREEZING_OF_WATER_C_IN_K = 273.15;
    final static double COEFFICIENT_FAHRENHEIT = 1.8;
    final static double POINT_MELTING_C_IN_F = 32.0;
    final static double POINT_MELTING_F_IN_K = 459.67;
    public final static String CELSIUS = "C";
    public final static String FAHRENHEIT = "F";
    public final static String KELVIN = "K";

    public double convertFromCelsius(double C) {
        return C;
    }

    public double convertFromFahrenheit(double F) {
        return F;
    }

    public double convertFromKelvin(double K) {
        return K;
    }

    public double provideConvertedTemperature(String measure, double valueTemperature) throws Exception {
        switch (measure) {
            case CELSIUS:
                return convertFromCelsius(valueTemperature);
            case FAHRENHEIT:
                return convertFromFahrenheit(valueTemperature);
            case KELVIN:
                return convertFromKelvin(valueTemperature);
            default:
                throw new IllegalStateException("Unexpected value: " + measure);
        }
    }
}
