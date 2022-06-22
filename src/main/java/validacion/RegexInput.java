package validacion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexInput {

    public static Boolean validar(String number) {
        try {
            Pattern pattern = Pattern.compile("^-?\\d+(?:.\\d+)?$");
            Matcher matcher = pattern.matcher((number));

            return matcher.find();
        } catch (Exception e) {
            return false;
        }
    }
}
