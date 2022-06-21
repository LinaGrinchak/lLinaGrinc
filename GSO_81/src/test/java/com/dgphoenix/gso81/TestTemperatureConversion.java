package com.dgphoenix.gso81;
import com.dgphoenix.gso81.temperature.ConversionTemperature;
import org.junit.Assert;
import org.junit.Test;
public class TestTemperatureConversion {

    @Test
    public void isExcessNull() {
        try {
            ConversionTemperature temperatureConversion = new ConversionTemperature(null);
            System.out.println(temperatureConversion.displayTemperature());
            Assert.fail("Expected Exception");
        } catch (Exception thrown) {
            Assert.assertEquals("Value incorrect", thrown.getMessage());
        }
    }

    @Test
    public void isExcessEmpty() {
        try {
            ConversionTemperature temperatureConversion = new ConversionTemperature("");
            System.out.println(temperatureConversion.displayTemperature());
            Assert.fail("Expected Exception");
        } catch (Exception thrown) {
            Assert.assertEquals("Value incorrect", thrown.getMessage());
        }
    }
    @Test
    public void isExcessIncorrect() {
        try {
            ConversionTemperature temperatureConversion = new ConversionTemperature("100CF");
            System.out.println(temperatureConversion.displayTemperature());
            Assert.fail("Expected Exception");
        } catch (Exception thrown) {
            Assert.assertEquals("Value incorrect", thrown.getMessage());
        }
    }
    @Test
    public void isExcessMeasure() {
        try {
            ConversionTemperature temperatureConversion = new ConversionTemperature("40T=>K");
            System.out.println(temperatureConversion.displayTemperature());
            Assert.fail("Expected Exception");
        } catch (Exception thrown) {
            Assert.assertEquals("The unit of measurement is entered incorrectly.", thrown.getMessage());
        }
    }
    @Test
    public void isExcessDesiredMeasure() {
        try {
            ConversionTemperature temperatureConversion = new ConversionTemperature("40K=>S");
            System.out.println(temperatureConversion.displayTemperature());
            Assert.fail("Expected Exception");
        } catch (Exception thrown) {
            Assert.assertEquals("The unit of measurement is entered incorrectly.", thrown.getMessage());
        }
    }
    @Test
    public void isExcessTemperature() {
        try {
            ConversionTemperature temperatureConversion = new ConversionTemperature("40TC=>K");
            System.out.println(temperatureConversion.displayTemperature());
            Assert.fail("Expected Exception");
        } catch (Exception thrown) {
            Assert.assertEquals("For input string: \"40T\"", thrown.getMessage());
        }
    }
    @Test
    public void isExcessEmptyTemperature() {
        try {
            ConversionTemperature temperatureConversion = new ConversionTemperature("C=>K");
            System.out.println(temperatureConversion.displayTemperature());
            Assert.fail("Expected Exception");
        } catch (Exception thrown) {
            Assert.assertEquals("empty String", thrown.getMessage());
        }
    }
    @Test
    public void isCelsiusInCelsius() throws Exception {
        String expected = "10,0°C";
        ConversionTemperature temperatureConversion = new ConversionTemperature("10C=>C");
        Assert.assertEquals(expected, temperatureConversion.displayTemperature());
    }

    @Test
    public void isCelsiusInFahrenheit() throws Exception {
        String expected = "212,0°F";
        ConversionTemperature temperatureConversion = new ConversionTemperature("100C=>F");
        Assert.assertEquals(expected, temperatureConversion.displayTemperature());
    }

    @Test
    public void isCelsiusInKelvin() throws Exception {
        String expected = "313,2°K";
        ConversionTemperature temperatureConversion = new ConversionTemperature("40C=>K");
        Assert.assertEquals(expected, temperatureConversion.displayTemperature());
    }
    @Test
    public void isFahrenheitInCelsius() throws Exception {
        String expected = "-12,2°C";
        ConversionTemperature temperatureConversion = new ConversionTemperature("10F=>C");
        Assert.assertEquals(expected, temperatureConversion.displayTemperature());
    }

    @Test
    public void isFahrenheitInFahrenheit() throws Exception {
        String expected = "100,0°F";
        ConversionTemperature temperatureConversion = new ConversionTemperature("100F=>F");
        Assert.assertEquals(expected, temperatureConversion.displayTemperature());
    }

    @Test
    public void isFahrenheitInKelvin() throws Exception {
        String expected = "277,6°K";
        ConversionTemperature temperatureConversion = new ConversionTemperature("40F=>K");
        Assert.assertEquals(expected, temperatureConversion.displayTemperature());
    }
    @Test
    public void isKelvinInCelsius() throws Exception {
        String expected = "36,9°C";
        ConversionTemperature temperatureConversion = new ConversionTemperature("310.0K=>C");
        Assert.assertEquals(expected, temperatureConversion.displayTemperature());
    }
    @Test
    public void isKelvinInFahrenheit() throws Exception {
        String expected = "-279,7°F";
        ConversionTemperature temperatureConversion = new ConversionTemperature("100K=>F");
        Assert.assertEquals(expected, temperatureConversion.displayTemperature());
    }

    @Test
    public void  isKelvinInKelvin() throws Exception {
        String expected = "40,0°K";
        ConversionTemperature temperatureConversion = new ConversionTemperature("40K=>K");
        Assert.assertEquals(expected, temperatureConversion.displayTemperature());
    }
}
