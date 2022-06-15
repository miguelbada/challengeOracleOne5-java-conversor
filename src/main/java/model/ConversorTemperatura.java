package model;

public class ConversorTemperatura {
    public ConversorTemperatura() {
    }

    public UnidadDeMedida convertirUnidad(UnidadDeMedida unidadA, UnidadDeMedida unidadB) {
        UnidadDeMedida conversion = unidadA;

        switch (unidadA.getNombre() + " To " + unidadB.getNombre()) {
            case "Celsius To Fahrenheit":
                conversion = this.convertirCelsiusToFahrenheit(unidadA, unidadB);
                break;
            case "Celsius To Kelvin":
                conversion = this.convertirCelsiusToKelvin(unidadA, unidadB);
                break;
            case "Fahrenheit To Celsius":
                conversion = this.convertirFahrenheitToCelsius(unidadA, unidadB);
                break;
            case "Fahrenheit To Kelvin":
                conversion = this.convertirFahrenheitToKelvin(unidadA, unidadB);
                break;
            case "Kelvin To Celsius":
                conversion = this.convertirKelvinToCelsius(unidadA, unidadB);
                break;
            case "Kelvin To Fahrenheit":
                conversion = this.convertirKelvinToFahrenheit(unidadA, unidadB);
                break;
        }

        return conversion;
    }

    private UnidadDeMedida convertirCelsiusToFahrenheit(UnidadDeMedida celsius, UnidadDeMedida fahrenheit) {
        Double resultado = (1.8 * celsius.getValor()) + 32.0;

        return new UnidadDeMedida(fahrenheit.getNombre(), getTwoDecimals(resultado));
    }

    private UnidadDeMedida convertirCelsiusToKelvin(UnidadDeMedida celsius, UnidadDeMedida kelvin) {
        Double resultado = celsius.getValor() + 273.15;

        return new UnidadDeMedida(kelvin.getNombre(), getTwoDecimals(resultado));
    }

    private UnidadDeMedida convertirFahrenheitToCelsius(UnidadDeMedida fahrenheit, UnidadDeMedida celsius) {
        Double resultado = (fahrenheit.getValor() - 32) / 1.8;

        return new UnidadDeMedida(celsius.getNombre(), getTwoDecimals(resultado));
    }

    private UnidadDeMedida convertirFahrenheitToKelvin(UnidadDeMedida fahrenhit, UnidadDeMedida kelvin) {
        return convertirUnidad(convertirFahrenheitToCelsius(fahrenhit, new UnidadDeMedida("Celsius", 0.0)), kelvin);
    }

    private UnidadDeMedida convertirKelvinToCelsius(UnidadDeMedida kelvin, UnidadDeMedida celsius) {
        Double resultado = kelvin.getValor() - 273.15;

        return new UnidadDeMedida(celsius.getNombre(), getTwoDecimals(resultado));
    }

    private UnidadDeMedida convertirKelvinToFahrenheit(UnidadDeMedida kelvin, UnidadDeMedida fahrenheit) {
        return convertirUnidad(convertirKelvinToCelsius(kelvin, new UnidadDeMedida("Celsius", 0.0)), fahrenheit);
    }

    private static Double getTwoDecimals(double value){
        return Math.round(value *100.0)/100.0;
    }
}

