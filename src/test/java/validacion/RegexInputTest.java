package validacion;

import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RegexInputTest {
    @Test
    public void validarInput() {
        String numero1 = "46.00";
        String numero2 = "46,42";
        String numero3 = "46";
        String letrasYNumeros = "hola45";
        String numeroNegativo = "-45";

        assertTrue(RegexInput.validar(numero1));
        assertTrue(RegexInput.validar(numero2));
        assertTrue(RegexInput.validar(numero3));
        assertFalse(RegexInput.validar(letrasYNumeros));
        assertTrue(RegexInput.validar(numeroNegativo));
    }
}
