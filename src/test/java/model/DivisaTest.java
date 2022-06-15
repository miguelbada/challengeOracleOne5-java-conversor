package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DivisaTest {
    private Divisa listaPaises;

    @Before
    public void setUp() {
        listaPaises = new Divisa();
    }

    @Test
    public void testListaDePaises() {
        assertEquals("Se espera que denote el total de divisas", 170, listaPaises.getDivisas().length);
    }

    @Test
    public void TestGetMoneda() {
        String moneda = listaPaises.getMoneda("  \"ARS\": Argentine Peso");
        assertEquals("Se espera que retorne solo el simbolo de la moneda", "ARS", moneda);
    }
}
