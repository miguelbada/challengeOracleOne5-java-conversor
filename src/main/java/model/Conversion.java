package model;

import java.util.Map;

public class Conversion {
    private String base;
    private Map rates;

    public Conversion(String moneda, Map rates) {
        this.base = moneda;
        this.rates = rates;
    }

    public String getBase() {
        return this.base;
    }

    public Double getConversionTo(String monedaExtranjera) {
       return (Double) this.rates.get(monedaExtranjera);
    }

    public Double convertir(Double cantidad, Double moneda) {
        return getTwoDecimals(cantidad * moneda);
    }

    private static Double getTwoDecimals(double value) {
        return Math.round(value *100.0)/100.0;
    }
}
