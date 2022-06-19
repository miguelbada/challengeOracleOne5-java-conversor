package main;

import PeticionHttpExchangeController.PeticionHttpExchangeController;
import com.google.gson.Gson;
import model.Conversion;
import model.ConversorTemperatura;
import model.Divisa;
import model.UnidadDeMedida;
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
                Double cantidad = 0.0;
                String toOption = "";

                if(fromOption != null) {
                    cantidad = Double.valueOf(JOptionPane.showInputDialog("Seleccione la cantidad que desea convertir"));
                }

                if(cantidad > 0.0) {
                    toOption = (String) JOptionPane.showInputDialog(null,"Seleccione la moneda de conversión", "Menu", JOptionPane.QUESTION_MESSAGE,null, listaPaises, listaPaises[0]);
                }

                String base = divisas.getMoneda(fromOption);
                String rate = divisas.getMoneda(toOption);
                String url = "https://api.exchangerate.host/latest?base=" + base;

                PeticionHttpExchangeController peticion = new PeticionHttpExchangeController();
                String response = peticion.getExchange(url);

                Gson gson = new Gson();
                Conversion conversion = gson.fromJson(response, Conversion.class);

                Double respuesta = conversion.convertir(cantidad, conversion.getConversionTo(rate));

                JOptionPane.showMessageDialog(null, rate + " " + respuesta, toOption, JOptionPane.PLAIN_MESSAGE);
            } else {
                String [] grados = {"Celsius", "Fahrenheit", "Kelvin"};
                Double cantidad = 0.0;
                String toGrados = "";

                String fromGrados = (String) JOptionPane.showInputDialog(null,"Seleccione la unidad que desea convertir", "Menu", JOptionPane.QUESTION_MESSAGE,null, grados, grados[0]);

                if(fromGrados.length() > 0) {
                    cantidad = Double.valueOf(JOptionPane.showInputDialog("Seleccione el valor de la unidad"));
                }

                if(cantidad > 0.0) {
                    toGrados = (String) JOptionPane.showInputDialog(null,"Seleccione la unidad de conversión", "Menu", JOptionPane.QUESTION_MESSAGE,null, grados, grados[0]);
                }

                if(toGrados.length() > 0.0) {
                    ConversorTemperatura conversor = new ConversorTemperatura();
                    UnidadDeMedida unidadA = new UnidadDeMedida(fromGrados, cantidad);
                    UnidadDeMedida unidadB = new UnidadDeMedida(toGrados, 0.0);

                    UnidadDeMedida resultado = conversor.convertirUnidad(unidadA, unidadB);
                    JOptionPane.showMessageDialog(null, resultado.getNombre() + " " + resultado.getValor(), "Conversión de unidad", JOptionPane.PLAIN_MESSAGE);
                }
            }

            if (deseaContinuar()) break;
        }






/*

        *//*JsonObject convertedObject = gson.fromJson(respuesta, JsonObject.class);
        Map map = gson.fromJson(convertedObject.get("rates"), Map.class);
        System.out.println(map.get("ARS").getClass());*//*
        System.out.println(conversion.getBase());
        System.out.println(conversion.getConversionTo("USD"));*/


//        System.out.println(paises);

        /*Gson gson = new Gson();
        Map map = gson.fromJson(paises, HashMap.class);

        System.out.println(Arrays.toString(map.entrySet().toArray()));
        System.out.println(Arrays.toString(map.values().toArray()));
        System.out.println(map.toString());

        Object [] str =  map.entrySet().stream().map(Object::toString).collect(Collectors.toList()).toString();

        System.out.println(map.entrySet().stream().map(Object::toString).collect(Collectors.toList()).toString());
        System.out.println(map.values().toArray().getClass());
*/
    }

    private static boolean deseaContinuar() {
        Boolean continuar = false;
        int continuacion = JOptionPane.showConfirmDialog(null, "Deseas realizar otra conversión");

        if(JOptionPane.NO_OPTION == continuacion || JOptionPane.CANCEL_OPTION == continuacion) {
            JOptionPane.showMessageDialog(null, "Programa terminado");
            continuar = true;
        }
        return continuar;
    }


}


