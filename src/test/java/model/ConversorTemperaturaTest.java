package model;

import org.junit.Before;
import org.junit.Test;
import validacion.RegexInput;

import static org.junit.Assert.*;

public class ConversorTemperaturaTest {
    private UnidadDeMedida celsius;
    private UnidadDeMedida fahrenheit;
    private UnidadDeMedida kelvin;
    private ConversorTemperatura conversor;

    @Before
    public void setUp() {
        celsius = new UnidadDeMedida("Celsius", 0.0);
        fahrenheit = new UnidadDeMedida("Fahrenheit", 0.0);
        kelvin = new UnidadDeMedida("Kelvin", 0.0);
        conversor = new ConversorTemperatura();
    }

    @Test
    public void convertir32CelsiusAFahrenheit() {
        celsius.setValor(32.0);
        UnidadDeMedida resultado = conversor.convertirUnidad(celsius, fahrenheit);

        assertEquals("La unidad de medida de la conversion debería ser Fahrenheit","Fahrenheit", resultado.getNombre());
        assertEquals("El valor de la conversion debería ser 89.6", 89.6, resultado.getValor(), 0.0);
    }

    @Test
    public void convertir32CelsiusAKelvin() {
        celsius.setValor(32.0);
        UnidadDeMedida resultado = conversor.convertirUnidad(celsius, kelvin);

        assertEquals("La unidad de medida de la conversion debería ser Kelvin", "Kelvin", resultado.getNombre());
        assertEquals("El valor de la conversion debería ser 305.15", 305.15, resultado.getValor(), 0.0);
    }

    @Test
    public void convertirMenos32CelsiusACelcius() {
        celsius.setValor(-32.0);
        UnidadDeMedida resultado = conversor.convertirUnidad(celsius, celsius);

        assertEquals("La unidad de medida de la conversion debería ser Celsius","Celsius", resultado.getNombre());
        assertEquals("El valor de la conversion debería ser -32.0", -32.0, resultado.getValor(), 0.0);
    }

    @Test
    public void convertir78FahrenheitACelsius() {
        fahrenheit.setValor(78.0);
        UnidadDeMedida resultado = conversor.convertirUnidad(fahrenheit, celsius);

        assertEquals("La unidad de medida de la conversion debería ser Celsius", "Celsius", resultado.getNombre());
        assertEquals("El valor de la conversion debería ser 25.56", 25.56, resultado.getValor(), 0.0);
    }

    @Test
    public void convertir78FahrenheitAKelvin() {
        fahrenheit.setValor(78.0);
        UnidadDeMedida resultado = conversor.convertirUnidad(fahrenheit, kelvin);

        assertEquals("La unidad de medida de la conversion debería ser Kelvin", "Kelvin", resultado.getNombre());
        assertEquals("El valor de la conversion debería ser 298.71", 298.71, resultado.getValor(), 0.0);
    }

    @Test
    public void convertirMenos78FahrenheitAFahrenheit() {
        fahrenheit.setValor(-78.0);
        UnidadDeMedida resultado = conversor.convertirUnidad(fahrenheit, fahrenheit);

        assertEquals("La unidad de medida de la conversion debería ser Fahrenheit", "Fahrenheit", resultado.getNombre());
        assertEquals("El valor de la conversion debería ser -78.0", -78.0, resultado.getValor(), 0.0);
    }

    @Test
    public void convertir356KelvinACelcius() {
        kelvin.setValor(356.0);
        UnidadDeMedida resultado = conversor.convertirUnidad(kelvin, celsius);

        assertEquals("La unidad de medida de la conversion debería ser Celsius", "Celsius", resultado.getNombre());
        assertEquals("El valor de la conversion debería ser 82.85", 82.85, resultado.getValor(), 0.0);
    }

    @Test
    public void convertir356KelvinAFahrenheit() {
        kelvin.setValor(356.0);
        UnidadDeMedida resultado = conversor.convertirUnidad(kelvin, fahrenheit);

        assertEquals("La unidad de medida de la conversion debería ser Fahrenheit", "Fahrenheit", resultado.getNombre());
        assertEquals("El valor de la conversion debería ser 181.13", 181.13, resultado.getValor(), 0.0);
    }

    @Test
    public void convertirMenos356KelvinAKelvin() {
        kelvin.setValor(-356.0);
        UnidadDeMedida resultado = conversor.convertirUnidad(kelvin, kelvin);

        assertEquals("La unidad de medida de la conversion debería ser Kelvin", "Kelvin", resultado.getNombre());
        assertEquals("El valor de la conversion debería ser -356.0", -356.0, resultado.getValor(), 0.0);
    }
}
