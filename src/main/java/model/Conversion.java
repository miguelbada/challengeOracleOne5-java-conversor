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
        return cantidad * moneda;
    }
}
