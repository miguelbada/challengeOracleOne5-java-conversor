package main;

import PeticionHttpExchangeController.PeticionHttpExchangeController;
import com.google.gson.Gson;
import model.Conversion;
import model.ConversorTemperatura;
import model.Divisa;
import model.UnidadDeMedida;
import validacion.RegexInput;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {

        while (true) {
            String[] option = {"Conversor de Moneda", "Conversor de Temperatura"};
//
            String ConvertOption = (String) JOptionPane.showInputDialog(null,"Seleccione una opción de conversión", "Menu", JOptionPane.QUESTION_MESSAGE,null, option, option[0]);

            if(ConvertOption == "Conversor de Moneda") {
                Divisa divisas = new Divisa();
                String[] listaPaises = divisas.getDivisas();

                String fromOption = (String) JOptionPane.showInputDialog(null,"Seleccione la moneda que desea convertir", "Menu", JOptionPane.QUESTION_MESSAGE,null, listaPaises, listaPaises[0]);
                String cantidad = "";
                String toOption = "";

                if(fromOption != null) {
                    cantidad = JOptionPane.showInputDialog("Seleccione la cantidad que desea convertir");
                }

                if(RegexInput.validar(cantidad)) {
                    toOption = (String) JOptionPane.showInputDialog(null,"Seleccione la moneda de conversión", "Menu", JOptionPane.QUESTION_MESSAGE,null, listaPaises, listaPaises[0]);

                    String base = divisas.getMoneda(fromOption);
                    String rate = divisas.getMoneda(toOption);
                    String url = "https://api.exchangerate.host/latest?base=" + base;

                    PeticionHttpExchangeController peticion = new PeticionHttpExchangeController();
                    String response = peticion.getExchange(url);

                    Gson gson = new Gson();
                    Conversion conversion = gson.fromJson(response, Conversion.class);

                    Double respuesta = conversion.convertir(Double.valueOf(cantidad), conversion.getConversionTo(rate));

                    JOptionPane.showMessageDialog(null, rate + " " + respuesta, toOption, JOptionPane.PLAIN_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Debe ingresar un valor válido");
                }

            } else if(ConvertOption == "Conversor de Temperatura") {
                String [] grados = {"Celsius", "Fahrenheit", "Kelvin"};
                String cantidad = "";
                String toGrados = "";

                String fromGrados = (String) JOptionPane.showInputDialog(null,"Seleccione la unidad que desea convertir", "Menu", JOptionPane.QUESTION_MESSAGE,null, grados, grados[0]);

                if(fromGrados.length() > 0) {
                    cantidad = JOptionPane.showInputDialog("Seleccione el valor de la unidad");
                }

                if(RegexInput.validar(cantidad)) {
                    toGrados = (String) JOptionPane.showInputDialog(null,"Seleccione la unidad de conversión", "Menu", JOptionPane.QUESTION_MESSAGE,null, grados, grados[0]);

                    if(toGrados.length() > 0.0) {
                        ConversorTemperatura conversor = new ConversorTemperatura();
                        UnidadDeMedida unidadA = new UnidadDeMedida(fromGrados, Double.valueOf(cantidad));
                        UnidadDeMedida unidadB = new UnidadDeMedida(toGrados, 0.0);

                        UnidadDeMedida resultado = conversor.convertirUnidad(unidadA, unidadB);
                        JOptionPane.showMessageDialog(null, resultado.getNombre() + " " + resultado.getValor(), "Conversión de unidad", JOptionPane.PLAIN_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Debe ingresar un valor válido");
                }
            }

            if (!deseaContinuar()) break;
        }

    }

    private static boolean deseaContinuar() {
        Boolean continuar = true;
        int continuacion = JOptionPane.showConfirmDialog(null, "Deseas realizar otra conversión");

        if(JOptionPane.NO_OPTION == continuacion || JOptionPane.CANCEL_OPTION == continuacion) {
            JOptionPane.showMessageDialog(null, "Programa terminado");
            continuar = false;
        }
        return continuar;
    }


}


