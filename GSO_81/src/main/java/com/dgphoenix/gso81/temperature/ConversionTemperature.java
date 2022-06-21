package com.dgphoenix.gso81.temperature;

import java.util.HashMap;
import java.util.Map;

import static com.dgphoenix.gso81.temperature.TemperatureConverter.*;

public class ConversionTemperature {
    private double value;
    private String measure;
    private String desiredMeasure;
    private static final String INCORRECTLY_MEASURE = "The unit of measurement is entered incorrectly.";
    private static final Map<String, TemperatureConverter> CONVERTER_MAP = new HashMap<String, TemperatureConverter>();

    static {
        CONVERTER_MAP.put(CELSIUS, TemperatureConverterCelsius.getInstance());
        CONVERTER_MAP.put(FAHRENHEIT, TemperatureConverterFahrenheit.getInstance());
        CONVERTER_MAP.put(KELVIN, TemperatureConverterKelvin.getInstance());
    }

    public ConversionTemperature(String value) throws Exception {
        if (value == null || !value.contains("=>")) {
            throw new Exception("Value incorrect");
        }
        String[] strArray = value.split("=>");
        int positionMeasure = strArray[0].length() - 1;
        this.value = Double.parseDouble(strArray[0].substring(0, positionMeasure));
        this.measure = String.valueOf(strArray[0].charAt(positionMeasure));
        checkMeasureValue(this.measure);
        this.desiredMeasure = strArray[1];
        checkMeasureValue(this.desiredMeasure);

    }

    private void checkMeasureValue(String measureValue) throws Exception {
        if (!(measureValue.equalsIgnoreCase(CELSIUS)
                || measureValue.equalsIgnoreCase(FAHRENHEIT) || measureValue.equalsIgnoreCase(KELVIN))) {
            throw new Exception(INCORRECTLY_MEASURE);
        }
    }

    private TemperatureConverter defineConvector() throws Exception {
        if (!CONVERTER_MAP.containsKey(desiredMeasure)) {
            throw new Exception(INCORRECTLY_MEASURE);
        }
        return CONVERTER_MAP.get(desiredMeasure);
    }

    private double convertTemperature() throws Exception {
        TemperatureConverter converter = defineConvector();
        return converter.provideConvertedTemperature(measure, value);
    }

    public String displayTemperature() throws Exception {
        double temperature = convertTemperature();
        return String.format("%.1f%s%s", temperature, DEGREE, desiredMeasure);
    }
}